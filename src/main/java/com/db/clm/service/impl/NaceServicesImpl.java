package com.db.clm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.db.clm.dao.NaceDAO;
import com.db.clm.model.Nace;
import com.db.clm.service.NaceServices;

@Service("naceServicesImpl")
public class NaceServicesImpl implements NaceServices {

	@Autowired
	@Qualifier("naceDAOImpl")
	private NaceDAO naceDao;

	@Override
	public boolean storeCsv(List<String> csv) {
		try {			
			for (int i = 0; i < csv.size(); i++) {
				String[] naceSplitObject = csv.get(i).split(",");
				String regex = "[0-9]+";
				
				if(naceSplitObject[0].matches(regex) && naceSplitObject[1].matches(regex)) {					
					Nace naceObject = new Nace(
							Long.parseLong(naceSplitObject[0]), 
							Integer.parseInt(naceSplitObject[1]),
							naceSplitObject[2],
							naceSplitObject[3],
							naceSplitObject[4],
							naceSplitObject[5],
							naceSplitObject[6],
							naceSplitObject[7],
							naceSplitObject[8],
							naceSplitObject[9]
							);
					naceDao.save(naceObject);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteNace(Long id) {
		return naceDao.delete(id);
	}

	@Override
	public Nace addNace(Nace nace) {
		return naceDao.save(nace);
	}

	@Override
	public List<Nace> getAll() {
		return naceDao.getAll();
	}

}
