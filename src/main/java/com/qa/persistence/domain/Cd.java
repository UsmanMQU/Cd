package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cd
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
	@ManyToOne(fetch = FetchType.LAZY)
	private List artist = new ArrayList();

	public Cd(String title, List artist)
	{
		this.title = title;
		this.artist = artist;
	}
	public Cd() 
	{

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List getArtist() {
		return artist;
	}

	public void setArtist(List artist) {
		this.artist = artist;
	}


}
