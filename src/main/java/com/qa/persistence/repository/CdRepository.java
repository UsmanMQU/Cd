package com.qa.persistence.repository;

public interface CdRepository 
{
	String getAllCds();
	
	String createCd(String artist);

	String updateCd(Long id, String artistToUpdate);

	String deleteCd(Long id);
}
