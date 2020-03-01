package com.example.copsboot.entities.user;

import com.example.copsboot.enumTypes.UserRole;
import com.example.copsboot.orm.jpa.AbstractEntity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="user")
public class User extends AbstractEntity<UserId> {
    @Id
    private UserId id;
    private String email;
    private String password;

    public User(UserId id, String email, String pw, Set<UserRole> roles) {
        super(id);
        this.email = email;
        this.password = pw;
        this.roles = roles;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<UserRole> roles;
}
