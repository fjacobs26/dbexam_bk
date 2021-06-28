package com.db.clm.service;

import java.util.List;

import com.db.clm.model.Nace;

public interface NaceServices {
	public abstract Nace addNace(Nace nace);
	public abstract boolean storeCsv(List<String> csv);
	public abstract boolean deleteNace(Long id);
	public abstract List<Nace> getAll();
}
