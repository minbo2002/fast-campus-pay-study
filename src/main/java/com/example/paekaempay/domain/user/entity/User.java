package com.example.paekaempay.domain.user.entity;

import com.example.paekaempay.domain.BaseEntity;
import com.example.paekaempay.domain.user.UserRoleType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleType roleType;

    @Builder
    private User(Long id, String username, String password, Integer amount, UserRoleType roleType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.roleType = roleType;
    }
}
