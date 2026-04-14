package com.jobmatch.portal.repository;

import com.jobmatch.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}