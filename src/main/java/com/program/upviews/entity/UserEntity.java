package com.program.upviews.entity;

import java.sql.Timestamp;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    private String resetToken;

    private Timestamp tokenExpiration;

    @OneToOne(fetch = FetchType.EAGER)
    RoleEntity role;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AccountEntity account;

}
