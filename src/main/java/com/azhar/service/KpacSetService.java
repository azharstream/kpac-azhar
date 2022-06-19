package com.azhar.service;

import java.util.List;
import com.azhar.model.KnowledgePackage;
import com.azhar.model.KnowledgePackageSet;

public interface KpacSetService {

	public List<KnowledgePackageSet> getAllKpacSet();

	public void saveKpacSet(KnowledgePackageSet knowledgePackageSet);

	public void deleteKpacSet(int id);

	public List<KnowledgePackage> getKpacsFromSet(int id);

}
