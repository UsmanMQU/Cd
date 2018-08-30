package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.JSONutil.JSONUtil;
import com.qa.persistence.domain.Cd;


@Transactional(SUPPORTS)
@Default
public class CdDBRepository 
{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	@Inject
	private JSONUtil util;
	
	public String getAllCds() 
	{
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Cd> cds = (Collection<Cd>) query.getResultList();
		return util.getJSONForObject(cds);
	}
	
	@Transactional(REQUIRED)
	public String createCd(String cd) 
	{
		Cd ancd = util.getObjectForJSON(cd, Cd.class);
		manager.persist(ancd);
		return "{\"message\": \"Artist has been sucessfully added\"}";
	}
	@Transactional(REQUIRED)
	public String updateCd(Long id, String cdToUpdate)
	{
		Cd updatedcd = util.getObjectForJSON(cdToUpdate, Cd.class);
		Cd accountFromDB = findCd(id);
		if (cdToUpdate != null)
		{
			accountFromDB = updatedcd;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"Artist sucessfully updated\"}";
	}	

	@Transactional(REQUIRED)
	public String deleteCd(Long id)
	{
		Cd artistInDB = findCd(id);
		if (artistInDB != null) 
		{
			manager.remove(artistInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	private Cd findCd(Long id) 
	{
		return manager.find(Cd.class, id);
	}
	
	public void setManager(EntityManager manager)
	{	
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) 
	{
		this.util = util;
	}	
}
