package com.example.jpa_pjt.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa_pjt.jpa.dao.SampleDAO;
import com.example.jpa_pjt.jpa.domain.entity.SampleEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    /*
    Mybatis : XXXMapper - @Mapper
    JPA     : XXXDao    - @Repository
     */
    @Autowired
    private SampleDAO sampleDao;

    public SampleEntity save(SampleEntity params) {
        System.out.println("service save " + params);
        sampleDao.save(params);
        return params;
    }

    public List<SampleEntity> list() {
        System.out.println("service list ");
        return sampleDao.findAll();
    }

    public Optional<SampleEntity> find(Integer id) {
        System.out.println("service find ");
        Optional<SampleEntity> optional = sampleDao.findById(id);
        return optional;
    }

    public void delete(Integer id) {
        System.out.println("service delete ");
        sampleDao.deleteById(id);
    }

    /* case 01
    public SampleEntity update(SampleEntity params) {
        System.out.println("service update " + params);
        sampleDao.save(params);
        return params;
    }
     */

 /*  case 02
    @Transactional
    public SampleEntity update(SampleEntity params) {
        System.out.println("service update " + params);
        Optional<SampleEntity> entity = sampleDao.findById(params.getSeq());
        if( entity.isPresent() ){
            SampleEntity obj = entity.get();
            obj.setId(params.getId());
            obj.setPwd(params.getPwd());
            obj.setName(params.getName()); 
        }
        return params;
    }
     */
    // case 03
    public SampleEntity update(SampleEntity params) {
        System.out.println("service update " + params);
        sampleDao.updateRow(params.getSeq(), params.getId(), params.getPwd(), params.getName());
        return params;
    }
}
