package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Artist 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@OneToMany(fetch = FetchType.LAZY)
	private List artist = new ArrayList();
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public List getArtist() 
	{
		return artist;
	}
	public void setArtist(List artist) 
	{
		this.artist = artist;
	}	
	
	
	
}
