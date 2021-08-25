package com.gladunalexander.playerbenefitsservice.aerospike;

import com.aerospike.client.Host;
import com.gladunalexander.playerbenefitsservice.PlayerBenefitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableAerospikeRepositories(basePackageClasses = PlayerBenefitsRepository.class)
@RequiredArgsConstructor
public class AerospikeConfiguration extends AbstractAerospikeDataConfiguration {

    private final AerospikeConfigurationProperties aerospikeConfigurationProperties;

    @Override
    protected Collection<Host> getHosts() {
        var hosts = Host.parseHosts(
                aerospikeConfigurationProperties.getHost(),
                aerospikeConfigurationProperties.getPort());
        return List.of(hosts);
    }

    @Override
    protected String nameSpace() {
        return aerospikeConfigurationProperties.getNamespace();
    }
}
