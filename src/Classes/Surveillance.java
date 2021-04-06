package Classes;

import java.sql.Date;
import java.sql.Time;

public class Surveillance {

	private int id_personnel;
	private String adresse_patient;
	private Date date;
	
	private String arrive;
	private Time heure_arrive;
	private String quitter;
	private Time heure_quitter;
	
	public Surveillance() {
		
	}
	
	public Surveillance(int id_personnel, String adresse_patient, Date date,  String arriver,
			Time heure_arrive, String quitter, Time heure_quitter) {
		super();
		this.id_personnel = id_personnel;
		this.adresse_patient = adresse_patient;
		this.date = date;
		this.arrive = arriver;
		this.heure_arrive = heure_arrive;
		this.quitter = quitter;
		this.heure_quitter = heure_quitter;
	}
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public String getAdresse_patient() {
		return adresse_patient;
	}
	public void setAdresse_patient(String adresse_patient) {
		this.adresse_patient = adresse_patient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public Time getHeure_arrive() {
		return heure_arrive;
	}
	public void setHeure_arrive(Time heure_arrive) {
		this.heure_arrive = heure_arrive;
	}
	public String getQuitter() {
		return quitter;
	}
	public void setQuitter(String quitter) {
		this.quitter = quitter;
	}
	public Time getHeure_quitter() {
		return heure_quitter;
	}
	public void setHeure_quitter(Time heure_quitter) {
		this.heure_quitter = heure_quitter;
	}
	
	

	
	
	
}
