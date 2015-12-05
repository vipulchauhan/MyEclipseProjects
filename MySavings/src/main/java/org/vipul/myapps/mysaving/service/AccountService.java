package org.vipul.myapps.mysaving.service;

import java.util.List;

import org.vipul.myapps.mysaving.model.FixedDeposite;


//@Component
public interface AccountService {
	public List<FixedDeposite> getFixedDeposites();
}
