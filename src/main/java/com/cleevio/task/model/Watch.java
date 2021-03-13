package com.cleevio.task.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Watch {

    @Id
    @Column(name = "watch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long watchId;

    @Column
    @XmlElement
    @NotBlank(message = "Title is mandatory.")
    private String title;

    @Column
    @XmlElement
    @Range(min = 1, message = "Price must be greater than 1.")
    private int price;

    @Column
    @XmlElement
    @NotBlank(message = "Description is mandatory.")
    private String description;

    @Column
    @XmlElement
    @NotNull(message = "Photo 'fountain' must not be null.")
    private byte[] fountain;

}