package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public HashMap<Integer, Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		HashMap<Integer, Studente> studenti = new HashMap<Integer, Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");
				

				System.out.println(matricola + " " + cognome + " " + nome + " " + CDS);
				
				Studente s = new Studente(matricola, cognome, nome, CDS);
				
				studenti.put(matricola, s);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				
			}
			

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);

}}
	
	
	public List<Corso> getCorsiPerStudente(String matricola) {
		
		
		final String sql2 = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM iscrizione i, studente s, corso c "
				+ "WHERE  i.matricola=s.matricola AND i.codins=c.codins AND s.matricola=?";
		

		List<Corso> result = new LinkedList<Corso>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql2);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				
				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				
				result.add(c);
			}
			
			
			//st.close();
			//rs.close();
			conn.close();
			return result;
			
		}catch(SQLException e){
			System.out.println("Errore nel DAO");
			//e.printStackTrace();
			return null;
		}
		
		
		
		
	}

	
	
}
