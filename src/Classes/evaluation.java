package Classes;

import java.sql.Date;

public class evaluation {
	private int id_patient;
	private String nom_patient;
	private String Prenom_patient;
	private String obs_physiologie;
	private String obs_psychologie;
	private String obs_sociologie;
	private java.sql.Date Date;
	public String getNom_patient() { 
		return nom_patient;
	}

	public void setNom_patient(String nom_patient) {
		this.nom_patient = nom_patient;
	}

	public String getPrenom_patient() {
		return Prenom_patient;
	}

	public void setPrenom_patient(String prenom_patient) {
		Prenom_patient = prenom_patient;
	}

	public String getObs_physiologie() {
		return obs_physiologie;
	}

	public void setObs_physiologie(String obs_physiologie) {
		this.obs_physiologie = obs_physiologie;
	}

	public String getObs_psychologie() {
		return obs_psychologie;
	}

	public void setObs_psychologie(String obs_psychologie) {
		this.obs_psychologie = obs_psychologie;
	}

	public String getObs_sociologie() {
		return obs_sociologie;
	}

	public void setObs_sociologie(String obs_sociologie) {
		this.obs_sociologie = obs_sociologie;
	}

	public java.sql.Date getDate() {
		return Date;
	}

	public void setDate(java.sql.Date date) {
		Date = date;
	}

	 

	public evaluation(int id_patient,java.sql.Date date2, String string, String string2, String string3, String string4,
			String string5) {
		this.id_patient=id_patient;
		this.Date=date2;
		this.nom_patient=string;
		this.Prenom_patient=string2;
		this.obs_physiologie=string3;
		this.obs_psychologie=string4;
		this.obs_sociologie=string5;
	}

	public int getId_patient() {
		return id_patient;
	}

	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}

	

	
}
