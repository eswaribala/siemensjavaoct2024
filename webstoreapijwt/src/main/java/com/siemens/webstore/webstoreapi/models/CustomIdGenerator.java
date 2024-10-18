package com.siemens.webstore.webstoreapi.models;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.UUID;


public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        // Generate a custom ID, e.g., a UUID-based or other logic
        return "CUS-" + UUID.randomUUID().toString();
    }
}
