package com.velvet.UserManagement.controller;

import com.velvet.UserManagement.model.BannedUser;
import com.velvet.UserManagement.service.BannedUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class BannedUserController {

    private final BannedUserService service;

    public BannedUserController(BannedUserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public BannedUser createRegister(BannedUser newRegister){
        return service.createRegister(newRegister);
    }

    @GetMapping("/list")
    public List<BannedUser> listAllBannerUsers(){
        return service.listBannedUsers();
    }

    @GetMapping("/listById/{id}")
    public BannedUser listById(@PathVariable Integer id){
        return service.listById(id);
    }

    @GetMapping("/listByDiscordId/{discordId}")
    public BannedUser listByDiscordId(@PathVariable String discordId){
        return service.listByDiscordId(discordId);
    }

    @PutMapping("/updateById/{id}")
    public BannedUser updateUser(@PathVariable Integer id, @RequestBody BannedUser userUpdated){
        return service.updateUserInfo(id, userUpdated);
    }

    @DeleteMapping("/deleteByDiscordId/{discordId}")
    public void deleteUSerByDiscordId (@PathVariable String discordId){
        service.deleteByDiscordId(discordId);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }


}
