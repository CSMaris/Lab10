package it.polito.tdp.porto;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Model;
import it.polito.tdp.porto.model.Paper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    	txtResult.clear();
    	Author a=boxPrimo.getValue();
        txtResult.appendText("Elenco coAutori: \n");
        
        for(Author author:model.getCoautori(a))
        	txtResult.appendText(author+"\n");

    }

    @FXML
    void handleSequenza(ActionEvent event) {
    	txtResult.clear();
    	Author a1=boxPrimo.getValue();
    	Author a2=boxSecondo.getValue();
    	txtResult.appendText("Catena di papers: \n");
        
    	
    	for(Paper p:model.getPapers3(a1, a2))
         	txtResult.appendText(p+"\n");
    	
    	

    }

    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

    }
    private Model model;

	public void setModel(Model model) {
		this.model=model;
		List<Author> lista=model.getAllAuthors();
		Collections.sort(lista);
		
		boxPrimo.getItems().addAll(lista);
		boxSecondo.getItems().addAll(lista);
		
		
		
	}
}
