package com.example.copsboot.orm.jpa;

import java.util.UUID;

/**
 * InMemoryUniqueIdGenerator
 */
public class InMemoryUniqueIdGenerator implements UniqueIdGenerator<UUID> {

    @Override
    public UUID getNextId() {
        return UUID.randomUUID();
    }
    
}