package com.example.copsboot.entities.user;

import java.util.UUID;
import com.example.copsboot.orm.jpa.AbstractEntityId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId extends AbstractEntityId<UUID> {

    private static final long serialVersionUID = -5774562244503395352L;

    public UserId(UUID id) {
        super(id);
    }

}