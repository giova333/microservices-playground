package com.gladunalexander.playerbenefitsservice.aerospike;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConfigurationProperties(prefix = "aerospike")
@ConstructorBinding
public class AerospikeConfigurationProperties {
    Integer port;
    String host;
    String namespace;
}
