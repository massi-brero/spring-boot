package com.example.copsboot.repositories.user;

import java.util.UUID;

import com.example.copsboot.entities.user.UserId;
import com.example.copsboot.orm.jpa.UniqueIdGenerator;

/**
 * UserRepositoryImpl
 */
public class UserRepositoryImpl implements UserRepository {
    private final UniqueIdGenerator<UUID> generator;

    private UserRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public UserId nextId() {
        return new UserId(generator.getNextId());
    }

    //@TestConfigurat
    
}