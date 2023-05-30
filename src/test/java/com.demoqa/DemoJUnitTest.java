package com.demoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DemoJUnitTest {
    @Test
    void firstTest() {
        int result = 2 + 2;
        Assertions.assertTrue(result == 4);
    }
}
