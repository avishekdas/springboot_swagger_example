package com.ibm.maersk.restframework.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ibm.maersk.restframework.domain"})
@EnableJpaRepositories(basePackages = {"com.ibm.maersk.restframework.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
