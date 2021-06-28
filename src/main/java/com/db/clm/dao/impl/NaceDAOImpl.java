package com.db.clm.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.db.clm.dao.NaceDAO;
import com.db.clm.model.Nace;
import com.db.clm.repository.NaceRepository;
@Component("naceDAOImpl")
public class NaceDAOImpl implements NaceDAO {

	@Autowired
	@Qualifier("naceRepository")
	private NaceRepository naceRepository;
	
	@Override
	public List<Nace> getAll() {
		return naceRepository.findAll();
	}

	@Override
	public Optional<Nace> getNace(long id) {
		return naceRepository.findById(id);
	}

	@Override
	public Nace save(Nace nace) {
		return naceRepository.save(nace);
	}

	@Override
	public Nace update(Nace nace) {
		return naceRepository.save(nace);
		
	}

	@Override
	public boolean delete(Long id) {
		try {
			naceRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

}
