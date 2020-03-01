package com.example.copsboot.orm.jpa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.MappedSuperclass;

import com.example.copsboot.util.ArtifactForFramework;

import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@Getter
@ToString
public abstract class AbstractEntityId<T extends Serializable> implements Serializable, EntityId<T> {

    private static final long serialVersionUID = 1L;
    private T id;

    @ArtifactForFramework
    protected AbstractEntityId() {
    }

    protected AbstractEntityId(T id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public String asString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        
        if (this == o) {
            result = true;
        } else if (o instanceof AbstractEntityId) {
            var other = (AbstractEntityId) o;
            result = Objects.equals(id, other.id);
        }

        return result;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

}