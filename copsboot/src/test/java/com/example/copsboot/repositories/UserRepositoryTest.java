package com.example.copsboot.repositories;

import com.example.copsboot.entities.User;
import com.example.copsboot.enumTypes.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.HashSet;
import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = userRepo.save(new User(
                UUID.randomUUID(),
                "ma@example.com",
                "geheim",
                roles));

        assertThat(user, not(nullValue()));
        assertThat(userRepo.count(), equalTo(1L));

    }
}
