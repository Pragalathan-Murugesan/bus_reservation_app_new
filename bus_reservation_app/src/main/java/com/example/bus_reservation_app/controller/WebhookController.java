package com.example.bus_reservation_app.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class WebhookController {

    @PostMapping("/trigger-webhook")
    public String triggerWebhook() {

//         Prepare data to send
        String dataToSend = "This is data to send via webhook";

        // Define the URL of the second service's webhook endpoint
        String webhookUrl = "http://localhost:8083/new/webhook";

        // Make an HTTP POST request to the second service's webhook endpoint
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(webhookUrl, dataToSend, String.class);
        System.out.println(dataToSend);
        return dataToSend;
    }
}

