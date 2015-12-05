package org.vipul.myapps.mysaving.webservice;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.vipul.myapps.mysaving.model.FixedDeposite;
import org.vipul.myapps.mysaving.repository.FixedDepositeRepository;
import org.vipul.myapps.mysaving.service.AccountService;

@RestController
@RequestMapping(value = "/mySavings")
public class MySavingsController  {

	private static Logger logger = Logger.getLogger(MySavingsController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/fixedDeposites", method = RequestMethod.GET)
	public List<FixedDeposite> getFixedDeposites() {
		return accountService.getFixedDeposites();

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {

		return "REST Working";

	}

}
