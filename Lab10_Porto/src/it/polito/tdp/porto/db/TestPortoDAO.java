package it.polito.tdp.porto.db;

import it.polito.tdp.porto.model.AuthorIDMap;

public class TestPortoDAO {
	
	public static void main(String args[]) {
		PortoDAO pd = new PortoDAO();
		AuthorIDMap map=new AuthorIDMap();
		System.out.println(pd.getAutore(85,map));
		System.out.println(pd.getArticolo(2293546));
		System.out.println(pd.getArticolo(1941144));
		System.out.println(pd.getAutoriPerGrafo(map));

	}

}
