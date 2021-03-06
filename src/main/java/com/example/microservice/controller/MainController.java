package com.example.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class MainController {

    @Value("${http.server.url}")
    String httpServerUrl;

    @GetMapping("/http")
    public String http() {

        try {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response
                    = restTemplate.getForEntity(httpServerUrl + "/ms2", String.class);
            return response.getBody().toString().replace("HTTP_SERVER_URL", httpServerUrl);
        } catch (Exception e) {
            log.error(e.toString());
            return "[Failed]Microservice 1 Invoke Microservice 2 [" + httpServerUrl + "] via HTTP Failed.";
        }
    }

    @GetMapping("/http2")
    public String http2() {

        try {
            RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());

            ResponseEntity<String> response
                    = restTemplate.getForEntity(httpServerUrl + "/ms2http2", String.class);
            return response.getBody().toString().replace("HTTP_SERVER_URL", httpServerUrl);
        } catch (Exception e) {
            log.error(e.toString());
            return "[Failed]Microservice 1 Invoke Microservice 2 [" + httpServerUrl + "] via HTTP2 Failed.";
        }
    }

    @GetMapping("/ms2")
    public String ms2() {
        return "[Successed]Microservice 1 Invoke Microservice 2 [HTTP_SERVER_URL] via HTTP Successed.";
    }

    @GetMapping("/ms2http2")
    public String ms2http2() {
        return "[Successed]Microservice 1 Invoke Microservice 2 [HTTP_SERVER_URL] via HTTP2 Successed.";
    }
}
