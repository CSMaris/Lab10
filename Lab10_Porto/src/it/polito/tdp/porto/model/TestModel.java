package it.polito.tdp.porto.model;

import it.polito.tdp.porto.db.PortoDAO;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		PortoDAO dao=new PortoDAO();
		Author a1=dao.getAutore(719,model.getIdmapa());
		Author a2=dao.getAutore(1830,model.getIdmapa());
		System.out.println(model.getPapers3(a1, a2));
		
		
		
	}

}
