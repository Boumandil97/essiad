package Classes;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.ArrayList;
import java.util.Observable;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class CadreInfirmier extends Utilisateur {
	

	private String secteurRattachement;
	public CadreInfirmier() {
		
	}
	
	public CadreInfirmier(int id,String username,String login,String password,String nom,String prenom,Date dateDeNaissance,long numSecSoc,String adresse,String personneRef,String secteur) {
		this.username=username;
		this.id=id;
		this.login=login;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
		this.dateDeNaissance=dateDeNaissance; 
		this.numSecSoc=numSecSoc;
		this.adresse=adresse;
		this.personneRef=personneRef;
		this.secteurRattachement=secteur;
	}
	public void ajouterDossier(TableView tab,TableView tab2) throws SQLException {
		ObservableList<Patient> allPatients,patientSelected;
		patientSelected=FXCollections.observableArrayList();
		allPatients=tab.getItems();
		patientSelected= tab.getSelectionModel().getSelectedItems();
		
		Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad","root","123");
	
	Statement state=conexion.createStatement();
	
	for(int i=0;i<patientSelected.size();i++) {
		String query="insert into patient(username,nom,Prenom,email,date_de_naissance,password,conf_password,num_sec_soc,personne_referente,adresse_maison,apartement_exacte,nom_medecin,adresse_medecin,tel_medecin,nom_pharma,tel_pharma,nom_lab,tel_lab,sexe,situation) values('"+patientSelected.get(i).getUsername()+"','"+patientSelected.get(i).getNom()+"','"+patientSelected.get(i).getPrénom()
				+"','"+patientSelected.get(i).getEmail()+"','"+patientSelected.get(i).getBirthday()
				+"','"+patientSelected.get(i).getPassword()+"','"+patientSelected.get(i).getConfpassword()
				+"','"+patientSelected.get(i).getNumSecSociale()+"','"+patientSelected.get(i).getPersonneRefe()
				+"','"+patientSelected.get(i).getAdresse()+"','"+patientSelected.get(i).getAdresseprop()
				+"','"+patientSelected.get(i).getNomMed()+"','"+patientSelected.get(i).getAddMed()
				+"','"+patientSelected.get(i).getTelMed()+"','"+patientSelected.get(i).getNomPharm()
				+"','"+patientSelected.get(i).getTelPharm()+"','"+patientSelected.get(i).getNomLab()
				+"','"+patientSelected.get(i).getTelLab()+"','"+patientSelected.get(i).getGender()
				+"','"+patientSelected.get(i).getSituation()+"')";
		state.executeUpdate(query);
		
	}
}
	public ListView parcourirList() throws SQLException {
		Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad","root","123");
	Statement state=conexion.createStatement();
	ObservableList<String> ob=FXCollections.observableArrayList();
	String sql="select nom,Prenom from patient";
	ResultSet res=conexion.createStatement().executeQuery(sql);
	while(res.next()) {
		ob.add(new String(res.getString("nom")+" "+res.getString("Prenom")));
	}
		ListView list=new ListView();
		list.setItems(ob);
		return list;
	}
	public ListView evaluer_patient(DatePicker dat,javafx.scene.control.TextField t1,javafx.scene.control.TextField t2) throws SQLException {
		Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad","root","123");
		Statement state=conexion.createStatement();
		ObservableList<String> oz=FXCollections.observableArrayList();
		String sal="select Nom,Prenom,AVG(note_physiologie) as avgp,AVG(note_psychologie) as avgs,AVG(note_sociologie) as avgc,extract(year from Date) as year from progres "
				+ "where Nom='"+t1.getText()+"' AND Prenom='"+t2.getText()+"' AND extract(year from Date)='"
				+dat.getValue().getYear()+"';";
		ResultSet res=conexion.createStatement().executeQuery(sal);
		while(res.next()) {
			oz.add(new String("Nom: "+res.getString("Nom")+"\n"+"Prenom: "+res.getString("Prenom")+"\n"
					           +"moyenne physique: "+Double.toString(res.getDouble("avgp"))+"\n"
					           + "moyenne psychique: "+Double.toString(res.getDouble("avgs"))+"\n"
					           + "moyenne sociologique: "+Double.toString(res.getDouble("avgc"))+"\n" 
					            +"annee: "+res.getDate("year").toString()               ));
			
		
		}
		ListView list=new ListView();
		list.setLayoutX(0);
		list.setLayoutY(95);
		list.setPrefSize(133, 281);
		list.setItems(oz);
		return list;
		
		
		
	}
	public String getSecteurRattachement() {
		return secteurRattachement;
	}
	public void setSecteurRattachement(String secteurRattachement) {
		this.secteurRattachement = secteurRattachement;
	}
	
	
	
	
	
}