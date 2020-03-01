package com.example.copsboot.repositories.user;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.HashSet;

import com.example.copsboot.entities.user.User;
import com.example.copsboot.enumTypes.UserRole;
import com.example.copsboot.repositories.user.UserRepositoryImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepositoryImpl userRepo;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = userRepo.save(new User(
                userRepo.nextId(),
                "ma@example.com",
                "geheim",
                roles));

        assertThat(user, not(nullValue()));
        assertThat(userRepo.count(), equalTo(1L));

    }

    //@TestConfiguration
}
