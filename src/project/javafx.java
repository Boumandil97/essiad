package project;

import database.LDAPauthentication;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.sql.Connection;

import javax.naming.NamingException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.IconView;

import com.mysql.cj.xdevapi.Statement;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPSearchResults;

import Classes.CadreInfirmier;
import Classes.Patient;
import database.connexion;

public class javafx extends Application {
	private String gender;

	/**
	 *
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws SQLException, IllegalStateException {
		/*		// ---------------LOGIN SCENE-------------------------

		// ZONE CODE DU STAGE
		primaryStage.setTitle("BESSIAD");

		// ZONE CODE DES GROUPES
		Group gr2 = new Group();
		Button btn4 = new Button("hello login successful");
		btn4.setLayoutX(300);
		btn4.setLayoutY(200);
		gr2.getChildren().add(btn4);
//ZONE CODE DES SCENES
		Scene scene2 = new Scene(gr2, 600, 450);

//ZONE DES COULEURS

		LinearGradient cycleGrad = new LinearGradient(350, // start X
				50, // start Y
				70, // end X
				70, // end Y
				false, // proportional
				CycleMethod.REPEAT, // cycleMethod
				new Stop(0f, Color.rgb(255, 23, 230, .784)), new Stop(1.0f, Color.rgb(255, 100, 255, .785)));
		LinearGradient cycleGrad1 = new LinearGradient(350, // start X
				350, // start Y
				70, // end X
				70, // end Y
				false, // proportional
				CycleMethod.REFLECT, // cycleMethod
				new Stop(0f, Color.rgb(0, 0, 255, .784)), new Stop(1.0f, Color.rgb(0, 0, 30, .785)));
		LinearGradient cycleGrad3 = new LinearGradient(50, // start X
				50, // start Y
				70, // end X
				70, // end Y
				false, // proportional
				CycleMethod.REFLECT, // cycleMethod
				new Stop(0f, Color.rgb(0, 255, 0, .800)), new Stop(1.0f, Color.rgb(255, 0, 0, .800)));

// ZONE DES BOUTTONS

		Button btn1 = new Button("Login");
		Button btn2 = new Button("Exit");
		Button btn5 = new Button("Back");

		btn1.setLayoutY(306);
		btn1.setLayoutX(400);
		btn2.setLayoutX(494);
		btn2.setLayoutY(306);
		btn1.setBlendMode(BlendMode.ADD);
		btn2.setBlendMode(BlendMode.ADD);
		btn1.setTextFill(cycleGrad3);
		btn2.setTextFill(cycleGrad3);
		btn5.setLayoutX(0);
		btn5.setLayoutY(410);
		btn5.setId("btn5");
		ImageView back = new ImageView("file:back.png");
		back.setFitWidth(15);
		back.setFitHeight(15);
		btn5.setGraphic(back);
		Font f2 = new Font("BoldSystem", 15);
		btn1.setFocusTraversable(true);
		btn2.setFont(f2);
		btn1.setFont(f2);
		btn1.setDefaultButton(true);
		btn2.setOnAction(e -> primaryStage.close());

//ZONE DES LABELS

		Label l1 = new Label("welcome to our space");
		l1.setLayoutX(15);
		l1.setLayoutY(48);
		l1.setTextFill(Color.WHITE);
		l1.setTextOverrun(OverrunStyle.CLIP);
		Font f1 = new Font("Algerian", 23);
		l1.setFont(f1);
		l1.setTextFill(cycleGrad);
		Label ins = new Label("inscrivez-vous");
		ins.setLayoutX(450);
		ins.setLayoutY(280);
		ins.setTextFill(cycleGrad);
		ins.setId("ins");
		// Cursor.
//zone des texts

		Text txt2 = new Text();
		Text txt3 = new Text();
		txt2.setText("Username/e-mail:");
		txt3.setText("Password : ");
		txt2.setLayoutX(290);
		txt2.setLayoutY(213);
		txt3.setLayoutX(339);
		txt3.setLayoutY(258);
		txt2.setFont(f2);
		txt3.setFont(f2);
		txt2.setFill(cycleGrad3);
		txt3.setFill(cycleGrad3);
		txt2.setTranslateX(3);
		txt2.setUnderline(true);
		txt3.setUnderline(true);
// zone des textfields

		TextField txt1 = new TextField();
		PasswordField pwd1 = new PasswordField();
		txt1.setPromptText("Username-Field");
		pwd1.setPromptText("Password-Field");
		txt1.setLayoutX(417);
		txt1.setLayoutY(196);
		pwd1.setLayoutX(417);
		pwd1.setLayoutY(241);

//------------------------------------------ LES PANELS------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

		// Vboxes
		VBox box1 = new VBox();
		VBox box2 = new VBox();
		Image image2 = new Image("file:C:\\Users\\pcc\\Desktop\\patient1.gif");
		Image image1 = new Image("file:C:\\Users\\pcc\\Desktop\\gif1.gif");
		Image ic1 = new Image("file:icone1.png");
		ImageView iv2 = new ImageView();
		ImageView iv1 = new ImageView();
		ImageView iv3 = new ImageView();
		iv1.setImage(image1);
		iv1.setFitHeight(450);
		iv1.setFitWidth(293);
		iv2.setImage(image2);
		iv2.setFitHeight(163);
		iv2.setFitWidth(340);
		iv2.setLayoutX(350);
		iv2.setTranslateX(-5);

		AnchorPane pane1 = new AnchorPane();

		box1.getChildren().add(iv1);
		AnchorPane g1 = new AnchorPane();
		g1.setPrefWidth(300);
		g1.setPrefHeight(401);
		g1.setLayoutX(0);
		g1.setLayoutY(0);
		Rectangle rct1 = new Rectangle();
		rct1.setTranslateX(290);
		rct1.setLayoutX(0);
		rct1.setWidth(420);
		rct1.setHeight(450);
		rct1.setId("rct1");
		Label error = new Label(" wrong user id or password! please try again ");
		error.setLayoutX(100);
		error.setLayoutY(430);
		error.setId("error");
		// rct1.setFill(Color.#2a282a);
		pane1.getChildren().add(rct1);
		g1.getChildren().addAll(iv2, txt1, txt2, txt3, pwd1, btn1, btn2, btn5, ins);
		pane1.getChildren().addAll(box1, g1);
		pane1.getChildren().add(l1);
		Scene scene = new Scene(pane1, 700, 450);

		
		btn4.setOnAction((e -> primaryStage.setScene(scene)));

// -----------------------------------------INTERFACE GRAPHIQUE-------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

		Group groupe = new Group();
		Image img = new Image("file:background.jpg");
		Image img2 = new Image("file:BESSiad.png");
		ImageView imgvw = new ImageView();
		ImageView imgvw2 = new ImageView();
		ImageView capture = new ImageView("file:Capture.PNG");
		capture.setFitWidth(35);
		capture.setFitWidth(16);
		capture.setId("cptr");
		imgvw.setImage(img);
		imgvw.setFitWidth(700);
		imgvw.setFitHeight(450);
		imgvw.setOpacity(1);
		imgvw2.setImage(img2);
		imgvw2.setFitWidth(180);
		imgvw2.setFitHeight(120);
		imgvw2.setOpacity(1);
		imgvw2.setLayoutX(0);
		imgvw2.setLayoutY(5);
		imgvw2.setId("img2");
		AnchorPane panel1 = new AnchorPane();
		panel1.setPrefWidth(239);
		panel1.setPrefHeight(449);
		Button btna = new Button("Espace Personnels");
		Button btnb = new Button("Espace Patient");
		btna.setLayoutX(37);
		btna.setLayoutY(281);
		btnb.setLayoutX(356);
		btnb.setLayoutY(281);
		btna.setTextFill(cycleGrad);
		btna.setOnAction(e -> primaryStage.setScene(scene));
		btnb.setTextFill(cycleGrad);
		btnb.setOnAction(e -> primaryStage.setScene(scene));
		panel1.getChildren().addAll(btna, btnb);
		groupe.getChildren().addAll(imgvw, panel1);
		Scene scene1 = new Scene(groupe, 700, 450);
		scene1.getStylesheets().add("style.Css");
		scene.getStylesheets().add("buttonstyle2.Css");
		rct1.widthProperty().bind(g1.widthProperty());
		rct1.heightProperty().bind(g1.heightProperty());
		iv1.fitHeightProperty().bind(g1.heightProperty());
		g1.prefHeightProperty().bind(pane1.heightProperty());
		g1.prefWidthProperty().bind(pane1.widthProperty());
		pane1.prefWidthProperty().bind(primaryStage.widthProperty());
		btn5.setOnAction(e -> primaryStage.setScene(scene1));
		btn5.setMaxSize(100, 100);

		imgvw.fitWidthProperty().bind(primaryStage.widthProperty());
		imgvw.fitHeightProperty().bind(primaryStage.heightProperty());

		// test database

//------------------------------FORMULAIRE D'INSCRIPTION POUR PATIENT------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------

		AnchorPane fm1 = new AnchorPane();
		fm1.setPrefWidth(700);
		fm1.setPrefHeight(600);
		Rectangle rct2 = new Rectangle();
		rct2.setWidth(700);
		rct2.setLayoutX(0);
		rct2.setHeight(600);
		rct2.setId("rct2");

		TextField tf1 = new TextField();
		tf1.setPromptText("Nom");
		tf1.setLayoutX(54);
		tf1.setLayoutY(42);
		tf1.setPrefWidth(175);

		TextField tf2 = new TextField();
		tf2.setPromptText("Prénom");
		tf2.setLayoutX(276);
		tf2.setLayoutY(42);
		tf2.setPrefWidth(175);

		TextField mail = new TextField();
		mail.setPromptText("email");
		mail.setLayoutX(491);
		mail.setLayoutY(42);
		mail.setPrefWidth(175);

		TextField confpass = new TextField();
		confpass.setPromptText("confirmation password");
		confpass.setLayoutX(491);
		confpass.setLayoutY(81);
		confpass.setPrefWidth(175);

		TextField pass = new TextField();
		pass.setPromptText("password");
		pass.setLayoutX(276);
		pass.setLayoutY(81);
		pass.setPrefWidth(175);

		TextField tf3 = new TextField();
		tf3.setPromptText("Date de naissance: jj/mm/aaaa");
		tf3.setLayoutX(54);
		tf3.setLayoutY(81);
		tf3.setPrefWidth(175);

		TextField tf4 = new TextField();
		tf4.setPromptText("N° de sécuritée sociale");
		tf4.setLayoutX(54);
		tf4.setLayoutY(118);
		tf4.setPrefWidth(175);

		TextField tf5 = new TextField();
		tf5.setPromptText("Nom de la personne référente");
		tf5.setLayoutX(54);
		tf5.setLayoutY(156);
		tf5.setPrefWidth(175);

		TextField tf6 = new TextField();
		tf6.setPromptText("adresse exacte");
		tf6.setLayoutX(54);
		tf6.setLayoutY(212);
		tf6.setPrefWidth(175);

		TextField tf7 = new TextField();
		tf7.setPromptText("n°batiment/étage/porte/code");
		tf7.setLayoutX(276);
		tf7.setLayoutY(212);
		tf7.setPrefWidth(175);

		TextField tf8 = new TextField();
		tf8.setPromptText("Nom");
		tf8.setLayoutX(54);
		tf8.setLayoutY(265);
		tf8.setPrefWidth(175);

		TextField tf9 = new TextField();
		tf9.setPromptText("adresse");
		tf9.setLayoutX(276);
		tf9.setLayoutY(265);
		tf9.setPrefWidth(175);

		TextField tf10 = new TextField();
		tf10.setPromptText("téléphone");
		tf10.setLayoutX(491);
		tf10.setLayoutY(265);
		tf10.setPrefWidth(175);

		TextField tf11 = new TextField();
		tf11.setPromptText("Nom");
		tf11.setLayoutX(54);
		tf11.setLayoutY(315);
		tf11.setPrefWidth(175);

		TextField tf12 = new TextField();
		tf12.setPromptText("téléphone");
		tf12.setLayoutX(276);
		tf12.setLayoutY(315);
		tf12.setPrefWidth(175);

		TextField tf13 = new TextField();
		tf13.setPromptText("Nom");
		tf13.setLayoutX(54);
		tf13.setLayoutY(366);
		tf13.setPrefWidth(175);

		TextField tf14 = new TextField();
		tf14.setPromptText("téléphone");
		tf14.setLayoutX(276);
		tf14.setLayoutY(366);
		tf14.setPrefWidth(175);

		Label texte1 = new Label("adresse: ");
		texte1.setUnderline(true);
		texte1.setLayoutX(22);
		texte1.setLayoutY(195);

		Label texte2 = new Label("Informations du medecin: ");
		texte2.setUnderline(true);
		texte2.setLayoutX(22);
		texte2.setLayoutY(248);

		Label texte3 = new Label("Informations de la phamacie: ");
		texte3.setUnderline(true);
		texte3.setLayoutX(22);
		texte3.setLayoutY(298);

		Label texte4 = new Label("Informations du laboratoire: ");
		texte4.setUnderline(true);
		texte4.setLayoutX(22);
		texte4.setLayoutY(349);

		Label title = new Label("Formulaire d'inscription");
		title.setId("title");
		title.setLayoutX(198);
		title.setLayoutY(0);

		RadioButton radio1 = new RadioButton("homme");
		radio1.setLayoutX(165);
		radio1.setLayoutY(417);
		ToggleGroup grp = new ToggleGroup();
		radio1.setToggleGroup(grp);

		RadioButton radio2 = new RadioButton("femme");
		radio2.setLayoutX(318);
		radio2.setLayoutY(417);
		radio2.setToggleGroup(grp);
		Label sexe = new Label("sexe: ");
		sexe.setLayoutX(54);
		sexe.setLayoutX(414);

		Label etatl = new Label("Devrivez votre sutiations en qelques mots: ");
		etatl.setLayoutX(14);
		etatl.setLayoutY(461);

		Button finale = new Button("S'inscrire");
		finale.setLayoutX(45);
		finale.setLayoutY(556);

		TextField etat = new TextField();
		etat.setLayoutX(49);
		etat.setLayoutY(479);
		etat.setId("etat");

		radio1.setOnAction(e -> {
			gender = radio1.getText();
		});
		radio2.setOnAction(e -> {
			gender = radio2.getText();
		});

		fm1.getChildren().addAll(rct2, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14,
				texte1, texte2, texte3, texte4, title, finale, sexe, radio1, radio2, etat, etatl, pass, confpass, mail);
		Scene fm = new Scene(fm1, 700, 600);
		fm1.getStylesheets().add("hey.Css");
		ins.setOnMouseClicked(e -> primaryStage.setScene(fm));

		primaryStage.setScene(scene1);

	

		/*
		 * ----------------------------------tableau des patients
		 * inscrits-------------------------------------------
		 
//------------------------------------------------------------------------------------------------------------

		TableView<Patient> table1 = new TableView<>();
		TableColumn<Patient, String> col1 = new TableColumn<Patient, String>("nom_inscrit");
		col1.setMinWidth(100);
		col1.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		TableColumn<Patient, String> col2 = new TableColumn<Patient, String>("prénom_inscrit");
		col2.setMinWidth(100);
		col2.setCellValueFactory(new PropertyValueFactory<>("Prénom"));
		TableColumn<Patient, String> col3 = new TableColumn<Patient, String>("email_inscrit");
		col3.setMinWidth(100);
		col3.setCellValueFactory(new PropertyValueFactory<>("email"));
		TableColumn<Patient, String> col4 = new TableColumn<Patient, String>("birthday_inscrit");
		col4.setMinWidth(100);
		col4.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		TableColumn<Patient, String> col5 = new TableColumn<Patient, String>("password_inscrit");
		col5.setMinWidth(100);
		col5.setCellValueFactory(new PropertyValueFactory<>("password"));
		TableColumn<Patient, String> col6 = new TableColumn<Patient, String>("confpassword_inscrit");
		col6.setMinWidth(100);
		col6.setCellValueFactory(new PropertyValueFactory<>("confpassword"));
		TableColumn<Patient, Integer> col7 = new TableColumn<Patient, Integer>("numSecSociale_inscrit");
		col7.setMinWidth(100);
		col7.setCellValueFactory(new PropertyValueFactory<>("numSecSociale"));
		TableColumn<Patient, String> col8 = new TableColumn<Patient, String>("personneRefePatient_inscrit");
		col8.setMinWidth(100);
		col8.setCellValueFactory(new PropertyValueFactory<>("personneRefe"));
		TableColumn<Patient, String> col9 = new TableColumn<Patient, String>("adressePatient_inscrit");
		col9.setMinWidth(100);
		col9.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		TableColumn<Patient, String> col10 = new TableColumn<Patient, String>("adresseprop_inscrit");
		col10.setMinWidth(100);
		col10.setCellValueFactory(new PropertyValueFactory<>("adresseprop"));
		TableColumn<Patient, String> col11 = new TableColumn<Patient, String>("nomMed_inscrit");
		col11.setMinWidth(100);
		col11.setCellValueFactory(new PropertyValueFactory<>("nomMed"));
		TableColumn<Patient, String> col12 = new TableColumn<Patient, String>("addMedecin_inscrit");
		col12.setMinWidth(100);
		col12.setCellValueFactory(new PropertyValueFactory<>("addMed"));
		TableColumn<Patient, Integer> col13 = new TableColumn<Patient, Integer>("telMededecin_inscrit");
		col13.setMinWidth(100);
		col13.setCellValueFactory(new PropertyValueFactory<>("telMed"));
		TableColumn<Patient, String> col14 = new TableColumn<Patient, String>("nomPharm_inscrit");
		col14.setMinWidth(100);
		col14.setCellValueFactory(new PropertyValueFactory<>("nomPharm"));
		TableColumn<Patient, Integer> col15 = new TableColumn<Patient, Integer>("telPharmacie_inscrit");
		col15.setMinWidth(100);
		col15.setCellValueFactory(new PropertyValueFactory<>("telPharm"));
		TableColumn<Patient, String> col16 = new TableColumn<Patient, String>("nomLabo_inscrit");
		col16.setMinWidth(100);
		col16.setCellValueFactory(new PropertyValueFactory<>("nomLab"));
		TableColumn<Patient, String> col17 = new TableColumn<Patient, String>("telLab_inscrit");
		col17.setMinWidth(100);
		col17.setCellValueFactory(new PropertyValueFactory<>("telLab"));
		TableColumn<Patient, String> col18 = new TableColumn<Patient, String>("genderPatient");
		col18.setMinWidth(100);
		col18.setCellValueFactory(new PropertyValueFactory<>("gender"));
		TableColumn<Patient, String> col19 = new TableColumn<Patient, String>("situation");
		col19.setMinWidth(100);
		col19.setCellValueFactory(new PropertyValueFactory<>("situation"));

//----------------------------------TABLEAU DES PATIENTS--------------------------------------------------		
//--------------------------------------------------------------------------------------------------------

		TableView<Patient> table2 = new TableView<>();
		TableColumn<Patient, String> cola = new TableColumn<Patient, String>("nom");
		cola.setMinWidth(100);
		cola.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		TableColumn<Patient, String> colb = new TableColumn<Patient, String>("prenom");
		colb.setMinWidth(100);
		colb.setCellValueFactory(new PropertyValueFactory<>("Prénom"));
		TableColumn<Patient, String> colc = new TableColumn<Patient, String>("e_mail");
		colc.setMinWidth(100);
		colc.setCellValueFactory(new PropertyValueFactory<>("email"));
		TableColumn<Patient, String> cold = new TableColumn<Patient, String>("birth_day");
		cold.setMinWidth(100);
		cold.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		TableColumn<Patient, String> cole = new TableColumn<Patient, String>("pass_word");
		cole.setMinWidth(100);
		cole.setCellValueFactory(new PropertyValueFactory<>("password"));
		TableColumn<Patient, String> colf = new TableColumn<Patient, String>("conf_password");
		colf.setMinWidth(100);
		colf.setCellValueFactory(new PropertyValueFactory<>("confpassword"));
		TableColumn<Patient, Integer> colg = new TableColumn<Patient, Integer>("num_Sec_Soc");
		colg.setMinWidth(100);
		colg.setCellValueFactory(new PropertyValueFactory<>("numSecSociale"));
		TableColumn<Patient, String> colh = new TableColumn<Patient, String>("personne_refePatient");
		colh.setMinWidth(100);
		colh.setCellValueFactory(new PropertyValueFactory<>("personneRefe"));
		TableColumn<Patient, String> coli = new TableColumn<Patient, String>("adresse_patient");
		coli.setMinWidth(100);
		coli.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		TableColumn<Patient, String> colj = new TableColumn<Patient, String>("adresse_prop");
		colj.setMinWidth(100);
		colj.setCellValueFactory(new PropertyValueFactory<>("adresseprop"));
		TableColumn<Patient, String> colk = new TableColumn<Patient, String>("nom_med");
		colk.setMinWidth(100);
		colk.setCellValueFactory(new PropertyValueFactory<>("nomMed"));
		TableColumn<Patient, String> coll = new TableColumn<Patient, String>("add_medecin");
		coll.setMinWidth(100);
		coll.setCellValueFactory(new PropertyValueFactory<>("addMed"));
		TableColumn<Patient, Integer> colm = new TableColumn<Patient, Integer>("tel_mededecin");
		colm.setMinWidth(100);
		colm.setCellValueFactory(new PropertyValueFactory<>("telMed"));
		TableColumn<Patient, String> coln = new TableColumn<Patient, String>("nom_pharmacie");
		coln.setMinWidth(100);
		coln.setCellValueFactory(new PropertyValueFactory<>("nomPharm"));
		TableColumn<Patient, Integer> colo = new TableColumn<Patient, Integer>("tel_pharmacie");
		colo.setMinWidth(100);
		colo.setCellValueFactory(new PropertyValueFactory<>("telPharm"));
		TableColumn<Patient, String> colp = new TableColumn<Patient, String>("nom_labo");
		colp.setMinWidth(100);
		colp.setCellValueFactory(new PropertyValueFactory<>("nomLab"));
		TableColumn<Patient, String> colq = new TableColumn<Patient, String>("tel_laboratoire");
		colq.setMinWidth(100);
		colq.setCellValueFactory(new PropertyValueFactory<>("telLab"));
		TableColumn<Patient, String> colr = new TableColumn<Patient, String>("gender_patient");
		colr.setMinWidth(100);
		colr.setCellValueFactory(new PropertyValueFactory<>("gender"));
		TableColumn<Patient, String> cols = new TableColumn<Patient, String>("situation_du_patient");
		cols.setMinWidth(100);
		cols.setCellValueFactory(new PropertyValueFactory<>("situation"));

//--------------------------------------------------------------------------------------------------------------------------------		
		ObservableList<Patient> datas = FXCollections.observableArrayList();


---------------------------------------methode d'inscription pour patient---------------------------------------                                                                     */		

		/*finale.setOnAction(e -> {
			connexion conn = new connexion();

			try {

				String query = "insert into nouveau_inscrit values('" + tf1.getText() + "','" + tf2.getText() + "','"
						+ mail.getText() + "','" + tf3.getText() + "','" + pass.getText() + "','" + confpass.getText()
						+ "','" + Integer.parseInt(tf4.getText()) + "','" + tf5.getText() + "','" + tf6.getText()
						+ "','" + tf7.getText() + "','" + tf8.getText() + "','" + tf9.getText() + "','"
						+ Integer.parseInt(tf10.getText()) + "','" + tf11.getText() + "','"
						+ Integer.parseInt(tf12.getText()) + "','" + tf13.getText() + "','"
						+ Integer.parseInt(tf14.getText()) + "','" + gender + "','" + etat.getText() + "');";
				conn.getConnection();
				conn.stt(query);
				conn.disconnect();

			} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
	
			}
			tf1.clear();
			mail.clear();
			confpass.clear();
			pass.clear();
			tf11.clear();
			tf2.clear();
			tf12.clear();
			tf3.clear();
			tf13.clear();
			tf4.clear();
			tf14.clear();
			tf5.clear();
			etat.clear();
			tf6.clear();
			tf7.clear();
			tf8.clear();
			tf9.clear();
			tf10.clear();

			Alert lert = new Alert(Alert.AlertType.CONFIRMATION);
			lert.setTitle("message de confirmation");
			lert.setHeaderText(null);
			lert.setContentText("votre demande d'inscription a ete faite avec succes\n"
					+ "veuillez attender la confirmation de votre demande ");
			lert.getButtonTypes().removeAll(ButtonType.CANCEL);
			lert.show();
			primaryStage.setScene(scene);
			primaryStage.show();

		});*/

		/*-----------------------------------------------DASHBOARD---------------------------------------------------*/

		/*VBox dbox = new VBox();
		dbox.setPrefSize(317, 613);
		Pane pane = new Pane();
		pane.setPrefSize(269, 132);
		ImageView logo = new ImageView("file:logof.png");
		logo.setFitWidth(152);
		logo.setFitHeight(66);
		logo.setLayoutY(37);
		logo.setLayoutX(30);
		Label nom = new Label("Bessiad");

		nom.setLayoutX(140);
		nom.setLayoutY(58);
		pane.getChildren().addAll(logo, nom);
		nom.setId("nom");
		Button patients = new Button("Patients");
		Button personnel = new Button("Personnel");
		Button tourne = new Button("Tournées");
		Button users = new Button("Utilisateurs");
		Button rej = new Button("Nouveaux Rejoignatns");
		Button gear = new Button("Settings");
		ImageView icone1 = new ImageView("file:patients.png");
		icone1.setFitWidth(25);
		icone1.setFitHeight(25);
		patients.setGraphic(icone1);
		ImageView icone2 = new ImageView("file:personnel.png");
		icone2.setFitWidth(25);
		icone2.setFitHeight(25);
		personnel.setGraphic(icone2);
		ImageView icone3 = new ImageView("file:tournee.png");
		icone3.setFitWidth(25);
		icone3.setFitHeight(25);
		tourne.setGraphic(icone3);
		ImageView icone4 = new ImageView("file:users.png");
		icone4.setFitWidth(25);
		icone4.setFitHeight(25);
		users.setGraphic(icone4);
		ImageView icone5 = new ImageView("file:newusers.png");
		icone5.setFitWidth(25);
		icone5.setFitHeight(25);
		rej.setGraphic(icone5);
		ImageView icone6 = new ImageView("file:gear.png");
		icone6.setFitWidth(25);
		icone6.setFitHeight(25);
		gear.setGraphic(icone6);

		dbox.getChildren().addAll(pane, patients, personnel, tourne, users, rej, gear);
CadreInfirmier ca=new CadreInfirmier();
		AnchorPane dpane = new AnchorPane();
		dpane.setPrefSize(700, 700);
		dpane.getChildren().addAll(dbox);
		
		dbox.setId("dbox");
		dpane.getStylesheets().add("dboard.CSS");
		Group gr3=new Group();
		gr3.getChildren().add(dpane);
		Scene dscene = new Scene(gr3, 1000, 600);
		primaryStage.setScene(dscene);
		primaryStage.show();
		ObservableList<Patient> donnes = FXCollections.observableArrayList();
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad", "root", "123");
			ResultSet res = conexion.createStatement().executeQuery("select* from nouveau_inscrit;");
			while (res.next()) {
				donnes.add(new Patient(res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
						res.getString("date_de_naissance"), res.getString("password"),
						res.getString("conf_password"), res.getInt("num_sec_soc"),
						res.getString("personne_referente"), res.getString("adresse_maison"),
						res.getString("apartement_exacte"), res.getString("nom_medecin"),
						res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
						res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
						res.getString("sexe"), res.getString("situation"),res.getString("zone_texte")));
			
				}
			conexion.close();	
			
			}
		
		 catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table1.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11,
				col12, col13, col14, col15, col16, col17, col18, col19);
		table1.setItems(donnes);
	
		
		
		rej.setOnAction(e -> {
		
		
			
			HBox hb = new HBox();
			hb.setPrefSize(683, 461);
			hb.setLayoutX(317);
			HBox hb2=new HBox();
			hb2.setPrefSize(683, 37);
			hb2.setLayoutX(319);
			hb2.setLayoutY(562);
			hb2.setSpacing(10);
			
			Button add = new Button("add");
			Button delete = new Button("delete");
			hb2.getChildren().addAll(add,delete);
			hb.getChildren().addAll(table1);
			AnchorPane d=new AnchorPane();
			d.getChildren().addAll(dbox,hb,hb2);
			CadreInfirmier cadre1 = new CadreInfirmier();
			d.getStylesheets().add("dboard.CSS");
			Scene k=new Scene(d,1000,600);
			primaryStage.setScene(k);
			add.setOnAction(e1 -> {
				try {
					cadre1.ajouterDossier(table1, table2);
				} catch (SQLException e2) {
					System.out.println("hey");
					e2.printStackTrace();
				}
				
			}
			
					);
		
		
		});
		
		
		ObservableList<Patient> data=FXCollections.observableArrayList();
		
		Button retour=new Button("back");
		retour.setPrefSize(66, 31);
		retour.setLayoutX(348);
		retour.setLayoutY(539);
	
		
		
		Button parcourt=new Button("Parcourir la liste");
		Button progres=new Button("noter progres");
		Button evaluer=new Button("Evaluer patient");
		Button donne=new Button("donneespatients");
		parcourt.setPrefSize(367, 47);
		progres.setPrefSize(367, 47);
		evaluer.setPrefSize(367, 47);
		donne.setPrefSize(367, 47);
		donne.setLayoutX(326);
		donne.setLayoutY(138);
		parcourt.setLayoutX(416);
		parcourt.setLayoutY(208);
		progres.setLayoutX(500);
		progres.setLayoutY(283);
		evaluer.setLayoutX(566);
		evaluer.setLayoutY(343);
		
		
		patients.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
				
					
					
					
					AnchorPane ch=new AnchorPane();
					ch.getChildren().addAll(dbox,donne,parcourt,progres,evaluer);
					ch.getStylesheets().add("dboard.CSS");
					Scene s=new Scene(ch,1000,600);
					primaryStage.setScene(s);
					
					
					retour.setOnAction(ec ->{
						AnchorPane anc=new AnchorPane();
						anc.getChildren().addAll(dbox,donne,parcourt,progres,evaluer);
						anc.getStylesheets().add("dboard.CSS");
						Scene sn=new Scene(anc,1000,600);
						
						primaryStage.setScene(sn);
						});
					
					
				

			}
		});
		
		
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad", "root", "123");
			ResultSet res = conexion.createStatement().executeQuery("select* from patient;");
			while (res.next()) {
				data.add(new Patient(res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
						res.getString("date_de_naissance"), res.getString("password"),
						res.getString("conf_password"), res.getInt("num_sec_soc"),
						res.getString("personne_referente"), res.getString("adresse_maison"),
						res.getString("apartement_exacte"), res.getString("nom_medecin"),
						res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
						res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
						res.getString("sexe"), res.getString("situation"),res.getString("zone_texte")));
			
				
				
			
				
				
			
			}
		
			conexion.close();
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		table2.setItems(data);
		table2.getColumns().addAll(cola,colb,colc,cold,cole,colf,colg,colh,coli,colj,colk,coll,colm,coln,colo,colp,colq,colr,cols);
		
		
		
		donne.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
			
			
				AnchorPane anchor=new AnchorPane();
				HBox hb3 = new HBox();
				
				hb3.setPrefSize(683, 461);
				hb3.setLayoutX(317);
				
				anchor.setPrefSize(700, 700);
				
				anchor.getStylesheets().add("dboard.CSS");
			
				hb3.getChildren().addAll(table2);
				anchor.getChildren().addAll(dbox,hb3,retour);
				Scene scem=new Scene(anchor,1000,600);
				primaryStage.setScene(scem);
	
			
		
			}

		});
			
		
		*/
		
		
		
		
		
		/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                                         */

	/*	btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event1) {
				LDAPauthentication auth = new LDAPauthentication();
				auth.authent(txt1.getText(), pwd1.getText());
				if (auth.authent(txt1.getText(), pwd1.getText()) == 1) {
					primaryStage.setScene(dscene);
					primaryStage.show();
				} else {
					g1.getChildren().add(error);
					System.out.println("user not found");
				}

			}
		});
		
		
		CadreInfirmier cdre2=new CadreInfirmier();
		
		
	
	
	
		
		parcourt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
				AnchorPane uih=new AnchorPane();
				uih.setPrefSize(700, 700);
				uih.getStylesheets().add("dboard.CSS");
				VBox window=new VBox();
				window.setPrefSize(677, 47);
				window.setLayoutX(400);
				try {
					window.getChildren().add(cdre2.parcourirList());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				uih.getChildren().addAll(dbox,window,retour);
				Scene scenee=new Scene(uih,1000,600);
				
				primaryStage.setScene(scenee);

			}
		});
		*/

	
		

		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
