package com.velvet.UserManagement.service;

import com.velvet.UserManagement.model.BannedUser;
import com.velvet.UserManagement.repository.BannedUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class BannedUserService {

    private final BannedUserRepository repository;

    public BannedUserService(BannedUserRepository repository) {
        this.repository = repository;
    }

    public BannedUser createRegister(BannedUser newBannedUser){
        return repository.save(newBannedUser);
    }

    public List<BannedUser> listBannedUsers(){
        return repository.findAll();
    }

    public BannedUser listById(Integer id){
        Optional<BannedUser> userFound = repository.findById(id);
        return userFound.orElse(null);
    }

    public BannedUser listByDiscordId(String discordId){
        return repository.findByDiscordId(discordId).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));

    }

    public BannedUser listByDiscordUsermame(String discordUserName){
        Optional<BannedUser> listedUser = repository.findBydiscordUserName(discordUserName);
        return listedUser.orElse(null);
    }

    public void deleteByDiscordId(String discordId){
        repository.deleteByDiscordId(discordId);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public BannedUser updateUserInfo(Integer id, BannedUser updatedUserinfo){
        BannedUser existingUser =  listById(id);
        if (existingUser != null) {
            BannedUser updatedUser = BannedUser.builder()
                    .discordId(updatedUserinfo != null ? updatedUserinfo.getDiscordId() : existingUser.getDiscordId())
                    .discordUserName(updatedUserinfo != null ? updatedUserinfo.getDiscordUserName() : existingUser.getDiscordUserName())
                    .banReason(updatedUserinfo != null ? updatedUserinfo.getBanReason() : existingUser.getBanReason())
                    .dateOfBan(updatedUserinfo != null ? updatedUserinfo.getDateOfBan() : existingUser.getDateOfBan())
                    .id(existingUser.getId())
                    .build();
          return repository.save(updatedUser);
        }
        return null;
    }



}
