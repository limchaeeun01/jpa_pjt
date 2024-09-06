package com.example.jpa_pjt.jpa.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Table(name = "TB_JPA_SAMPLE")
@Entity
@Data
@DynamicUpdate
public class SampleEntity {

    @Id // 기본키
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column
    private String id;

    @Column
    private String pwd;

    @Column
    private String name;
}
