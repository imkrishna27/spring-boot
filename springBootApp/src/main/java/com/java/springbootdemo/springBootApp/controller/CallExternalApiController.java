package com.java.springbootdemo.springBootApp.controller;

import com.java.springbootdemo.springBootApp.controller.FeignClients.FeignUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/externalApi")
@Log4j2
public class CallExternalApiController {

    /**
     * <dependency>
     *     <groupId>org.springframework.boot</groupId>
     *     <artifactId>spring-boot-starter-webflux</artifactId>
     * </dependency>
     */
    private final WebClient webClient;

    /**
     <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-openfeign-core</artifactId>
     <version>4.0.1</version>
     </dependency>

     <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-openfeign</artifactId>
     <version>4.0.1</version>
     </dependency>
     */
    private final FeignUtil feignUtil;

    private final HttpClient httpClient;

    @Autowired
    public CallExternalApiController(WebClient webClient, FeignUtil feignUtil) {
        this.webClient = webClient;
        this.feignUtil = feignUtil;
        this.httpClient =  HttpClient.newBuilder().build();
    }

    @GetMapping(produces = {"text/plain", "application/*"}, value = "/restTemplate")
    public String callUsingRestTemplate() {
        // Prepare acceptable media type
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        // Prepare header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        Long id =1L;
        ResponseEntity<String> exchange = restTemplate.exchange("https://jsonplaceholder.typicode.com/comments", HttpMethod.GET, entity, String.class);
        log.info("data from response: {} ", exchange.getBody());
        return exchange.getBody();
    }

    @GetMapping(produces = {"text/plain", "application/*"}, value = "/webClient")
    public String callUsingWebClient() {
        Mono<String> stringMono = webClient.get().uri("https://jsonplaceholder.typicode.com/comments").retrieve().bodyToMono(String.class);
        return stringMono.block(); // subscribe to mono
    }

    @GetMapping(produces = {"text/plain", "application/*"}, value = "/feignClient")
    public String callUsingFeignClient() {
        return feignUtil.getComments();
    }

    @GetMapping(produces = {"text/plain", "application/*"}, value = "/httpClient")
    public String callUsingHttpClient() throws IOException, InterruptedException {
        java.net.http.HttpRequest build = java.net.http.HttpRequest.newBuilder().GET().uri(URI.create("https://jsonplaceholder.typicode.com/comments")).build();
        // to send request we use http-client
        HttpResponse<String> send = httpClient.send(build, HttpResponse.BodyHandlers.ofString());
        return  send.body();
    }
}
