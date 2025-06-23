package com.velvet.UserManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_banned_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BannedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discord_username")
    private String discordUserName;

    @Column(name = "discord_id")
    private Integer discordId;

    @Column(name="ban_reason")
    private String banReason;

    @Column(name = "date_of_ban")
    private LocalDateTime dateOfBan;


}
