package com.gladunalexander.playerbenefitsservice;

import com.gladunalexander.playerbenefitsservice.aerospike.AerospikeConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AerospikeConfigurationProperties.class)
public class PlayerBenefitsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerBenefitsServiceApplication.class, args);
    }
}
