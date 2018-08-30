package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.JSONutil.JSONUtil;
import com.qa.persistence.domain.Cd;

@ApplicationScoped
@Alternative
public class CdMapRepository implements CdRepository  
{

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Cd> cdMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public CdMapRepository() 
	{
		this.cdMap = new HashMap<Long, Cd>();
		ID = INITIAL_COUNT;
		initAccountMap();
	}

	
	private void initAccountMap() 
	{
				
	}


	public String getAllAccounts()
	{
		return util.getJSONForObject(cdMap.values());
	}
	
	public String createAccount(String cd)
	{
		ID++;
		Cd newCd = util.getObjectForJSON(cd, Cd.class);
		cdMap.put(ID, newCd);
		return cd;
	}

	public String updateAccount(Long id, String cdToUpdate) 
	{
		Cd newAccount = util.getObjectForJSON(cdToUpdate, Cd.class);
		cdMap.put(id, newAccount);
		return cdToUpdate;
	}

	public String deleteAccount(Long id)
	{
		cdMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}
	
	
	private void initCdMap(List a) 
	{
		Cd cd = new Cd("hello", a);
		cdMap.put(1L, cd);
	}

	public String getAllCds() 
	{
		
		return null;
	}

	public String createCd(String artist) 
	{
		
		return null;
	}

	public String updateCd(Long id, String artistToUpdate)
	{
		return null;
	}

	public String deleteCd(Long id) 
	{
		return null;
	}
}
