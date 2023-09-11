package com.payandpark.payandpark.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@DynamicUpdate
@Table(name = "users")
@Getter @Setter
public class UserModel {

    @Id
    @Column(unique = true)
    private String id;

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "isactive")
    private Boolean isActive;
}
