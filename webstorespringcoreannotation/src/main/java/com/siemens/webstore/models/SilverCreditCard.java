package com.siemens.webstore.models;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Component
public class SilverCreditCard extends CreditCard{

    private long usageLimit;
    @Autowired
    private RestTemplate restTemplate;


    public String getCountryData(){
        ResponseEntity responseEntity=restTemplate.getForEntity("https://restcountries.com/v2/all",String.class);
         return responseEntity.getBody().toString();
    }
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Pre destroy invoked....");
    }
}
