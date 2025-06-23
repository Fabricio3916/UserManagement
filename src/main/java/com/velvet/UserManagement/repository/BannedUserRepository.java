package com.velvet.UserManagement.repository;

import com.velvet.UserManagement.model.BannedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedUserRepository extends JpaRepository<BannedUser, Integer> {
}
