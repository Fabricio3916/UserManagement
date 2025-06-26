package com.velvet.UserManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_banned_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class BannedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "discord_username")
    private String discordUserName;

    @Column(name = "discord_id", unique = true)
    private String discordId;

    @Column(name="ban_reason")
    private String banReason;

    @Column(name = "date_of_ban")
    private LocalDateTime dateOfBan;


}
