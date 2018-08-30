package com.qa.business.service;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.qa.persistence.repository.CdRepository;



public class CdServiceImpl implements CdService {

	private static final Logger LOGGER = Logger.getLogger(CdService.class);

	@Inject
	private CdRepository repo;

	public String getAllAccounts() 
	{
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllCds();
	}

	
	public String addAccount(String account) 
	{
		return repo.createCd(account);
	}

	
	public String updateAccount(Long id, String account)
	{
		return repo.updateCd(id, account);
	}

	
	public String deleteAccount(Long id) 
	{
		return repo.deleteCd(id);

	}

	public void setRepo(CdRepository repo)
	{
		this.repo = repo;
	}


	public String getAllCds() {
		// TODO Auto-generated method stub
		return null;
	}


	public String addCd(String account) {
		// TODO Auto-generated method stub
		return null;
	}


	public String updateCd(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}


	public String deleteCd(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
