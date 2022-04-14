package com.example.microservice.controller;


import com.example.microservice.service.HelloGrpcClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class GrpcController {

    @Resource
    private HelloGrpcClientServiceImpl helloGrpcClientService;

    @Value("${grpc.client.grpc-sb-server.address}")
    String grpcServerUrl;

    @GetMapping("/grpc")
    public String grpc() {

        try {
//            helloGrpcClientService.sayHello();
//            helloGrpcClientService.sayHelloServerStream();
//            helloGrpcClientService.sayHelloClientStream();
//            helloGrpcClientService.sayHelloBiStream();
            return helloGrpcClientService.invokeGrpc2().replace("GRPC_SERVER_URL",grpcServerUrl);
        } catch (Exception e) {
            log.error(e.toString());
            return "[Failed]Microservice 1 Invoke Microservice 2 [" + grpcServerUrl + "] via GRPC Failed.";
        }
    }
}
