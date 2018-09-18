package com.vibhor.testing.unittesting;

import com.lightstep.tracer.shared.Options;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("opentracing.lightstep")
public class LightstepProperties {

    private String componentName;
    private String collectorHost;
    private int collectorPort;
    private String accessToken;
    private int maxBufferedSpans = Options.DEFAULT_MAX_BUFFERED_SPANS;
    private int verbosity = Options.VERBOSITY_FIRST_ERROR_ONLY;

    public int getMaxBufferedSpans() { return maxBufferedSpans; }

    public void setMaxBufferedSpans(int maxBufferedSpans) { this.maxBufferedSpans = maxBufferedSpans; }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getCollectorHost() {
        return collectorHost;
    }

    public void setCollectorHost(String collectorHost) {
        this.collectorHost = collectorHost;
    }

    public int getCollectorPort() {
        return collectorPort;
    }

    public void setCollectorPort(int collectorPort) {
        this.collectorPort = collectorPort;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getVerbosity() {
        return verbosity;
    }

    public void setVerbosity(int verbosity) {
        this.verbosity = verbosity;
    }

    @Override
    public String toString() {
        return "LightstepProperties{" +
                "componentName='" + componentName + '\'' +
                ", collectorHost='" + collectorHost + '\'' +
                ", collectorPort=" + collectorPort +
                ", maxBufferedSpans=" + maxBufferedSpans +
                ", verbosity=" + verbosity +
                '}';
    }
}
