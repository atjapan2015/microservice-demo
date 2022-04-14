package com.example.microservice.config;

import com.example.microservice.interceptor.LogGrpcServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class GlobalServerInterceptorConfiguration {

    @GrpcGlobalServerInterceptor
    LogGrpcServerInterceptor logServerInterceptor() {
        return new LogGrpcServerInterceptor();
    }

}