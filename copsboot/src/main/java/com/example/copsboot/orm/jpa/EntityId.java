package com.example.copsboot.orm.jpa;


public interface EntityId<T> {
    T getId();

    String asString();
}
