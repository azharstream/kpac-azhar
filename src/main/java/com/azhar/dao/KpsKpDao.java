package com.azhar.dao;

import java.util.List;
import com.azhar.model.KpsKp;

public interface KpsKpDao {

	public List<KpsKp> findByKpacSetId(int id);

}
