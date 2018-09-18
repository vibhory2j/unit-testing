package com.vibhor.testing.unittesting;

import com.lightstep.tracer.jre.JRETracer;
import io.opentracing.Tracer;
import io.opentracing.noop.NoopTracerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.lightstep.tracer.shared.Options;


@Configuration
@AutoConfigureBefore(name = {
        "io.opentracing.contrib.spring.web.autoconfig.TracerAutoConfiguration",
        "io.opentracing.contrib.spring.tracer.configuration.TracerAutoConfiguration"})
@EnableConfigurationProperties(LightstepProperties.class)
public class LightstepConfiguration {

    private static final Logger log = LoggerFactory.getLogger(LightstepConfiguration.class);

    @Bean
    @ConditionalOnMissingBean(Tracer.class)
    @ConditionalOnProperty(prefix = "opentracing.lightstep",
            name = { "access_token", "collector_host", "collector_port", "component_name" })
    public Tracer tracer(LightstepProperties properties) {

        try {
            Options options = new Options.OptionsBuilder()
                    .withAccessToken(properties.getAccessToken())
                    .withCollectorHost(properties.getCollectorHost())
                    .withCollectorPort(properties.getCollectorPort())
                    .withComponentName(properties.getComponentName())
                    .withMaxBufferedSpans(properties.getMaxBufferedSpans())
                    .withVerbosity(4)
                    .build();

            Tracer tracer = new JRETracer(options);
            log.info("Initialized Lightstep Tracer");
            return tracer;
        } catch (Exception ex) {
            //  Catch all.  We do not want invalid tracer configuration to bring down an entire application.
            //  The config class contains secrets, and out of order config values is a common failure.  We
            //  should not display any exception content beyond its class (still helpful):
            log.error("Invalid Lightstep configuration.  Returning a NoopTracer: {}", ex.getClass());

            //  Common configuration error - wrong dependencies regarding ALPN support:
            if (ex.getMessage() != null && ex.getMessage().contains("Jetty ALPN/NPN has not been properly configured")) {
                log.error(ex.getMessage());
            }

            return NoopTracerFactory.create();
        }
    }
}
