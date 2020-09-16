package com.tradesurveillance.frontrunningdetectionservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
public class FrontRunningDetectionResource {

    @GetMapping("/front-running-detection")
    public List<Trade> getFrontRunningTrades(){
        List<Trade> frontRunningTrades = FrontRunning.frontRunningdetection(trades);
        return frontRunningTrades
    }
}