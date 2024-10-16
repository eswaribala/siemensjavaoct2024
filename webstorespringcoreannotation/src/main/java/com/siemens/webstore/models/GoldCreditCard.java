package com.siemens.webstore.models;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Component
public class GoldCreditCard extends CreditCard{

    private float cashback;
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Pre destroy invoked....");
    }
}
