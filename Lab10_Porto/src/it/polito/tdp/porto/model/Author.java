package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private int id;
	private String lastname;
	private String firstname;
	private List<Paper> listaPaper;
		
	public Author(int id, String lastname, String firstname) {

		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		listaPaper=new ArrayList<>();
	}

	public int getId() {
		return id;
	}


	public List<Paper> getListaPaper() {
		return listaPaper;
	}

	public void setListaPaper(List<Paper> listaPaper) {
		this.listaPaper = listaPaper;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return lastname+" "+firstname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
