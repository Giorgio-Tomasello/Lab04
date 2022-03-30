package it.polito.tdp.lab04.model;

import java.util.HashMap;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao = new StudenteDAO();
	}

	
	public List<Corso> getTuttiCorsi(){
		
		return this.corsoDao.getTuttiICorsi();
		
	}
	
	public HashMap<Integer, Studente> getTuttiGliStudenti(){
		
		return this.studenteDao.getTuttiGliStudenti();
		
	}
	
	public List<Studente> getStudentiIscrittiAlCorso (String corso){
		
		return this.corsoDao.getStudentiIscrittiAlCorso(corso);
	}
	
	
	public List<Corso> getCorsiPerStudente(String matricola) {
		
		return this.studenteDao.getCorsiPerStudente(matricola);
	}
	
}
