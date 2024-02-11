package com.bootcamptoprod.springcloudloadbalancer.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EchoServiceConfiguration {

    @Bean
    public static ServiceInstanceListSupplier echoServiceInstanceListSupplier(ConfigurableApplicationContext context) {

        // Here, you can add the details of service which you want to call in a load balanced manner
        // Add details like host name and port number
        ServiceInstanceListSupplier from = ServiceInstanceListSuppliers.from("echo",
                new DefaultServiceInstance("myservice3", "echo", "localhost", 8083, false),
                new DefaultServiceInstance("myservice4", "echo", "localhost", 8084, false)
        );

        return ServiceInstanceListSupplier.builder()
                .withBase(from)
                .build(context);
    }
}
