package com.maksgir.webbackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log")
@NoArgsConstructor
@Getter
@Setter
public class AuditedMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dt")
    private LocalDateTime dt;

    @Column(name = "username")
    private String username;

    public AuditedMethod(String name, LocalDateTime dt, String username) {
        this.name = name;
        this.dt = dt;
        this.username = username;
    }
}
