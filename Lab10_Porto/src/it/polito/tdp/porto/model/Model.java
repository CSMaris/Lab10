package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	private PortoDAO dao;
	private List<Author> authors;
	private AuthorIDMap idmapa;
	private PaperIDMap idmapp;
	private Graph<Author, DefaultEdge> graph;
	
	
	public Model() {
		
		dao=new PortoDAO();
		idmapa=new AuthorIDMap();
		idmapp=new PaperIDMap();
		authors=dao.getAutori(idmapa);
		creaGrafo();
	}
	
	public List<Author> getAllAuthors(){
	return authors;
	}
	
	private void creaGrafo() {
		graph=new SimpleGraph<> (DefaultEdge.class);
		Graphs.addAllVertices(graph, authors);
		
		Map<Author,List<Author>> map=dao.getAutoriPerGrafo(idmapa);
		
		for(Author a:map.keySet()) {
			for(Author b:map.get(a))
				graph.addEdge(a,b);
		}
		
	}
	
	public List<Author> getCoautori(Author a) {
		return Graphs.neighborListOf(graph, a);
	}
	
	public List<Paper> getPapers3(Author a1, Author a2){
		return null;	
	}
	

	
	
}
