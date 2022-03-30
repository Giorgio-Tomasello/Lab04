/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="brnReset"
    private Button brnReset; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="checkBox"
    private Button checkBox; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBoxCorsi"
    private ComboBox<String> cmbBoxCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="textCognome"
    private TextField textCognome; // Value injected by FXMLLoader

    @FXML // fx:id="textMatricola"
    private TextField textMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="textNome"
    private TextField textNome; // Value injected by FXMLLoader

    @FXML // fx:id="textOutput"
    private TextArea textOutput; // Value injected by FXMLLoader
    
    
    @FXML
    void doCerca(ActionEvent event) {
    	
    	textOutput.clear();
    	
    	if(model.getTuttiGliStudenti().containsKey(Integer.parseInt(textMatricola.getText()))==false) {
    		
    		textOutput.setText("Errore! Lo studente non è presente nel database");
    	}
    	
    	else {
    		if(cmbBoxCorsi.getValue()==null||cmbBoxCorsi.getValue()=="") {
        		textOutput.setText("Errore! Non hai selezionato alcun corso");
        	}else {
        		
        		for(Corso c:model.getCorsiPerStudente(textMatricola.getText())) {
            		
            		if(c.getNome().compareTo(cmbBoxCorsi.getValue())==0) {
            			
            			textOutput.setText("Lo stuente è iscritto al corso selezionato");
                	}
            		}
        	}
    	}
    	
    	
    		
    	}
    	

    

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	textOutput.clear();
    	
    	
    	
   	if(model.getTuttiGliStudenti().containsKey(Integer.parseInt(textMatricola.getText()))==false) {
    		
    		textOutput.setText("Errore! Lo studente non è presente nel database");
    	}else {
    	
    	for(Corso c:model.getCorsiPerStudente(textMatricola.getText())) {
    		
    		textOutput.appendText(c.toString());
    		
    	}}

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	textOutput.clear();
    	
    	if(cmbBoxCorsi.getValue()==null||cmbBoxCorsi.getValue()=="") {
    		textOutput.setText("Errore! Non hai selezionato alcun corso");
    	}
    	for(Studente st:model.getStudentiIscrittiAlCorso(cmbBoxCorsi.getValue())){
    		
    		textOutput.appendText(st.toString());
    	}

    }

    @FXML
    void doCheckBox(ActionEvent event) {
    	
    	Integer matr = Integer.parseInt(textMatricola.getText());
    	
    	Studente stu = model.getTuttiGliStudenti().get(matr);
    	
    	textCognome.setText(stu.getCognome());
    	textNome.setText(stu.getNome());
    	
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	textOutput.clear();
    	textMatricola.clear();
    	textNome.clear();
    	textCognome.clear();
    	setComboBox();
    	
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert brnReset != null : "fx:id=\"brnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkBox != null : "fx:id=\"checkBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBoxCorsi != null : "fx:id=\"cmbBoxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textCognome != null : "fx:id=\"textCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textMatricola != null : "fx:id=\"textMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textNome != null : "fx:id=\"textNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textOutput != null : "fx:id=\"textOutput\" was not injected: check your FXML file 'Scene.fxml'.";

        
   
    }
    
    public void setModel(Model model){
    	this.model=model;
    	setComboBox();
    	
        
    }
    
    public void setComboBox(){
    	
    	cmbBoxCorsi.getItems().clear();
    	cmbBoxCorsi.getItems().add("");
    	
        
        for(Corso c: model.getTuttiCorsi()) {
        	cmbBoxCorsi.getItems().add(c.getNome());}
    }

}
