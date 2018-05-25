package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;


public class PaperIDMap {
	
	private Map<Integer, Paper> map;
	
	public PaperIDMap() {
		map = new HashMap<>();
	}
	
	public Paper get(Integer id) {
		return map.get(id);
	}
	
	public Paper get(Paper paper) {
		Paper old = map.get(paper.getId());
		if (old == null) {
		
			map.put(paper.getId(), paper);
			return paper;
		}
		return old;
	}
	
	public void put(Integer id, Paper paper) {
		map.put(id, paper);
	}

}
