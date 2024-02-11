package com.bootcamptoprod.springcloudloadbalancer.client;

import com.bootcamptoprod.springcloudloadbalancer.config.EchoServiceConfiguration;
import com.bootcamptoprod.springcloudloadbalancer.config.SayHelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@LoadBalancerClients({
        @LoadBalancerClient(name = "echo-service", configuration = EchoServiceConfiguration.class),
        @LoadBalancerClient(name = "say-hello", configuration = SayHelloServiceConfiguration.class)
})
public class LoadBalancedClient {

    @Autowired
    RestTemplate restTemplate;

    public String echo(String message) {
        return restTemplate.getForObject("http://echo-service/echo/" + message, String.class);
    }

    public String greetings() {
        return restTemplate.getForObject("http://say-hello/hello", String.class);
    }
}
