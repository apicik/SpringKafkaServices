package com.example.springkafkaservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SpringKafkaServicesApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(
                () -> SpringKafkaServicesApplication.main(new String[]{})
        );
    }

}
