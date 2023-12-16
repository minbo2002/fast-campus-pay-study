package com.example.paekaempay.infrastructure.user;

import com.example.paekaempay.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
