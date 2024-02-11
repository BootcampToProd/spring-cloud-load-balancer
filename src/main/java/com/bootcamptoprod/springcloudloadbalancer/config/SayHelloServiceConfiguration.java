package com.bootcamptoprod.springcloudloadbalancer.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SayHelloServiceConfiguration {

    @Bean
    public static ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {

        // Here, you can add the details of service which you want to call in a load balanced manner
        // Add details like host name and port number
        ServiceInstanceListSupplier serviceInstanceListSupplier = ServiceInstanceListSuppliers.from("say-hello",
                new DefaultServiceInstance("myservice1", "say-hello", "localhost", 8081, false),
                new DefaultServiceInstance("myservice2", "say-hello", "localhost", 8082, false)
        );

        return ServiceInstanceListSupplier.builder()
                .withBase(serviceInstanceListSupplier)
                .build(context);

    }
}
