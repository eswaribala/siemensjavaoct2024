package com.siemens.webstore.models;

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
public class CreditCard {
    protected long creditCardNo;
    protected int cvv;
}
