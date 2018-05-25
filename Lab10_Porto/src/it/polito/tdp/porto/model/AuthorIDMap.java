package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;


public class AuthorIDMap {
	
	private Map<Integer, Author> map;
	
	public AuthorIDMap() {
		map = new HashMap<>();
	}
	
	public Author get(Integer id) {
		return map.get(id);
	}
	
	public Author get(Author author) {
		Author old = map.get(author.getId());
		if (old == null) {
		
			map.put(author.getId(), author);
			return author;
		}
		return old;
	}
	
	public void put(Integer id, Author author) {
		map.put(id, author);
	}

}
