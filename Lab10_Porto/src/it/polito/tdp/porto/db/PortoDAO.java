package it.polito.tdp.porto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.AuthorIDMap;
import it.polito.tdp.porto.model.Paper;
import it.polito.tdp.porto.model.PaperIDMap;

public class PortoDAO {
	
	public List<Paper> getPapersDatoAutore(PaperIDMap idmap, Author author) {

		final String sql = "select * from author, creator, paper where author.id=creator.authorid and paper.eprintid=creator.eprintid and author.id=? ";
		List<Paper> result=new ArrayList<>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,author.getId());
			ResultSet rs = st.executeQuery();
			

			while (rs.next()) {

				Paper paper=new Paper(rs.getInt("eprintid"), rs.getString("title"), rs.getString("issn"), rs.getString("publication"),  rs.getString("type"),  rs.getString("types"));
				result.add(idmap.get(paper));
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	
	
	
	
	public List<Author> getAutori(AuthorIDMap idmap) {

		final String sql = "SELECT * FROM author ";
		List<Author> result=new ArrayList<Author>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Author autore = new Author(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"));
				result.add(idmap.get(autore));
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public List<Paper> getPapers(PaperIDMap idmap) {

		final String sql = "SELECT * FROM paper ";
		List<Paper> result=new ArrayList<Paper>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Paper paper = new Paper(rs.getInt("eprintid"), rs.getString("title"), rs.getString("issn"), rs.getString("publication"),  rs.getString("type"),  rs.getString("types"));
				result.add(idmap.get(paper));
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public Map<Author,List<Author>> getAutoriPerGrafo(AuthorIDMap idmap) {

		final String sql =" select distinct c1.authorid as a, c2.authorid as b from creator c1, creator c2 where c1.eprintid=c2.eprintid and c2.authorid>c1.authorid order by a";
					
		Map<Author,List<Author>> result=new HashMap<>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
            
            int x;
            int y=0;
            int count=0;
            List<Author> list=new ArrayList<>();
			while (rs.next()) {
				if(count==0)
					y=rs.getInt("a");
					
				
				Author autore2 = new Author(rs.getInt("b"), "", "");
				
				x=rs.getInt("a");
				if(x!=y) {
					result.put(idmap.get(new Author(y,"","")),new ArrayList<Author>(list));
					list.clear();
					list.add(idmap.get(autore2));
					y=x;
				}
				else 
					list.add(idmap.get(autore2));
				
			count++;	
			}

			return result;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	

	
	
	
	
	public Author getAutore(int id, AuthorIDMap map) {

		final String sql = "SELECT * FROM author where id=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				Author autore = new Author(rs.getInt("id"), rs.getString("lastname"), rs.getString("firstname"));
				return map.get(autore);
			}

			return null;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	
	public Paper getArticolo(int eprintid) {

		final String sql = "SELECT * FROM paper where eprintid=?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, eprintid);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Paper paper = new Paper(rs.getInt("eprintid"), rs.getString("title"), rs.getString("issn"),
						rs.getString("publication"), rs.getString("type"), rs.getString("types"));
				return paper;
			}

			return null;

		} catch (SQLException e) {
			 e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}