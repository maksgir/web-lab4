package com.maksgir.webbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "points")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "x")
    private double x;

    @Column(name = "y")
    private double y;

    @Column(name = "r")
    private double r;

    @Column(name = "dt")
    private LocalDateTime dt;


    @Column(name = "hit")
    private boolean hit;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    public PointEntity(double x, double y, double r,  LocalDateTime dt,  boolean hit, UserEntity owner) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.dt = dt;
        this.hit = hit;
        this.owner = owner;

    }

    public PointEntity(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        return "PointEntity{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", dt=" + dt +
                ", hit=" + hit +
                '}';
    }
}