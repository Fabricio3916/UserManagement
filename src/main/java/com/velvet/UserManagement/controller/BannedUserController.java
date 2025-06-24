package com.velvet.UserManagement.controller;

import com.velvet.UserManagement.model.BannedUser;
import com.velvet.UserManagement.service.BannedUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class BannedUserController {

    private final BannedUserService service;

    public BannedUserController(BannedUserService service) {
        this.service = service;
    }

    @GetMapping("/list/{id}")
    public List<BannedUser> listAllBannerUsers(){
        return service.listBannedUsers();
    }

    @GetMapping("/listByDiscordId/{discordId}")
    public BannedUser listByDiscordId(@PathVariable String discordId){
        return service.listByDiscordId(discordId);
    }



}
