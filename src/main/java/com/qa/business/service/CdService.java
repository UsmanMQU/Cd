package com.qa.business.service;

public interface CdService
{
	String getAllCds();

	String addCd(String account);

	String updateCd(Long id, String account);

	String deleteCd(Long id);
}
