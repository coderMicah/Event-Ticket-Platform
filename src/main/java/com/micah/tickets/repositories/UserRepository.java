package com.micah.tickets.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micah.tickets.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
