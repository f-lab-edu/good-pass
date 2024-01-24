package com.goodchalk.goodpass.climbinggym.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("climbing_gym")
@Getter
@NoArgsConstructor
public class ClimbingGym {
    @Id
    @Column("id")
    private Long id;
    @Column("climbing_gym_name")
    private String climbingGymName;
    @Column("address")
    private String address;
    @Column("owner")
    private String owner;
    @Column("contact")
    private String contact;
    @Column("email")
    private String email;
    @Column("poster_link")
    private String posterLink;

    @Builder
    public ClimbingGym(Long id, String climbingGymName, String address, String owner, String contact, String email, String posterLink) {
        this.id = id;
        this.climbingGymName = climbingGymName;
        this.address = address;
        this.owner = owner;
        this.contact = contact;
        this.email = email;
        this.posterLink = posterLink;
    }

    public void updatePosterLink(String posterLink) {
        this.posterLink = posterLink;
    }
}