package Classes;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class rdv {
 private int id_patient;
 private String nom_personnel;
 private Date date_rdv;
 private Time temps_rdv;
public int getId_patient() {
	return id_patient;
}
public void setId_patient(int id_patient) {
	this.id_patient = id_patient;
}
public String getNom_personnel() {
	return nom_personnel;
}
public void setNom_personnel(String nom_personnel) {
	this.nom_personnel = nom_personnel;
}
public Date getDate_rdv() {
	return date_rdv;
}
public void setDate_rdv(Date date_rdv) {
	this.date_rdv = date_rdv;
}
public Time getTemps_rdv() {
	return temps_rdv;
}
public void setTemps_rdv(Time temps_rdv) {
	this.temps_rdv = temps_rdv;
}
public rdv(int id_patient, String nom_personnel, Date date_rdv, Time temps_rdv) {
	super();
	this.id_patient = id_patient;
	this.nom_personnel = nom_personnel;
	this.date_rdv = date_rdv;
	this.temps_rdv = temps_rdv;
}
 
 

}
