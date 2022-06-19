package com.azhar.dao;

import java.util.List;
import com.azhar.model.KnowledgePackage;

public interface KpacDao {

	public List<KnowledgePackage> getAllKpacs();

	public List<KnowledgePackage> getKpacs(List<Integer> ids);

	public int deleteKpac(int id);

	public int saveKpac(KnowledgePackage knowledgePackage);

}
