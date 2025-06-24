package com.velvet.UserManagement.repository;

import com.velvet.UserManagement.model.BannedUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BannedUserRepository extends JpaRepository<BannedUser, Integer> {

     Optional<BannedUser> findByDiscordId(String discordId);

     Optional<BannedUser> findBydiscordUserName(String discordUserName);

     @Transactional
     void deleteByDiscordId(String discordId);

}
