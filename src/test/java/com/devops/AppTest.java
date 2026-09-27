package com.devops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testMessage() {
        assertEquals(
            "DevOps CI/CD pipeline is working - webhook test!",
            App.getMessage()
        );
    }
}
