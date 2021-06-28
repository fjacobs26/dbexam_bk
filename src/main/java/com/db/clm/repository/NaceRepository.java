package com.db.clm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db.clm.model.Nace;

@Repository("naceRepository")
@Transactional(readOnly = true) 
public interface NaceRepository extends JpaRepository<Nace, Serializable>{

}
