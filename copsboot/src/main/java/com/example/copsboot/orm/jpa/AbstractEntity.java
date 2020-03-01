package com.example.copsboot.orm.jpa;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import com.example.copsboot.util.ArtifactForFramework;

import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@Getter
@ToString
public abstract class AbstractEntity<T extends EntityId> implements Entity<T> {

    @EmbeddedId
    private T id;

    @ArtifactForFramework
    protected AbstractEntity() {
    }

    protected AbstractEntity(T id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        
        if (this == o) {
            result = true;
        } else if (o instanceof AbstractEntity) {
            var other = (AbstractEntity) o;
            result = Objects.equals(id, other.id);
        }

        return result;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

}