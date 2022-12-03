package com.maksgir.webbackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
})
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<PointEntity> points;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
