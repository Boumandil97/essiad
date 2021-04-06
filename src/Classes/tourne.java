package Classes;

import java.sql.Date;

public class tourne {
private	int id_personnel;
private String adresse_patient;
private Date date;
public tourne(int id_personnel, String adresse_patient, Date date) {
	super();
	this.id_personnel = id_personnel;
	this.adresse_patient = adresse_patient;
	this.date = date;
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

}
