package com.example.jpa_pjt.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.jpa_pjt.jpa.domain.entity.SampleEntity;

@Repository
public interface SampleDAO extends JpaRepository<SampleEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE TB_JPA_SAMPLE U "
            + "SET U.id = :id, U.pwd = :pwd, U.name = :name "
            + "WHERE U.seq = :seq")
    public void updateRow(@Param("seq") Integer seq,
            @Param("id") String id,
            @Param("pwd") String pwd,
            @Param("name") String name);
}
