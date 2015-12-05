package org.vipul.myapps.mysaving.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vipul.myapps.mysaving.model.FixedDeposite;
import org.vipul.myapps.mysaving.repository.FixedDepositeRepository;
@Service
public class AccountServiceImpl implements AccountService {

	private static Logger logger = Logger.getLogger(AccountServiceImpl.class);

	@Autowired
	FixedDepositeRepository fdr;

	public List<FixedDeposite> getFixedDeposites() {

		logger.info(fdr.findAll().toArray().toString());
		return fdr.findAll();
	}
}
