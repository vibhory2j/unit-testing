package com.vibhor.testing.unittesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        //assertThat(numbers, hasSize(3));
        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x > 10);
        //assertThat(numbers, hasItems(12, 45));
        //assertThat(numbers, everyItem(greaterThan(10)));
        //assertThat(numbers, everyItem(lessThan(50)));

        //assertThat("", isEmptyString());
        assertThat("").isEmpty();
        //assertThat("ABCDE", containsString("BCD"));
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("DE");
        //assertThat("ABCDE", startsWith("ABCD"));
        //assertThat("ABCDE", endsWith("BCDE"));
    }
}
