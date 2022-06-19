package com.azhar.dao;

import java.util.List;
import com.azhar.model.KnowledgePackageSet;

public interface KpacSetDao {

	public List<KnowledgePackageSet> getAllKpacSet();

	public List<KnowledgePackageSet> getKpacSet(int id);

	public int[] saveKpacSet(KnowledgePackageSet knowledgePackageSet);

	public int deleteKpacSet(int id);

}
