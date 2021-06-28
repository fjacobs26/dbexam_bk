package com.db.clm.dao;

import java.util.List;
import java.util.Optional;

import com.db.clm.model.Nace;

public interface NaceDAO {
	public abstract List<Nace> getAll();
	public abstract Optional<Nace> getNace(long id);
	public abstract Nace save(Nace nace);
	public abstract Nace update(Nace nace);
	public abstract boolean delete(Long id);
}
