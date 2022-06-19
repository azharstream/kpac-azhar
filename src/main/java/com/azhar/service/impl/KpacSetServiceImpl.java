package com.azhar.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.azhar.dao.KpacSetDao;
import com.azhar.dao.KpsKpDao;
import com.azhar.model.KnowledgePackage;
import com.azhar.model.KnowledgePackageSet;
import com.azhar.model.KpsKp;
import com.azhar.service.KpacSetService;

@Service
public class KpacSetServiceImpl implements KpacSetService {

	@Autowired
	private KpsKpDao kpsKpDao;
	@Autowired
	private KpacSetDao kpacSetDao;
	@Autowired
	private KpacServiceImpl kpacService;

	@Override
	public List<KnowledgePackageSet> getAllKpacSet() {
		return kpacSetDao.getAllKpacSet();
	}

	@Override
	public void saveKpacSet(KnowledgePackageSet knowledgePackageSet) {
		kpacSetDao.saveKpacSet(knowledgePackageSet);
	}

	@Override
	public void deleteKpacSet(int id) {
		kpacSetDao.deleteKpacSet(id);
	}

	@Override
	public List<KnowledgePackage> getKpacsFromSet(int id) {
		List<KpsKp> kpsKpList = kpsKpDao.findByKpacSetId(id);
		if (kpsKpList.isEmpty()) {
			return Collections.emptyList();
		} else {
			List<Integer> kpacSetIds = kpsKpList.stream().map(KpsKp::getKpacId).collect(Collectors.toList());
			return kpacService.getKpacs(kpacSetIds);
		}
	}
}
