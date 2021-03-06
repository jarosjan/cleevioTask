package com.cleevio.task.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Watch {

    @Id
    @Column(name = "watch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long watchId;

    @Column
    private String title;

    @Column
    private int price;

    @Column
    private String description;

    @Column
    private byte[] fountain;

}