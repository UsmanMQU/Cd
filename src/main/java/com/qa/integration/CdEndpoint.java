package com.qa.integration;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.business.service.CdService;

public class CdEndpoint 
{
	@Inject
	private CdService service;
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts()
	{
		return service.getAllCds();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) 
	{
		return service.addCd(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String cd)
	{
		return service.updateCd(id, cd);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) 
	{
		return service.deleteCd(id);

	}

	public void setService(CdService service) 
	{
		this.service = service;
	}
}
