package com.example.copsboot.repositories.user;

import com.example.copsboot.entities.user.User;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

interface UserRepository extends CrudRepository<User, UUID>, UserRepositoyCustom {
}
