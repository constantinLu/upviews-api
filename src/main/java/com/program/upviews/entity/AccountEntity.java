package com.program.upviews.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RankEntity rank;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CartEntity cart;

}


