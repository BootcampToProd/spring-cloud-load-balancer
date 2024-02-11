package com.bootcamptoprod.springcloudloadbalancer.conrtoller;

import com.bootcamptoprod.springcloudloadbalancer.client.LoadBalancedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudLoadBalancerController {

    private final LoadBalancedClient loadBalancedClient;

    public SpringCloudLoadBalancerController(LoadBalancedClient loadBalancedClient) {
        this.loadBalancedClient = loadBalancedClient;
    }

    @GetMapping("/user")
    public String user() {
        return loadBalancedClient.greetings();

    }

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        return loadBalancedClient.echo(message);

    }
}
