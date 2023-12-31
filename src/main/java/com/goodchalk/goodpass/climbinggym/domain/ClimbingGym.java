package com.goodchalk.goodpass.climbinggym.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("climbing_gym")
@Getter
@NoArgsConstructor
public class ClimbingGym {
    @Id
    private Long id;
    private String climbingGymName;
    private String address;
    private String owner;
    private String contact;
    private String email;
    private String message;

    @Builder
    public ClimbingGym(Long id, String climbingGymName, String address, String owner, String contact, String email, String message) {
        this.id = id;
        this.climbingGymName = climbingGymName;
        this.address = address;
        this.owner = owner;
        this.contact = contact;
        this.email = email;
        this.message = message;
    }

    public ClimbingGymContentMessage toContentMessage() {
        return new ClimbingGymContentMessage(climbingGymName, message);
    }
}