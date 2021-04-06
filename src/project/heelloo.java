package project;
import map.MapController;
import map.MapController.*;
import retrofit2.http.Field;
import session.UserRole;
import database.LDAPauthentication;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.converter.LocalDateTimeStringConverter;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.RunnableFuture;

import javax.management.Notification;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.controlsfx.control.Notifications;
import org.eclipse.birt.chart.extension.aggregate.Count;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
//import com.lynden.gmapsfx.javascript.object.MapType;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.unboundid.util.RateAdjustor;

import Classes.CadreInfirmier;
import Classes.Conge;
import Classes.Patient;
import Classes.Personnel;
import Classes.Progres;
import Classes.Surveillance;
import Classes.abscence;
import Classes.evaluation;
import Classes.evaluationp;
import Classes.observation;
import Classes.progrep;
import Classes.rdv;
import database.connexion;

public class heelloo extends Application {
	public String idholder;
	private String gender;
public Logger logger;
public String user_pat;
public String Cadreinf;
public String userpe;
public String userpa;
public String Respo;
public int id,idd;
Patient pat=new Patient();
Personnel per=new Personnel();
CadreInfirmier cad=new CadreInfirmier();

	
	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws SQLException, IllegalStateException {

		per.setLogin(userpe);
		logger = Logger.getLogger(heelloo.class);
		
		// ---------------LOGIN SCENE patient-------------------------

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

		Button btn1 = new Button("Connexion");
		Button btn2 = new Button("quitter");
		Button btn5 = new Button("retour");

		btn1.setLayoutY(306);
		btn1.setLayoutX(390);
		btn2.setLayoutX(504);
		btn2.setLayoutY(306);
		btn1.setBlendMode(BlendMode.ADD);
		btn2.setBlendMode(BlendMode.ADD);
		btn1.setTextFill(cycleGrad3);
		btn2.setTextFill(cycleGrad3);
		btn5.setLayoutX(450);
		btn5.setLayoutY(360);
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
		btn2.setOnAction(e -> {
			logger.debug("primaryStage closed");
			primaryStage.close();});

//ZONE DES LABELS

		Label l1 = new Label("bienvenue dans notre espace");
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
		txt2.setText("Username:");
		txt3.setText("Password : ");
		txt2.setLayoutX(339);
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
		Image image2 = new Image("file:C:\\Users\\skoupa\\eclipse-workspace\\khalid\\patient1.gif");
		Image image1 = new Image("file:C:\\Users\\skoupa\\eclipse-workspace\\khalid\\gif1.gif");
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
		pane1.setId("pane");

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
		Label error = new Label("Nom d'utilisateur ou mot de passe incorrecte veuiller réessayer! ");
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
		
		

		// ---------------LOGIN SCENE personnel-------------------------

		// ZONE CODE DU STAGE
		primaryStage.setTitle("BESSIAD");

		// ZONE CODE DES GROUPES
		Group gra = new Group();
		Button btn1a = new Button("hello login successful");
		btn1a.setLayoutX(300);
		btn1a.setLayoutY(200);
		gra.getChildren().add(btn1a);
//ZONE CODE DES SCENES
		Scene sceneb = new Scene(gra, 600, 450);


// ZONE DES BOUTTONS

		Button btn1b = new Button("connexion");
		Button btnc = new Button("quitter");
		Button btnd = new Button("retour");

		btn1b.setLayoutY(306);
		btn1b.setLayoutX(390);
		btnc.setLayoutX(504);
		btnc.setLayoutY(306);
		btn1b.setBlendMode(BlendMode.ADD);
		btnc.setBlendMode(BlendMode.ADD);
		btn1b.setTextFill(cycleGrad3);
		btnc.setTextFill(cycleGrad3);
		btnd.setLayoutX(460);
		btnd.setLayoutY(360);
		btnd.setId("btn5");
		ImageView backp = new ImageView("file:back.png");
		backp.setFitWidth(15);
		backp.setFitHeight(15);
		btnd.setGraphic(back);
		Font fb = new Font("BoldSystem", 15);
		btn1b.setFocusTraversable(true);
		btnc.setFont(f2);
		btn1b.setFont(f2);
		btn1b.setDefaultButton(true);
		btnc.setOnAction(e -> primaryStage.close());

//ZONE DES LABELS

		Label la = new Label("welcome to our space");
		la.setLayoutX(15);
		la.setLayoutY(48);
		la.setTextFill(Color.WHITE);
		la.setTextOverrun(OverrunStyle.CLIP);
		Font fa = new Font("Algerian", 23);
		la.setFont(f1);
		la.setTextFill(cycleGrad);
		Label inscr = new Label("inscrivez-vous");
		inscr.setLayoutX(450);
		inscr.setLayoutY(280);
		inscr.setTextFill(cycleGrad);
		inscr.setId("ins");
		// Cursor.
//zone des texts

		Text txtb = new Text();
		Text txtc = new Text();
		txtb.setText("nom d'utilisateur: ");
				
		txtc.setText("mot de passe : ");
		txtb.setLayoutX(290);
		txtb.setLayoutY(213);
		txtc.setLayoutX(310);
		txtc.setLayoutY(258);
		txtb.setFont(f2);
		txtc.setFont(f2);
		txtb.setFill(cycleGrad3);
		txtc.setFill(cycleGrad3);
		txtb.setTranslateX(3);
		txtb.setUnderline(true);
		txtc.setUnderline(true);
// zone des textfields

		TextField txta = new TextField();
		PasswordField pwda = new PasswordField();
		txta.setPromptText("Username-Field");//cadre/respo
		pwda.setPromptText("Password-Field");
		txta.setLayoutX(417);
		txta.setLayoutY(196);
		pwda.setLayoutX(417);
		pwda.setLayoutY(241);

//------------------------------------------ LES PANELS------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

		// Vboxes
		VBox boxa = new VBox();
		VBox boxb = new VBox();
		Image imageb = new Image("file:C:\\Users\\skoupa\\eclipse-workspace\\khalid\\patient1.gif");
		Image imagea = new Image("file:C:\\Users\\skoupa\\eclipse-workspace\\khalid\\gif1.gif");
		Image ica = new Image("file:icone1.png");
		ImageView ivb= new ImageView();
		ImageView iva = new ImageView();
		ImageView ivc = new ImageView();
		iva.setImage(imagea);
		iva.setFitHeight(100);
		iva.fitHeightProperty().bind(primaryStage.heightProperty());
		iva.setFitWidth(293);
		ivb.setImage(image2);
		ivb.setFitHeight(163);
		ivb.setFitWidth(340);
		ivb.setLayoutX(350);
		ivb.setTranslateX(-5);

		AnchorPane panea = new AnchorPane();

		boxa.getChildren().add(iva);
		AnchorPane ga= new AnchorPane();
		ga.setPrefWidth(300);
		ga.setPrefHeight(401);
		ga.setLayoutX(0);
		ga.setLayoutY(0);
		Rectangle rcta = new Rectangle();
		rcta.setTranslateX(290);
		rcta.setLayoutX(0);
		rcta.setWidth(1000);
		rcta.setHeight(1000);
		rcta.setId("rcta");
		Label errore = new Label(" wrong user id or password! please try again ");
		errore.setLayoutX(100);
		errore.setLayoutY(430);
		errore.setId("error");
		// rct1.setFill(Color.#2a282a);
		panea.getChildren().add(rcta);
		ga.getChildren().addAll(ivb, txta, txtb, txtc, pwda, btn1b, btnc, btnd);
		panea.getChildren().addAll(boxa, ga);
		panea.getChildren().add(la);
		Scene scenep = new Scene(panea, 700, 450);

		
		btn4.setOnAction((e -> primaryStage.setScene(scene)));
		
		
		
		//---------------------------------Login scene pour personnel-------------------------------//
		
	



// ZONE DES BOUTTONS

		Button btnx = new Button("Connexion");
		Button btny = new Button("Quitter");
		

		btnx.setLayoutY(306);
		btnx.setLayoutX(390);
		btny.setLayoutX(504);
		btny.setLayoutY(306);
		btnx.setBlendMode(BlendMode.ADD);
		btny.setBlendMode(BlendMode.ADD);
		btnx.setTextFill(Color.BLACK);
		btny.setTextFill(Color.BLACK);
		Button btnz=new Button("back");
		btnz.setLayoutX(450);
		btnz.setLayoutY(360);
		btnz.setPrefWidth(70);
		btnz.setId("btn5");
	btny.setOnAction(e-> primaryStage.close());
	


		// Cursor.

// zone des textfields

		TextField txtx = new TextField();
		PasswordField pwdx = new PasswordField();
		txtx.setPromptText("Nom d'utilisateur");//personnelee
		pwdx.setPromptText("Mot de passe");
		txtx.setLayoutX(417);
		txtx.setLayoutY(196);
		pwdx.setLayoutX(417);
		pwdx.setLayoutY(241);
ImageView xx=new ImageView("file:login.jpg");
xx.setFitWidth(1000);
xx.setFitHeight(600);
xx.fitHeightProperty().bind(primaryStage.heightProperty());
xx.fitWidthProperty().bind(primaryStage.widthProperty());

//------------------------------------------ LES PANELS------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------

	

		

		
		AnchorPane pp1 = new AnchorPane();
		pp1.setPrefWidth(1000);
		pp1.setPrefHeight(600);
		pp1.setLayoutX(0);
		pp1.setLayoutY(0);
	
		
		
		pp1.getChildren().addAll(xx,txtx,pwdx,btnx,btny,btnz);
	
		Scene pero = new Scene(pp1, 1000, 600);


		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

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
		Button btna = new Button("Espace Cadre/responsable");
		Button btnb = new Button("Espace Patient");
		Button btnp=new Button("espace personnel");
		btnp.setLayoutX(200);
		btnp.setLayoutY(340);
		btna.setLayoutX(37);
		btna.setPickOnBounds(true);
		btna.setLayoutY(281);
		btnb.setLayoutX(356);
		btnb.setLayoutY(281);
		btna.setTextFill(cycleGrad);
		btnp.setTextFill(cycleGrad);
		btna.setOnAction(e -> primaryStage.setScene(scenep));
		btnb.setTextFill(cycleGrad);
		btnb.setOnAction(e -> primaryStage.setScene(scene));
	
	
		
		
	
		panel1.getChildren().addAll(btna, btnb,btnp);
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
		btn5.setOnAction(e-> primaryStage.setScene(scene1));

		btnd.setOnAction(e -> primaryStage.setScene(scene1));
		btnd.setMaxSize(100, 100);

		imgvw.fitWidthProperty().bind(primaryStage.widthProperty());
		imgvw.fitHeightProperty().bind(primaryStage.heightProperty());
btnp.setOnAction(e-> primaryStage.setScene(pero));
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
		TextField tf0=new TextField();
		tf0.setPromptText("username");
		tf0.setLayoutX(491);
		tf0.setLayoutY(42);
		tf0.setPrefWidth(175);
		
		
		TextField mail = new TextField();
		mail.setPromptText("email");
		mail.setLayoutX(54);
		mail.setLayoutY(81);
		mail.setPrefWidth(175);

		PasswordField confpass = new PasswordField();
		confpass.setPromptText("confirmation password");
		confpass.setLayoutX(491);
		confpass.setLayoutY(81);
		confpass.setPrefWidth(175);

		PasswordField pass = new PasswordField();
		pass.setPromptText("password");
		pass.setLayoutX(276);
		pass.setLayoutY(81);
		pass.setPrefWidth(175);

		DatePicker tf3 = new DatePicker();
		tf3.setPromptText("Date de naissance: jj/mm/aaaa");
		tf3.setLayoutX(276);
		tf3.setLayoutY(118);
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
		tf6.setPromptText("rue,quartier,ville");
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
		sexe.setLayoutX(125);
		sexe.setLayoutY(418);

		Label etatl = new Label("Devrivez votre sutiations en qelques mots: ");
		etatl.setLayoutX(14);
		etatl.setLayoutY(461);
		Label error1 = new Label("nom d'utilisateur éxiste déjà !");
		error1.setLayoutX(433);
		error1.setLayoutY(461);
		error1.setId("error");
		Label error2 = new Label("numero existe déjà!");
		error2.setLayoutX(433);
		error2.setLayoutY(488);
		error2.setId("error");
		Label error3 = new Label("email existe déjà!");
		error3.setLayoutX(433);
		error3.setLayoutY(515);
		error3.setId("error");

		Label error4 = new Label("veuillez preciser votre sexe !");
		error4.setLayoutX(433);
		error4.setLayoutY(542);
		error4.setId("error");
		Label error5 = new Label("mots de passe différents !");
		error5.setLayoutX(433);
		error5.setLayoutY(569);
		error5.setId("error");
		Label error6 = new Label("id existe déjà !");
		error6.setLayoutX(433);
		error6.setLayoutY(488);
		error6.setId("error");

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

		fm1.getChildren().addAll(rct2, tf1, tf2,tf0,mail,pass,confpass,tf4,tf3, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14,
				texte1, texte2, texte3, texte4, title, finale, sexe, radio1, radio2, etat, etatl);
		Scene fm = new Scene(fm1, 700, 600);
		fm1.getStylesheets().add("hey.Css");
		ins.setOnMouseClicked(e -> primaryStage.setScene(fm));

		primaryStage.setScene(scene1);

	

		/*
		 * ----------------------------------tableau des patients
		 * inscrits-------------------------------------------
		 */
//------------------------------------------------------------------------------------------------------------

		TableView<Patient> table1 = new TableView<>();
		TableColumn<Patient, String> col00 = new TableColumn<Patient, String>("username");
		col00.setMinWidth(100);
		col00.setCellValueFactory(new PropertyValueFactory<>("username"));
		col00.setVisible(true);
		TableColumn<Patient, Integer> col0 = new TableColumn<Patient, Integer>("id");
		col0.setMinWidth(100);
		col0.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<Patient, String> col1 = new TableColumn<Patient, String>("nom_inscrit");
		col1.setMinWidth(100);
		col1.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		TableColumn<Patient, String> col2 = new TableColumn<Patient, String>("prénom_inscrit");
		col2.setMinWidth(100);
		col2.setCellValueFactory(new PropertyValueFactory<>("Prénom"));
		TableColumn<Patient, String> col3 = new TableColumn<Patient, String>("email_inscrit");
		col3.setMinWidth(100);
		col3.setCellValueFactory(new PropertyValueFactory<>("email"));
		TableColumn<Patient, Date> col4 = new TableColumn<Patient, Date>("birthday_inscrit");
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
		col19.setMinWidth(500);
		col19.setCellValueFactory(new PropertyValueFactory<>("situation"));
		TableColumn<Patient, String> col20 = new TableColumn<Patient, String>("zone_texte");
		col20.setMinWidth(500);
		col20.setCellValueFactory(new PropertyValueFactory<>("zone"));
		TableColumn<Patient, String> col21 = new TableColumn<Patient, String>("nom_acteur");
		col21.setMinWidth(100);
		col21.setCellValueFactory(new PropertyValueFactory<>("nom_acteur"));
		TableColumn<Patient, String> col22 = new TableColumn<Patient, String>("fonctionalite_acteur");
		col22.setMinWidth(100);
		col22.setCellValueFactory(new PropertyValueFactory<>("fonctionalite_acteur"));
		TableColumn<Patient, String> col23 = new TableColumn<Patient, String>("adresse_acteur");
		col23.setMinWidth(150);
		col23.setCellValueFactory(new PropertyValueFactory<>("adresse_acteur"));
		TableColumn<Patient, Integer> col24= new TableColumn<Patient, Integer>("tel_acteur");
		col24.setMinWidth(100);
		col24.setCellValueFactory(new PropertyValueFactory<>("tel_acteur"));

//----------------------------------TABLEAU DES PATIENTS--------------------------------------------------		
//--------------------------------------------------------------------------------------------------------

		TableView<Patient> table2 = new TableView<>();
		TableColumn<Patient, String> colzz = new TableColumn<Patient, String>("username");
		colzz.setMinWidth(100);
		colzz.setEditable(true);
		colzz.setCellValueFactory(new PropertyValueFactory<>("username"));
		TableColumn<Patient, Integer> colz = new TableColumn<Patient, Integer>("id");
		colz.setMinWidth(100);
		colz.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<Patient, String> cola = new TableColumn<Patient, String>("nom");
		cola.setMinWidth(100);
		cola.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		TableColumn<Patient, String> colb = new TableColumn<Patient, String>("prenom");
		colb.setMinWidth(100);
		colb.setCellValueFactory(new PropertyValueFactory<>("Prénom"));
		TableColumn<Patient, String> colc = new TableColumn<Patient, String>("e_mail");
		colc.setMinWidth(100);
		colc.setCellValueFactory(new PropertyValueFactory<>("email"));
		TableColumn<Patient, Date> cold = new TableColumn<Patient, Date>("birth_day");
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
		cols.setMinWidth(500);
		cols.setCellValueFactory(new PropertyValueFactory<>("situation"));
		TableColumn<Patient, Integer> colt = new TableColumn<Patient, Integer>("zone_texte");
		colt.setMinWidth(500);
		colt.setCellValueFactory(new PropertyValueFactory<>("zone"));
		TableColumn<Patient, String> colu = new TableColumn<Patient, String>("nom_acteur");
		colu.setMinWidth(100);
		colu.setCellValueFactory(new PropertyValueFactory<>("nom_acteur"));
		TableColumn<Patient, String> colv = new TableColumn<Patient, String>("fonctionalite_acteur");
		colv.setMinWidth(100);
		colv.setCellValueFactory(new PropertyValueFactory<>("fonctionalite_acteur"));
		TableColumn<Patient, String> colw = new TableColumn<Patient, String>("adresse_acteur");
		colw.setMinWidth(150);
		colw.setCellValueFactory(new PropertyValueFactory<>("adresse_acteur"));
		TableColumn<Patient, Integer> colx= new TableColumn<Patient, Integer>("tel_acteur");
		colx.setMinWidth(100);
		colx.setCellValueFactory(new PropertyValueFactory<>("tel_acteur"));

		
		
//-------------------------------TABLEAU DES Progres---------------------------------------------
//-----------------------------------------------------------------------------------------------
		TableView<Progres> table3 = new TableView<>();
		TableColumn<Progres, Integer> co0 = new TableColumn<Progres, Integer>("id_patient");
		co0.setMinWidth(100);
		co0.setCellValueFactory(new PropertyValueFactory<>("id_patient"));
		TableColumn<Progres, Date> co1 = new TableColumn<Progres, Date>("date");
		co1.setMinWidth(100);
		co1.setCellValueFactory(new PropertyValueFactory<>("Date"));
		TableColumn<Progres, String> co2 = new TableColumn<Progres, String>("nom_patient");
		co2.setMinWidth(200);
		co2.setCellValueFactory(new PropertyValueFactory<>("nom_patient"));
		TableColumn<Progres, String> co3 = new TableColumn<Progres, String>("Prenom_patient");
		co3.setMinWidth(200);
		co3.setCellValueFactory(new PropertyValueFactory<>("Prenom_patient"));
		TableColumn<Progres, Integer> co4 = new TableColumn<Progres, Integer>("note_physiologie");
		co4.setMinWidth(100);
		co4.setCellValueFactory(new PropertyValueFactory<>("note_physiologie"));
		TableColumn<Progres, Integer> co5 = new TableColumn<Progres, Integer>("note_psychologie");
		co5.setMinWidth(100);
		co5.setCellValueFactory(new PropertyValueFactory<>("note_psychologie"));
		TableColumn<Progres, Integer> co6 = new TableColumn<Progres, Integer>("note_socialogie");
		co6.setMinWidth(100);
		co6.setCellValueFactory(new PropertyValueFactory<>("note_socialogie"));
		table3.getColumns().addAll(co0,co1,co2,co3,co4,co5,co6);
		//------------------------tabel d'evaluation------------------------------------
		TableView<evaluation> table4 = new TableView<>();
		TableColumn<evaluation, Integer> c0 = new TableColumn<evaluation, Integer>("id_pateint");
		c0.setMinWidth(100);
		c0.setCellValueFactory(new PropertyValueFactory<>("id_patient"));
		TableColumn<evaluation, Date> c1 = new TableColumn<evaluation, Date>("date");
		c1.setMinWidth(100);
		c1.setCellValueFactory(new PropertyValueFactory<>("Date"));
		TableColumn<evaluation,String> c2 = new TableColumn<evaluation, String>("nom_patient");
		c2.setMinWidth(100);
		c2.setCellValueFactory(new PropertyValueFactory<>("nom_patient"));
		TableColumn<evaluation,String> c3 = new TableColumn<evaluation, String>("Prenom_patient");
		c3.setMinWidth(100);
		c3.setCellValueFactory(new PropertyValueFactory<>("Prenom_patient"));
		TableColumn<evaluation,String> c4 = new TableColumn<evaluation,String>("obs_physiologie");
		c4.setMinWidth(200);
		c4.setCellValueFactory(new PropertyValueFactory<evaluation,String>("obs_physiologie"));
		TableColumn<evaluation,String> c5 = new TableColumn<evaluation,String>("obs_psychologie");
		c5.setMinWidth(200);
		c5.setCellValueFactory(new PropertyValueFactory<>("obs_psychologie"));
		TableColumn<evaluation,String> c6 = new TableColumn<evaluation,String>("obs_sociologie");
		c6.setMinWidth(200);
		c6.setCellValueFactory(new PropertyValueFactory<>("obs_sociologie"));
	table4.getColumns().addAll(c0,c1,c2,c3,c4,c5,c6);
		

	TableView<Personnel> table5 = new TableView<>();
	TableColumn<Personnel, Integer> con1 = new TableColumn<Personnel, Integer>("id");
	con1.setMinWidth(100);
	con1.setCellValueFactory(new PropertyValueFactory<>("id"));
	TableColumn<Personnel, String> con2 = new TableColumn<Personnel, String>("username");
	con2.setMinWidth(100);
	con2.setCellValueFactory(new PropertyValueFactory<>("login"));
	TableColumn<Personnel, String> con3 = new TableColumn<Personnel, String>("password");
	con3.setMinWidth(100);
	con3.setCellValueFactory(new PropertyValueFactory<>("password"));
	TableColumn<Personnel, String> con4 = new TableColumn<Personnel, String>("nom");
	con4.setMinWidth(100);
	con4.setCellValueFactory(new PropertyValueFactory<>("nom"));
	TableColumn<Personnel, String> con5 = new TableColumn<Personnel, String>("prenom");
	con5.setMinWidth(100);
	con5.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	TableColumn<Personnel, Date> con6 = new TableColumn<Personnel, Date>("Date_de_naissance");
	con6.setMinWidth(100);
	con6.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
	TableColumn<Personnel, Long> con7 = new TableColumn<Personnel, Long>("numSecSoc");
	con7.setMinWidth(100);
	con7.setCellValueFactory(new PropertyValueFactory<>("numSecSoc"));
	TableColumn<Personnel, String> con8 = new TableColumn<Personnel, String>("adresse");
	con8.setMinWidth(100);
	con8.setCellValueFactory(new PropertyValueFactory<>("adresse"));
	TableColumn<Personnel, String> con9 = new TableColumn<Personnel, String>("personneRef");
	con9.setMinWidth(100);
	con9.setCellValueFactory(new PropertyValueFactory<>("personneRef"));
	TableColumn<Personnel, String> con10 = new TableColumn<Personnel, String>("secteur_ratt");
	con10.setMinWidth(100);
	con10.setCellValueFactory(new PropertyValueFactory<>("secteur_ratt"));
	TableColumn<Personnel, String> con11 = new TableColumn<Personnel, String>("type_personnel");
	con11.setMinWidth(100);
	con11.setCellValueFactory(new PropertyValueFactory<>("type_personnel"));
	table5.getColumns().addAll(con1,con2,con3,con4,con6,con7,con8,con9,con10,con11);
	
	//------------------------------------------------------------------------------------------
	
	
	TableView<abscence> table6 = new TableView<>();

	TableColumn<abscence, String> cl1 = new TableColumn<abscence, String>("nom");
	cl1.setMinWidth(100);
	cl1.setCellValueFactory(new PropertyValueFactory<>("nom"));
	
	TableColumn<abscence, String> cl2 = new TableColumn<abscence, String>("prenom");
	cl2.setMinWidth(100);
	cl2.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	
	TableColumn<abscence, Date> cl3 = new TableColumn<abscence, Date>("date");
	cl3.setMinWidth(100);
	cl3.setCellValueFactory(new PropertyValueFactory<>("date"));
	
	TableColumn<abscence, String> cl4 = new TableColumn<abscence, String>("abscence");
	cl4.setMinWidth(100);
	cl4.setCellValueFactory(new PropertyValueFactory<>("abscence"));
	table6.getColumns().addAll(cl1,cl2,cl3,cl4);
		
		//-----------------------------------------------------------------------
	TableView<progrep> table7 = new TableView<>();
	
	
	
	TableColumn<progrep, Integer> field1 = new TableColumn<progrep, Integer>("id");
	field1.setMinWidth(100);
	field1.setCellValueFactory(new PropertyValueFactory<>("id"));
	TableColumn<progrep, String> field2 = new TableColumn<progrep, String>("nom_personnel");
	field2.setMinWidth(100);
	field2.setCellValueFactory(new PropertyValueFactory<>("nom"));
	TableColumn<progrep, String> field3 = new TableColumn<progrep, String>("Prenom_personnel");
	field3.setMinWidth(200);
	field3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	TableColumn<progrep, String> field4 = new TableColumn<progrep, String>("note_Qualite");
	field4.setMinWidth(100);
	field4.setCellValueFactory(new PropertyValueFactory<>("note1"));
	TableColumn<progrep, String> field5 = new TableColumn<progrep, String>("note_Effort");
	field5.setMinWidth(100);
	field5.setCellValueFactory(new PropertyValueFactory<>("note2"));
	TableColumn<progrep, String> field6 = new TableColumn<progrep, String>("note_Comportement");
	field6.setMinWidth(100);
	field6.setCellValueFactory(new PropertyValueFactory<>("note3"));
	TableColumn<progrep, Date> field7 = new TableColumn<progrep, Date>("Date");
	field7.setMinWidth(100);
	field7.setCellValueFactory(new PropertyValueFactory<>("date"));
	
		table7.getColumns().addAll(field1,field2,field3,field4,field5,field6,field7);
		
		
		//--------------------------------------------------------------------------
		  
		TableView<evaluationp> table8=new TableView<>();
		TableColumn<evaluationp,Integer> cp1 = new TableColumn<evaluationp, Integer>("id");
		cp1.setMinWidth(200);
		cp1.setCellValueFactory(new PropertyValueFactory<>("id"));		
		
		TableColumn<evaluationp,String> cp2 = new TableColumn<evaluationp, String>("nom_personnel");
		cp2.setMinWidth(200);
		cp2.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<evaluationp,String> cp3 = new TableColumn<evaluationp, String>("Prenom_personnel");
		cp3.setMinWidth(200);
		cp3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		
		TableColumn<evaluationp,String> cp4 = new TableColumn<evaluationp,String>("obs_qualité");
		cp4.setMinWidth(100);
		cp4.setCellValueFactory(new PropertyValueFactory<evaluationp,String>("obsQualite"));
		
		TableColumn<evaluationp,String> cp5 = new TableColumn<evaluationp,String>("obs_effort");
		cp5.setMinWidth(100);
		cp5.setCellValueFactory(new PropertyValueFactory<>("obsEffort"));
		
		TableColumn<evaluationp,String> cp6 = new TableColumn<evaluationp,String>("obs_comportement");
		cp6.setMinWidth(100);
		cp6.setCellValueFactory(new PropertyValueFactory<>("obsComportement"));
		
		
		
		TableColumn<evaluationp, Date> cp7 = new TableColumn<evaluationp, Date>("date");
		cp7.setMinWidth(100);
		cp7.setCellValueFactory(new PropertyValueFactory<>("date"));
		table8.getColumns().addAll(cp1,cp2,cp3,cp4,cp5,cp6,cp7);
		
		TableView<evaluationp> table88=new TableView<>();
		TableColumn<evaluationp,Integer> cpp1 = new TableColumn<evaluationp, Integer>("id");
		cpp1.setMinWidth(200);
		cpp1.setCellValueFactory(new PropertyValueFactory<>("id"));		
		
		TableColumn<evaluationp,String> cpp2 = new TableColumn<evaluationp, String>("nom_personnel");
		cpp2.setMinWidth(200);
		cpp2.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<evaluationp,String> cpp3 = new TableColumn<evaluationp, String>("Prenom_personnel");
		cpp3.setMinWidth(200);
		cpp3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		
		TableColumn<evaluationp,String> cpp4 = new TableColumn<evaluationp,String>("obs_qualité");
		cpp4.setMinWidth(100);
		cpp4.setCellValueFactory(new PropertyValueFactory<evaluationp,String>("obsQualite"));
		
		TableColumn<evaluationp,String> cpp5 = new TableColumn<evaluationp,String>("obs_effort");
		cpp5.setMinWidth(100);
		cpp5.setCellValueFactory(new PropertyValueFactory<>("obsEffort"));
		
		TableColumn<evaluationp,String> cpp6 = new TableColumn<evaluationp,String>("obs_comportement");
		cpp6.setMinWidth(100);
		cpp6.setCellValueFactory(new PropertyValueFactory<>("obsComportement"));
		
		
		
		TableColumn<evaluationp, Date> cpp7 = new TableColumn<evaluationp, Date>("date");
		cpp7.setMinWidth(100);
		cpp7.setCellValueFactory(new PropertyValueFactory<>("date"));
		table88.getColumns().addAll(cpp1,cpp2,cpp3,cpp4,cpp5,cpp6,cpp7);
		
		
		
		
//-----------------------------------cadreinfirmier-------------------------------------//
		TableView<CadreInfirmier> table9 = new TableView<>();
		TableColumn<CadreInfirmier, Integer> fie1 = new TableColumn<CadreInfirmier, Integer>("id");
		fie1.setMinWidth(100);
		fie1.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<CadreInfirmier, String> fie2 = new TableColumn<CadreInfirmier, String>("username");
		fie2.setMinWidth(100);
		fie2.setCellValueFactory(new PropertyValueFactory<>("login"));
		TableColumn<CadreInfirmier, String> fie3 = new TableColumn<CadreInfirmier, String>("password");
		fie3.setMinWidth(100);
		fie3.setCellValueFactory(new PropertyValueFactory<>("password"));
		TableColumn<CadreInfirmier, String> fie4 = new TableColumn<CadreInfirmier, String>("nom");
		fie4.setMinWidth(100);
		fie4.setCellValueFactory(new PropertyValueFactory<>("nom"));
		TableColumn<CadreInfirmier, String> fie5 = new TableColumn<CadreInfirmier, String>("prenom");
		fie5.setMinWidth(100);
		fie5.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		TableColumn<CadreInfirmier, Date> fie6 = new TableColumn<CadreInfirmier, Date>("Date_de_naissance");
		fie6.setMinWidth(100);
		fie6.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
		TableColumn<CadreInfirmier, Long> fie7 = new TableColumn<CadreInfirmier, Long>("numSecSoc");
		fie7.setMinWidth(100);
		fie7.setCellValueFactory(new PropertyValueFactory<>("numSecSoc"));
		TableColumn<CadreInfirmier, String> fie8 = new TableColumn<CadreInfirmier, String>("adresse");
		fie8.setMinWidth(100);
		fie8.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		TableColumn<CadreInfirmier, String> fie9 = new TableColumn<CadreInfirmier, String>("personneRef");
		fie9.setMinWidth(100);
		fie9.setCellValueFactory(new PropertyValueFactory<>("personneRef"));
		TableColumn<CadreInfirmier, String> fie10 = new TableColumn<CadreInfirmier, String>("secteur_ratt");
		fie10.setMinWidth(100);
		fie10.setCellValueFactory(new PropertyValueFactory<>("secteurRattachement"));
	table9.getColumns().addAll(fie1,fie2,fie3,fie4,fie5,fie6,fie7,fie8,fie9,fie10);
	
	
	
	
	
	TableView<evaluationp> tablec=new TableView<>();
	TableColumn<evaluationp,Integer> cp11 = new TableColumn<evaluationp, Integer>("id");
	cp11.setMinWidth(200);
	cp11.setCellValueFactory(new PropertyValueFactory<>("id"));		
	
	TableColumn<evaluationp,String> cp22 = new TableColumn<evaluationp, String>("nom_cadre");
	cp22.setMinWidth(200);
	cp22.setCellValueFactory(new PropertyValueFactory<>("nom"));
	
	TableColumn<evaluationp,String> cp33 = new TableColumn<evaluationp, String>("Prenom_cadre");
	cp33.setMinWidth(200);
	cp33.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	
	TableColumn<evaluationp,String> cp44 = new TableColumn<evaluationp,String>("obs_qualité");
	cp44.setMinWidth(100);
	cp44.setCellValueFactory(new PropertyValueFactory<evaluationp,String>("obsQualite"));
	
	TableColumn<evaluationp,String> cp55 = new TableColumn<evaluationp,String>("obs_effort");
	cp55.setMinWidth(100);
	cp55.setCellValueFactory(new PropertyValueFactory<>("obsEffort"));
	
	TableColumn<evaluationp,String> cp66 = new TableColumn<evaluationp,String>("obs_comportement");
	cp66.setMinWidth(100);
	cp66.setCellValueFactory(new PropertyValueFactory<>("obsComportement"));
	
	
	
	TableColumn<evaluationp, Date> cp77 = new TableColumn<evaluationp, Date>("date");
	cp77.setMinWidth(100);
	cp77.setCellValueFactory(new PropertyValueFactory<>("date"));
	tablec.getColumns().addAll(cp11,cp22,cp33,cp44,cp55,cp66,cp77);
		
		
		//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------
TableView<progrep> table10 = new TableView<>();



TableColumn<progrep, Integer> fc1 = new TableColumn<progrep, Integer>("id_cadre");
fc1.setMinWidth(100);
fc1.setCellValueFactory(new PropertyValueFactory<>("id"));
TableColumn<progrep, String> fc2 = new TableColumn<progrep, String>("nom-cadre");
fc2.setMinWidth(100);
fc2.setCellValueFactory(new PropertyValueFactory<>("nom"));
TableColumn<progrep, String> fc3 = new TableColumn<progrep, String>("Prenom_cadre");
fc3.setMinWidth(200);
fc3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
TableColumn<progrep, String> fc4 = new TableColumn<progrep, String>("note_Qualite");
fc4.setMinWidth(100);
fc4.setCellValueFactory(new PropertyValueFactory<>("note1"));
TableColumn<progrep, String> fc5 = new TableColumn<progrep, String>("note_Effort");
fc5.setMinWidth(100);
fc5.setCellValueFactory(new PropertyValueFactory<>("note2"));
TableColumn<progrep, String> fc6 = new TableColumn<progrep, String>("note_Comportement");
fc6.setMinWidth(100);
fc6.setCellValueFactory(new PropertyValueFactory<>("note3"));
TableColumn<progrep, Date> fc7 = new TableColumn<progrep, Date>("Date");
fc7.setMinWidth(100);
fc7.setCellValueFactory(new PropertyValueFactory<>("date"));

	table10.getColumns().addAll(fc1,fc2,fc3,fc4,fc5,fc6,fc7);
	
	
	//--------------------------table view -----------------------------------------------//
	TableView<Conge> table11 = new TableView<>();
	TableColumn<Conge, Integer> cg1 = new TableColumn<Conge, Integer>("idPersonnel");
	cg1.setMinWidth(100);
	cg1.setCellValueFactory(new PropertyValueFactory<>("idPersonnel"));
	TableColumn<Conge,String> cg2 = new TableColumn<Conge, String>("typeConge");
	cg2.setMinWidth(100);
	cg2.setCellValueFactory(new PropertyValueFactory<>("typeConge"));
	TableColumn<Conge,Date> cg3 = new TableColumn<Conge, Date>("dateDebutConge");
	cg3.setMinWidth(100);
	cg3.setCellValueFactory(new PropertyValueFactory<>("dateDebutConge"));
	TableColumn<Conge,Date> cg4 = new TableColumn<Conge,Date>("dateFinConge");
	cg4.setMinWidth(200);
	cg4.setCellValueFactory(new PropertyValueFactory<>("dateFinConge"));
	TableColumn<Conge,String> cg5 = new TableColumn<Conge,String>("reponse");
	cg5.setMinWidth(200);
	cg5.setCellValueFactory(new PropertyValueFactory<>("reponse"));

table11.getColumns().addAll(cg1,cg2,cg3,cg4,cg5);
	
	
	
TableView<rdv> table12 = new TableView<>();
TableColumn<rdv, Integer> rdv1 = new TableColumn<rdv, Integer>("id_patient");
rdv1.setMinWidth(100);
rdv1.setCellValueFactory(new PropertyValueFactory<>("id_patient"));
TableColumn<rdv,String> rdv2 = new TableColumn<rdv, String>("nom_personnel");
rdv2.setMinWidth(100);
rdv2.setCellValueFactory(new PropertyValueFactory<>("nom_personnel"));
TableColumn<rdv,Date> rdv3 = new TableColumn<rdv, Date>("date_rdv");
rdv3.setMinWidth(100);
rdv3.setCellValueFactory(new PropertyValueFactory<>("date_rdv"));
TableColumn<rdv,Time> rdv4 = new TableColumn<rdv,Time>("temps_rdv");
rdv4.setMinWidth(200);
rdv4.setCellValueFactory(new PropertyValueFactory<>("temps_rdv"));	

table12.getColumns().addAll(rdv1,rdv2,rdv3,rdv4);
	
TableView<observation> table13 = new TableView<>();
TableColumn<observation, Integer> observation1 = new TableColumn<observation, Integer>("id_personnel");
observation1.setMinWidth(100);
observation1.setCellValueFactory(new PropertyValueFactory<>("id_per"));
TableColumn<observation,Integer> observation2 = new TableColumn<observation, Integer>("id_patient");
observation2.setMinWidth(100);
observation2.setCellValueFactory(new PropertyValueFactory<>("id_pat"));
TableColumn<observation,Date> observation3 = new TableColumn<observation, Date>("date");
observation3.setMinWidth(100);
observation3.setCellValueFactory(new PropertyValueFactory<>("date"));
TableColumn<observation,String> observation4 = new TableColumn<observation,String>("observation");
observation4.setMinWidth(200);
observation4.setCellValueFactory(new PropertyValueFactory<>("txt"));	
table13.getColumns().addAll(observation1,observation2,observation3,observation4);



TableView<Surveillance> table14 = new TableView<>();
TableColumn<Surveillance, Integer> Surveillance1 = new TableColumn<Surveillance, Integer>("id_personnel");
Surveillance1.setMinWidth(100);
Surveillance1.setCellValueFactory(new PropertyValueFactory<>("id_personnel"));
TableColumn<Surveillance,String> Surveillance2 = new TableColumn<Surveillance, String>("adresse");
Surveillance2.setMinWidth(100);
Surveillance2.setCellValueFactory(new PropertyValueFactory<>("adresse_patient"));
TableColumn<Surveillance,Date> Surveillance3 = new TableColumn<Surveillance, Date>("date");
Surveillance3.setMinWidth(100);
Surveillance3.setCellValueFactory(new PropertyValueFactory<>("date"));

TableColumn<Surveillance, String> Surveillance5 = new TableColumn<Surveillance, String>("arrive");
Surveillance5.setMinWidth(100);
Surveillance5.setCellValueFactory(new PropertyValueFactory<>("arrive"));
TableColumn<Surveillance,Time> Surveillance6= new TableColumn<Surveillance, Time>("heure_ariive");
Surveillance6.setMinWidth(100);
Surveillance6.setCellValueFactory(new PropertyValueFactory<>("heure_arrive"));
TableColumn<Surveillance,String> Surveillance7 = new TableColumn<Surveillance, String>("quitter");
Surveillance7.setMinWidth(100);
Surveillance7.setCellValueFactory(new PropertyValueFactory<>("quitter"));
TableColumn<Surveillance,Time> Surveillance8 = new TableColumn<Surveillance,Time>("heure_quitter");
Surveillance8.setMinWidth(200);
Surveillance8.setCellValueFactory(new PropertyValueFactory<>("heure_quitter"));
table14.getColumns().addAll(Surveillance1,Surveillance2,Surveillance3,Surveillance5,Surveillance6,Surveillance7,Surveillance8);
	
		 
		
		
		
		
		
		
		
		
//--------------------------------------------------------------------------------------------------------------------------------		
		ObservableList<Patient> datas = FXCollections.observableArrayList();


//*-----------------------------------------methode d'inscription pour patient---------------------------------------                                                                     */		

		finale.setOnAction(e -> {
			
			Connection conexion = null;
try {
	conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
} catch (SQLException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
		
String pss=pass.getText();String cnfpss=confpass.getText();
try {
				int i=0 ,j=0,k=0,l=0;
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count from patient where username='"+tf0.getText()+"';";
				ResultSet rescheck=conexion.createStatement().executeQuery(check);
				while(rescheck.next()) {
					 i=rescheck.getInt("count");
				}

				String check2="select count(*) as count2 from patient where num_sec_soc='"+Integer.parseInt(tf4.getText())+"';";
				ResultSet rescheck2=conexion.createStatement().executeQuery(check2);
				while(rescheck2.next()) {
					 j=rescheck2.getInt("count2");
				}
				String check3="select count(*) as count3 from patient where email='"+mail.getText()+"';";
				ResultSet rescheck3=conexion.createStatement().executeQuery(check3);
				while(rescheck3.next()) {
					 k=rescheck3.getInt("count3");
				}
	// here		
				if(i!=0) {
					fm1.getChildren().remove(error5);
					fm1.getChildren().remove(error4);
					fm1.getChildren().remove(error3);
					fm1.getChildren().remove(error6);
					fm1.getChildren().remove(error1);
					System.out.println(i);
					System.out.println("utilisateur existe déjà");
					fm1.getChildren().add(error1);
					tf0.clear();
					i=0;
					
					
				}else if(j!=0) {
					fm1.getChildren().remove(error5);
					fm1.getChildren().remove(error4);
					fm1.getChildren().remove(error3);
					fm1.getChildren().remove(error1);
					fm1.getChildren().remove(error6);
					fm1.getChildren().add(error6);
					tf4.clear();
					j=0;
					
				    }
			else if(k!=0) {
				fm1.getChildren().remove(error5);
				fm1.getChildren().remove(error4);
				fm1.getChildren().remove(error6);
				fm1.getChildren().remove(error1);
				fm1.getChildren().remove(error3);
				fm1.getChildren().add(error3);
				mail.clear();
				k=0;
		         	}
			else if(gender==null) {
				fm1.getChildren().remove(error5);
				fm1.getChildren().remove(error3);
				fm1.getChildren().remove(error6);
				fm1.getChildren().remove(error1);
				fm1.getChildren().remove(error4);
				fm1.getChildren().add(error4);
				
			}
			
				
			else if(pass.getText().hashCode()!=confpass.getText().hashCode()) {
				System.out.println(pass.getAccessibleText());
				fm1.getChildren().remove(error4);
				fm1.getChildren().remove(error3);
				fm1.getChildren().remove(error6);
				fm1.getChildren().remove(error1);
				fm1.getChildren().remove(error5);
				fm1.getChildren().add(error5);
				pass.clear();confpass.clear();
			}
			
				
				else {   String query = "insert into nouveau_inscrit(username,nom,Prenom,email,date_de_naissance,password,conf_password,num_sec_soc,personne_referente,adresse_maison,apartement_exacte,nom_medecin,adresse_medecin,	tel_medecin,nom_pharma,tel_pharma,nom_lab,tel_lab,sexe,situation) values('" +tf0.getText()+ "','"+ tf1.getText() + "','" + tf2.getText() + "','"
						+ mail.getText() + "','" + tf3.getValue() + "','" + pass.getText() + "','" + confpass.getText()
						+ "','" + Integer.parseInt(tf4.getText()) + "','" + tf5.getText() + "','" + tf6.getText()
						+ "','" + tf7.getText() + "','" + tf8.getText() + "','" + tf9.getText() + "','"
						+ Integer.parseInt(tf10.getText()) + "','" + tf11.getText() + "','"
						+ Integer.parseInt(tf12.getText()) + "','" + tf13.getText() + "','"
						+ Integer.parseInt(tf14.getText()) + "','" + gender + "','" + etat.getText() + "');";
				Statement state=conexion.createStatement();
				state.executeUpdate(query);
				
				Alert lert = new Alert(Alert.AlertType.CONFIRMATION);
				lert.setTitle("message de confirmation");
				lert.setHeaderText(null);
				lert.setContentText("votre demande d'inscription a ete faite avec succes\n"
						+ "veuillez attender la confirmation de votre demande un username vous sera communiquer dans le cas échéant ");
				lert.getButtonTypes().removeAll(ButtonType.CANCEL);
				lert.show();
				primaryStage.setScene(scene);
				primaryStage.show();
				mail.clear();
				confpass.clear();
				pass.clear();
				tf1.clear();
				tf11.clear();
				tf2.clear();
				tf12.clear();
				tf3.setValue(null);
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
				
				}
				

			}
			catch(SQLException e5) {
			e5.printStackTrace();
			}			
		

			/*Notifications notif = Notifications.create();
			notif.title("inscription complete");
			notif.text("un message vous sera communiquer avec votre username");
			notif.position(Pos.CENTER);
			notif.showInformation();*/
			

		});

		/*-----------------------------------------------DASHBOARD---------------------------------------------------*/

		VBox dbox = new VBox();
		dbox.setPrefSize(317, 1000);
	
		Pane pane = new Pane();
		pane.setPrefSize(269, 132);
		ImageView logo = new ImageView("file:logof.png");
		logo.setFitWidth(152);
		logo.setFitHeight(66);
		logo.setLayoutY(37);
		logo.setLayoutX(30);
		ImageView logo1 = new ImageView("file:logof.png");
		logo1.setFitWidth(152);
		logo1.setFitHeight(66);
		logo1.setLayoutY(37);
		logo1.setLayoutX(30);
		ImageView logo2 = new ImageView("file:logof.png");
		logo2.setFitWidth(152);
		logo2.setFitHeight(66);
		logo2.setLayoutY(37);
		logo2.setLayoutX(30);
		ImageView logo3 = new ImageView("file:logof.png");
		logo3.setFitWidth(152);
		logo3.setFitHeight(66);
		logo3.setLayoutY(37);
		logo3.setLayoutX(30);
		Label nom1 = new Label("Bessiad");
		nom1.setLayoutX(140);
		nom1.setLayoutY(58);
		nom1.setId("nom");
		Label nom2 = new Label("Bessiad");
		nom2.setLayoutX(140);
		nom2.setLayoutY(58);
		nom2.setId("nom");
		Label nom3 = new Label("Bessiad");
		nom3.setLayoutX(140);
		nom3.setLayoutY(58);
		nom3.setId("nom");
		ImageView nurse=new ImageView("file:nurse.jpg");
		nurse.setFitWidth(700);
		nurse.setFitHeight(594);
		nurse.setLayoutX(310);;

		
		pane.getChildren().addAll(logo, nom1);
		
		Button Logout =new Button("Se déconnecter");
		Button patients = new Button("Gestion des Patients");
		Button personnel = new Button("Gestion du Personnel");
		Button tourne = new Button("Tournées");
		Button users = new Button("Utilisateurs");
		Button rej = new Button("Nouveaux Rejoignatns");
		Button obs=new Button("Observations");
		Button rv = new Button("rendez_vous");
		Button cadre=new Button("Gestion des cadres infirmiers");
		Button conge=new Button("Congé");
		ImageView iconei = new ImageView("file:conge.png");
		iconei.setFitWidth(28);
		iconei.setFitHeight(28);
		conge.setGraphic(iconei);
		ImageView icone0 = new ImageView("file:doc.png");
		icone0.setFitWidth(25);
		icone0.setFitHeight(25);
		cadre.setGraphic(icone0);
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
		ImageView icone6 = new ImageView("file:calen.png");
		icone6.setFitWidth(25);
		icone6.setFitHeight(25);
		rv.setGraphic(icone6);
		ImageView icone7 = new ImageView("file:lo.png");
		icone7.setFitWidth(25);
		icone7.setFitHeight(25);
		Logout.setGraphic(icone7);
		
		dbox.getChildren().addAll(pane, patients, personnel,cadre,rej, tourne,conge,  rv,obs,Logout);
CadreInfirmier ca=new CadreInfirmier();
		AnchorPane dpane = new AnchorPane();
		
		dpane.setPrefSize(700, 700);
		dpane.getChildren().addAll(dbox,nurse);
		
		dbox.setId("dbox");
		dpane.getStylesheets().add("dboard.CSS");
		
		Scene dscene = new Scene(dpane, 1000, 600);
		Logout.setOnAction(e-> {

			LDAPauthentication auth=new LDAPauthentication();
			dpane.getChildren().removeAll(dbox,nurse);
			dpane.getChildren().addAll(dbox,nurse);
			auth.closeauthent();
			txta.clear();
			pwda.clear();
			primaryStage.setScene(scene1);
		});
	
	//primaryStage.setScene(scene1);
		//primaryStage.show();
		ObservableList<Patient> donnes = FXCollections.observableArrayList();
	
		table1.getColumns().addAll(col0,col00,col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11,
				col12, col13, col14, col15, col16, col17, col18, col19,col20,col21,col22,col23,col24);
		
	
		
		
		rej.setOnAction(e -> {
			
			
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet res = conexion.createStatement().executeQuery("select* from nouveau_inscrit;");
				while (res.next()) {
					donnes.add(new Patient(res.getString("username"),res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
							res.getDate("date_de_naissance"), res.getString("password"),
							res.getString("conf_password"), res.getInt("num_sec_soc"),
							res.getString("personne_referente"), res.getString("adresse_maison"),
							res.getString("apartement_exacte"), res.getString("nom_medecin"),
							res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
							res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
							res.getString("sexe"), res.getString("situation"),res.getString("zone_texte"),res.getString("nom_acteur"),res.getString("fonctionalite_acteur"),res.getString("adresse_acteur"),res.getInt("tel_acteur")));
				
					}
				conexion.close();	
				
				}
			
			 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			table1.setItems(donnes);
			
			HBox hb = new HBox();
			hb.setPrefSize(683, 461);
			hb.setLayoutX(317);
			hb.setLayoutY(60);

			HBox hb2=new HBox();
			hb2.setPrefSize(683, 37);
			hb2.setLayoutX(319);
			hb2.setLayoutY(515);
			hb2.setPadding(new  Insets(15,0,0,141.5));
			Label alab=new Label("tableau des nouveaux inscrits");
			alab.setTextFill(cycleGrad3);
			alab.setFont(f1);
			alab.setUnderline(true);
			alab.setLayoutX(350);
			alab.setLayoutY(14);
	        alab.setId("lab2");
			hb2.setSpacing(80);
			
			Button add = new Button("ajouter");
			add.setId("id");
	
			Button delete = new Button("suprimer");
			delete.setId("id");
			hb2.getChildren().addAll(add,delete);
			hb.isResizable();
			table1.isResizable();
			hb.getChildren().addAll(table1);
			AnchorPane d=new AnchorPane();
			d.getChildren().addAll(dbox,hb,hb2,alab);
			CadreInfirmier cadre1 = new CadreInfirmier();
			d.getStylesheets().add("dboard.CSS");
			d.setId("pane");
			Scene k=new Scene(d,1000,600);
			primaryStage.setScene(k);
			
			
			add.setOnAction(e1 -> {
				try {
				
					
					cadre1.ajouterDossier(table1, table2);
					donnes.clear();
					try {
						Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
						ResultSet res = conexion.createStatement().executeQuery("select* from nouveau_inscrit;");
						while (res.next()) {
							donnes.add(new Patient(res.getString("username"),res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
									res.getDate("date_de_naissance"), res.getString("password"),
									res.getString("conf_password"), res.getInt("num_sec_soc"),
									res.getString("personne_referente"), res.getString("adresse_maison"),
									res.getString("apartement_exacte"), res.getString("nom_medecin"),
									res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
									res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
									res.getString("sexe"), res.getString("situation"),res.getString("zone_texte"),res.getString("nom_acteur"),res.getString("fonctionalite_acteur"),res.getString("adresse_acteur"),res.getInt("tel_acteur")));
							LDAPauthentication auth=new LDAPauthentication();
							auth.addUser(res.getString("username"), res.getString("password"), res.getString("nom"), res.getString("prenom"), res.getString("email"),"patients");					
						
							
							}
						conexion.close();	
						
						}
					
					 catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					
					table1.setItems(donnes);
					
					
					
					
				} catch (SQLException e2) {
					System.out.println("hey");
					e2.printStackTrace();
				}
				
			}
			
					);
		
			delete.setOnAction(ee-> {
				ObservableList<Patient> allPatients,patientSelected;
				patientSelected=FXCollections.observableArrayList();
				allPatients=table1.getItems();
				patientSelected= table1.getSelectionModel().getSelectedItems();
				
				Connection conexion;
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
					Statement state=conexion.createStatement();
					
					for(int i=0;i<patientSelected.size();i++) {
						String query="delete from nouveau_inscrit where id="+patientSelected.get(i).getId()
								+";";
						state.executeUpdate(query);}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				donnes.clear();
				try {
					Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
					ResultSet res = conexion1.createStatement().executeQuery("select* from nouveau_inscrit;");
					while (res.next()) {
						donnes.add(new Patient(res.getString("username"),res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
								res.getDate("date_de_naissance"), res.getString("password"),
								res.getString("conf_password"), res.getInt("num_sec_soc"),
								res.getString("personne_referente"), res.getString("adresse_maison"),
								res.getString("apartement_exacte"), res.getString("nom_medecin"),
								res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
								res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
								res.getString("sexe"), res.getString("situation"),res.getString("zone_texte"),res.getString("nom_acteur"),res.getString("fonctionalite_acteur"),res.getString("adresse_acteur"),res.getInt("tel_acteur")));
					
						}
					conexion1.close();	
					
					}
				
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table1.setItems(donnes);
			
				
			
			});
		
		});
		
		
		ObservableList<Patient> data=FXCollections.observableArrayList();
		
		Button retour=new Button("retour");
		retour.setPrefSize(66, 31);
		retour.setLayoutX(348);
		retour.setLayoutY(555);
	
		
		
		Button parcourt=new Button();
		Button Progres=new Button();
		Button evaluer=new Button();
		Button donne=new Button();
		
		ImageView dossier=new ImageView("file:dossier.png");
		dossier.setFitHeight(140);
		dossier.setFitWidth(155);
		ImageView progres2=new ImageView("file:progres2.png");
		progres2.setFitHeight(140);
		progres2.setFitWidth(155);
		ImageView dossier2=new ImageView("file:dossier2.png");
		dossier2.setFitHeight(140);
		dossier2.setFitWidth(155);
		ImageView dossierc=new ImageView("file:dossierc.png");
		dossierc.setFitHeight(140);
		dossierc.setFitWidth(155);
		ImageView blank=new ImageView("file:blankl.png");
		blank.setFitHeight(140);
		blank.setFitWidth(155);
		ImageView eval=new ImageView("file:eval.png");
		eval.setFitHeight(140);
		eval.setFitWidth(155);
		ImageView evaluation=new ImageView("file:evaluation.png");
		evaluation.setFitHeight(140);
		evaluation.setFitWidth(155);
		ImageView evaluation2=new ImageView("file:evaluation2.png");
		evaluation2.setFitHeight(140);
		evaluation2.setFitWidth(155);
		ImageView evaluerc1=new ImageView("file:evaluerc.png");
		evaluerc1.setFitHeight(140);
		evaluerc1.setFitWidth(155);
		ImageView note=new ImageView("file:note.png");
		note.setFitHeight(140);
		note.setFitWidth(155);
		ImageView progresc=new ImageView("file:progresc.png");
		progresc.setFitHeight(140);
		progresc.setFitWidth(155);
		ImageView listee=new ImageView("file:liste.png");
		listee.setFitHeight(140);
		listee.setFitWidth(155);
		parcourt.setGraphic(listee);
		ImageView surveiller=new ImageView("file:surveiller.png");
		surveiller.setFitHeight(140);
		surveiller.setFitWidth(155);
		
	
		donne.setGraphic(dossier);
		Progres.setGraphic(note);
		evaluer.setGraphic(eval);
		String date;
	    LocalDateTime date1=LocalDateTime.now();
	   DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MMMM dd,YYYY");
	   date=dtf.format(date1);
	   Label labee=new Label();
	   labee.setText(date);
	   labee.setLayoutX(370);
	   labee.setLayoutY(24);
	   Label labee2=new Label("Gestion des Patients");
	   labee2.setLayoutX(570);
	   labee2.setLayoutY(70);
	   labee2.setId("nom");
	   labee2.setUnderline(true);
	   Label labee5=new Label("Surveuillance des mouvements"+"\n"+"                       du personnel             ");
	   labee5.setLayoutX(350);
		labee5.setLayoutY(14);
       labee5.setId("lab2");
	   labee5.setUnderline(true);
	   Label labee3=new Label("Gestion du personnel");
	   labee3.setLayoutX(570);
	   labee3.setLayoutY(70);
	   labee3.setId("nom");
	   labee3.setUnderline(true);
	   Label labee4=new Label("Gestion des Cadres infirmiers");
	   labee4.setLayoutX(570);
	   labee4.setLayoutY(70);
	   labee4.setId("nom");
	   labee4.setUnderline(true);
	   ImageView date11=new ImageView("file:date.png");
		date11.setFitHeight(25);
		date11.setFitWidth(25);
		date11.setLayoutX(340);
		date11.setLayoutY(25);
		labee.setId("nom");
		parcourt.setPrefSize(155, 132);
		Progres.setPrefSize(155, 132);
		evaluer.setPrefSize(155, 132);
		donne.setPrefSize(155, 132);
		donne.setLayoutX(385);
		donne.setLayoutY(148);
		parcourt.setLayoutX(250);
		parcourt.setLayoutY(148);
		Progres.setLayoutX(385);
		Progres.setLayoutY(378);
		evaluer.setLayoutX(757);
		evaluer.setLayoutY(378);
		donne.setId("button");
		parcourt.setId("button");
		Progres.setId("button");evaluer.setId("button");
		
		patients.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
			
				
				TranslateTransition tran1=new TranslateTransition(Duration.seconds(1), parcourt);
				
				tran1.setDelay(Duration.seconds(0));
				tran1.setToX(505);
				tran1.setFromX(80);
				tran1.setCycleCount(1);
				tran1.play();
TranslateTransition tran2=new TranslateTransition(Duration.seconds(1), evaluer);
				
				tran2.setDelay(Duration.seconds(0));
				tran2.setToX(10);
				tran2.setToY(10);
				tran2.setFromY(-230);
				tran2.setFromX(-230);
				tran2.setCycleCount(1);
				tran2.play();
TranslateTransition tran3=new TranslateTransition(Duration.seconds(1), Progres);
				
				tran3.setDelay(Duration.seconds(0));
				tran3.setToY(10);
				tran3.setFromY(-200);
				tran2.setFromX(10);
				tran3.setCycleCount(1);
				tran3.play();
				
				
				
				
					
					AnchorPane ch=new AnchorPane();
					ch.setId("pane");
					ch.getChildren().addAll(dbox,donne,parcourt,Progres,evaluer,labee,date11,labee2);
					ch.getStylesheets().add("dboard.CSS");
					Scene s=new Scene(ch,1000,600);
					primaryStage.setScene(s);
					
					
					retour.setOnAction(ec ->{
						AnchorPane anc=new AnchorPane();
						anc.setId("pane");
						anc.getChildren().addAll(dbox,donne,parcourt,Progres,evaluer);
						anc.getStylesheets().add("dboard.CSS");
						Scene sn=new Scene(anc,1000,600);
						
						primaryStage.setScene(sn);
						});
					
					
				

			}
		});
		
		
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet res = conexion.createStatement().executeQuery("select* from patient;");
			while (res.next()) {
				data.add(new Patient(res.getString("username"),res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
						res.getDate("date_de_naissance"), res.getString("password"),
						res.getString("conf_password"), res.getInt("num_sec_soc"),
						res.getString("personne_referente"), res.getString("adresse_maison"),
						res.getString("apartement_exacte"), res.getString("nom_medecin"),
						res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
						res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
						res.getString("sexe"), res.getString("situation"),res.getString("zone_texte"),res.getString("nom_acteur"),res.getString("fonctionalite_acteur"),res.getString("adresse_acteur"),res.getInt("tel_acteur")));
			
			}
		
			conexion.close();
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		table2.setItems(data);
		table2.getColumns().addAll(colz,colzz,cola,colb,colc,cold,cole,colf,colg,colh,coli,colj,colk,coll,colm,coln,colo,colp,colq,colr,cols,colt,colu,colv,colw,colx);
		
		
		
		donne.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
			data.clear();
				
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
					ResultSet res = conexion.createStatement().executeQuery("select* from patient;");
					while (res.next()) {
						data.add(new Patient(res.getString("username"),res.getInt("id"),res.getString("nom"), res.getString("prenom"), res.getString("email"),
								res.getDate("date_de_naissance"), res.getString("password"),
								res.getString("conf_password"), res.getInt("num_sec_soc"),
								res.getString("personne_referente"), res.getString("adresse_maison"),
								res.getString("apartement_exacte"), res.getString("nom_medecin"),
								res.getString("adresse_medecin"), res.getInt("tel_medecin"), res.getString("nom_pharma"),
								res.getInt("tel_pharma"), res.getString("nom_lab"), res.getInt("tel_lab"),
								res.getString("sexe"), res.getString("situation"),res.getString("zone_texte"),res.getString("nom_acteur"),res.getString("fonctionalite_acteur"),res.getString("adresse_acteur"),res.getInt("tel_acteur")));
					
					}
				
					conexion.close();
				} 
				catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				table2.setItems(data);
				
				
				AnchorPane anchor=new AnchorPane();
				anchor.setId("pane");
				HBox hb3 = new HBox();
				Label lab2=new Label("les données des patients ");
				lab2.setLayoutX(416);
				lab2.setLayoutY(26);
				lab2.setId("lab2");
				hb3.setPrefSize(683, 461);
				hb3.setLayoutX(317);
				hb3.setLayoutY(80);
				anchor.setPrefSize(700, 700);
				retour.setId("id");
				anchor.getStylesheets().add("dboard.CSS");
			
				hb3.getChildren().addAll(table2);
				anchor.getChildren().addAll(dbox,hb3,retour,lab2);
				Scene scem=new Scene(anchor,1000,600);
				primaryStage.setScene(scem);
	
			
		
			}

		});
			
		
		
		
		
		
		
		
		/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                                         */

		btn1b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event1) {
				LDAPauthentication auth = new LDAPauthentication();
				auth.authent(txta.getText(), pwda.getText(),"cadreinfirmier");
				auth.authent(txta.getText(), pwda.getText(),"responsableservice");
				
				if ((auth.authent(txta.getText(), pwda.getText(), "cadreinfirmier") == 1)||((auth.authent(txta.getText(), pwda.getText(), "responsableservice")==1)) ){
					primaryStage.setScene(dscene);
					primaryStage.show();
					logger.info("loggin was a success");
				} else {
					g1.getChildren().add(error);
					System.out.println("user not found");
					logger.debug("smtg wrong login failed");;
				}

			}
		});
		
		
		CadreInfirmier cdre2=new CadreInfirmier();
		
	
	
		
		parcourt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event5) {
				AnchorPane uih=new AnchorPane();
				uih.setId("pane");
				uih.setPrefSize(700, 700);
				uih.getStylesheets().add("dboard.CSS");
				VBox window=new VBox();
				window.setPrefSize(399, 399);
				window.setLayoutX(400);
				window.setLayoutY(89);
				Label desc =new Label("Liste des PAtients");
				desc.setId("desc");
				desc.setLayoutX(511);
				desc.setLayoutY(43);
				try {
					window.getChildren().add(cdre2.parcourirList());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				uih.getChildren().addAll(dbox,window,retour,desc);
				Scene scenee=new Scene(uih,1000,600);
				
				primaryStage.setScene(scenee);

			}
		});
		
		
//----------------------------------Progres patient-------------------------------------------------------
		//------------------------------------------------------------------------------------------------
		
	ObservableList<Progres> progr =FXCollections.observableArrayList();
	try {
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet result = conexion.createStatement().executeQuery("select* from progres;");
		while(result.next()) {
			progr.add(new Progres(result.getInt("id_patient"),result.getDate("Date"),result.getString("Nom"),result.getNString("Prenom"),
					result.getInt("note_physiologie"),result.getInt("note_psychologie"),
					result.getInt("note_sociologie")));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	

	
	table3.setItems(progr);
	
	
		Progres.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event1) {
		
				
				AnchorPane pro=new AnchorPane();
				AnchorPane uih=new AnchorPane();
				uih.setId("pane");
				pro.setId("pane");
				DatePicker date=new DatePicker ();
				Label lab=new Label("Progres des etats des patients");
				lab.setLayoutX(442);
				lab.setLayoutY(14);
                lab.setId("lab2");
				date.setLayoutX(345);
				date.setLayoutY(475);
				date.setPromptText("date");
				TextField name=new TextField();
				name.setPromptText("id_patient");
				name.setLayoutX(589);
				name.setLayoutY(475);
				/*TextField surname=new TextField();
				surname.setPromptText("Prenom patient");
				surname.setLayoutX(786);
				surname.setLayoutY(475);*/
				TextField noteph=new TextField();
				noteph.setPromptText("note de phisiologie");
				noteph.setLayoutX(345);
				noteph.setLayoutY(512);
				TextField noteps=new TextField();
				noteps.setPromptText("note psychologie");
				noteps.setLayoutX(589);
				noteps.setLayoutY(512);
				TextField notesoc=new TextField();
				notesoc.setPromptText("note sociologie");
				notesoc.setLayoutX(786);
				notesoc.setLayoutY(512);
				
				pro.setPrefSize(700, 700);
				pro.getStylesheets().add("dboard.CSS");
				VBox prog=new VBox();
				prog.setPrefSize(670, 461);
				prog.setLayoutX(330);
				prog.setLayoutY(68);
				prog.getChildren().addAll(table3);
				
				Button valider=new Button("valider");
			    valider.setLayoutX(345);
			    valider.setLayoutY(551);
			    valider.setId("id");
				Label err=new Label("veuillez insérer des valeurs");
				err.setLayoutY(565);
				err.setLayoutX(670);
				err.setId("err");
				Label erreur=new Label("ce patient n'existe pas");
				erreur.setLayoutX(450);
				erreur.setLayoutY(551);
				erreur.setId("err");
				//surname
				
			    pro.getChildren().addAll(dbox,prog,date,name,noteph,noteps,notesoc,valider,lab);
                pro.getChildren().remove(err); 
				Scene pr=new Scene(pro,1000,600);
				primaryStage.setScene(pr);
				  
				
				
				valider.setOnAction(ex ->{
					
				
				
					try {
						 
						 try {							 
								Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
								String check="select count(*) as count,nom,Prenom from patient where id='"+Integer.parseInt(name.getText())+"';";
								ResultSet rescheck=conexion.createStatement().executeQuery(check);
								while(rescheck.next()) {
							id=rescheck.getInt("count");
							pat.setNom(rescheck.getString("nom"));
							pat.setPrénom(rescheck.getString("Prenom"));
							System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom());
								}
								
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					if(id!=0) {	try {
						pro.getChildren().remove(erreur);
						Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
						Statement state=conexion1.createStatement();
						String query1="insert into progres values('"+Integer.parseInt(name.getText())+"','"+date.getValue()+"','"+pat.getNom()+"','"
						+pat.getPrénom()+"','"+Integer.parseInt(noteph.getText())+"','"+Integer.parseInt(noteps.getText())+"','"+Integer.parseInt(notesoc.getText())+"');";
					state.executeUpdate(query1);
					} catch (SQLException e) {
					
						e.printStackTrace();
					}}
					else {
						
					
						
						pro.getChildren().add(erreur);
					
					}
					
				
					
			date.setValue(null);
					name.clear();        noteph.clear();    notesoc.clear();noteps.clear();
				//	surname.clear();         
				

					try {
						progr.clear();
						
						Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
						ResultSet result = conexion1.createStatement().executeQuery("select* from progres;");
						while(result.next()) {
							progr.add(new Progres(result.getInt("id_patient"),result.getDate("Date"),result.getString("Nom"),result.getNString("Prenom"),
									result.getInt("note_physiologie"),result.getInt("note_psychologie"),
									result.getInt("note_sociologie")));
							
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				
					
					table3.setItems(progr);
				
				
					}catch (NumberFormatException esd) {
					
						pro.getChildren().add(err);
					}
				});
					
				
				
				
				
				
				
				
              
			}
		});
	
		
		
		
//---------------------------------EVALUER PATIENT-----------------------------------------------
//----------------------------------------------------------------------------------------------//
		ObservableList<evaluation> ev=FXCollections.observableArrayList() ;
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet resul = conexion.createStatement().executeQuery("select* from evaluation;");
			while(resul.next()) {
				ev.add(new evaluation(resul.getInt("id_patient"),resul.getDate("Date"),resul.getString("nom"),resul.getString("prenom"),
						resul.getString("observation_physiologie"),resul.getString("observation_psychologie"),
						resul.getString("observation_sociologie")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table4.setItems(ev);
		
		
		
	evaluer.setOnAction(e34 ->{
		Label lab=new Label("tableau d'evaluation des patients");
		lab.setTextFill(cycleGrad3);
		lab.setFont(f1);
		lab.setUnderline(true);
		lab.setLayoutX(300);
		lab.setLayoutY(14);
        lab.setId("lab2");
		AnchorPane an=new AnchorPane();
		an.setId("pane");
		DatePicker year=new DatePicker();
		year.setLayoutX(500);
		year.setLayoutY(514);
		year.setPromptText("date");
		year.dayCellFactoryProperty().isNull();
		/*TextField t1=new TextField();
		t1.setPromptText("Nom");
		t1.setLayoutX(521);
		t1.setLayoutY(514);*/
	
		TextField t2=new TextField();
		t2.setPromptText("id_patient");
		t2.setLayoutX(677);
		t2.setLayoutY(514);
		TextField t3=new TextField();
		t3.setPromptText("observation phys");
		t3.setLayoutX(367);
		t3.setLayoutY(408);
		
		TextField t4=new TextField();
		t4.setPromptText("observation psy");
		t4.setLayoutX(559);
		t4.setLayoutY(408);
		
		TextField t5=new TextField();
		t5.setPromptText("observation soc");
		t5.setLayoutX(743);
		t5.setLayoutY(408);
		
		Button chercher=new Button("chercher");
		Button valider=new Button("valider");
        chercher.setLayoutX(861);
        chercher.setLayoutY(514);
        valider.setLayoutX(923);
        valider.setLayoutY(408);
       // table4.setLayoutX(135);
        //table4.setLayoutY(95);
       // table4.setPrefHeight(281);
        VBox table=new VBox();
        table.setPrefSize(683, 281);
        table.getChildren().add(table4);
        table.setLayoutX(317);
        table.setLayoutY(95);
        Label erreur=new Label("ce patient n'existe pas");
		erreur.setLayoutX(450);
		erreur.setLayoutY(551);
		erreur.setId("err");
		Label exe=new Label("veuillez insérer des valeurs");
		exe.setLayoutY(565);
		exe.setLayoutX(670);
		exe.setId("err");
		

   		ListView list=new ListView();
   		list.setLayoutX(0);
   		list.setLayoutY(95);
   		list.setPrefSize(317, 281);
   		//an.getChildren().remove(erreur);
   		list.setStyle("-fx-background-color: blue; -fx-text-fill: black;-fx-radius: 34;");
		
        valider.setOnAction(esd -> {
    		
	
	try {//an.getChildren().remove(exe);
		 
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	String check="select count(*) as count,nom,Prenom from patient where id='"+Integer.parseInt(t2.getText())+"';";
	ResultSet rescheck;
		rescheck = conexion.createStatement().executeQuery(check);
		while(rescheck.next()) {
			idd=rescheck.getInt("count");
			pat.setNom(rescheck.getString("nom"));
			pat.setPrénom(rescheck.getString("Prenom"));
			//System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom()+" "+t2.getText());
				}
	} catch (SQLException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}

 
	if(id!=0) {	try {
		//ici
		Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
		Statement state=conexion1.createStatement();
		String query="insert into evaluation values('"+Integer.parseInt(t2.getText())+"','"+year.getValue()+"','"+pat.getNom()+"','"
		+pat.getPrénom()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()  +"')";
       state.executeUpdate(query);
       conexion1.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}catch (NumberFormatException es) {
		
		an.getChildren().add(exe);
	}
	
	ev.clear();
	try {
		Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet resul = conexion1.createStatement().executeQuery("select* from evaluation;");
		while(resul.next()) {
			ev.add(new evaluation(resul.getInt("id_patient"),resul.getDate("Date"),resul.getString("nom"),resul.getString("prenom"),
					resul.getString("observation_physiologie"),resul.getString("observation_psychologie"),
					resul.getString("observation_sociologie")));
			
		}
		//here
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}catch (NumberFormatException es) {
		
		an.getChildren().add(exe);
	}
	
	
	
	table4.setItems(ev);}
        	
        
    			
    			
    	   
       });  
        
        
        
        chercher.setOnAction(eds ->{
        	
        	
        	try {an.getChildren().remove(exe);
        	an.getChildren().remove(erreur);
        		
        		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
        		String check="select count(*) as count,nom,Prenom from patient where id='"+Integer.parseInt(t2.getText())+"';";
        		ResultSet rescheck;
        			rescheck = conexion.createStatement().executeQuery(check);
        			while(rescheck.next()) {
        				id=rescheck.getInt("count");
        				pat.setNom(rescheck.getString("nom"));
        				pat.setPrénom(rescheck.getString("Prenom"));
        				System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom());
        					}
        		} catch (SQLException e3) {
        			// TODO Auto-generated catch block
        			e3.printStackTrace();
        		}catch (NumberFormatException es) {
           			
           			an.getChildren().add(exe);
           		}
           		
        	
        	   ObservableList<String> oz=FXCollections.observableArrayList();
           	Connection conexion;
           	if(id!=0) {	try {
       			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
       			Statement state=conexion.createStatement();
       			
       			String sal="select Nom,Prenom,AVG(note_physiologie) as avgp,AVG(note_psychologie) as avgs,AVG(note_sociologie) as avgc,extract(year from Date) as year from progres "
       					+ "where id_patient='"+t2.getText()+"' AND extract(year from Date)='"
       					+year.getValue().getYear()+"';";
       			ResultSet res=conexion.createStatement().executeQuery(sal);
       			while(res.next()) {
       				oz.add(new String("Nom: "+res.getString("Nom")+"\n"+"Prenom: "+res.getString("Prenom")+"\n"
       						           +"moyenne physique: "+Double.toString(res.getDouble("avgp"))+"\n"
       						           + "moyenne psychique: "+Double.toString(res.getDouble("avgs"))+"\n"
       						           + "moyenne sociologique: "+Double.toString(res.getDouble("avgc"))+"\n" 
       						            +"annee: "+res.getLong("year")              ));
       				
       			
       			}
       			
       		} catch (SQLException e1) {
       			
       			e1.printStackTrace();
       		}catch (NumberFormatException es) {
       			
       			an.getChildren().add(exe);
       		}
       		
       		
           	list.setItems(oz);      	  
       		an.getChildren().add(list);}
           	else {
           		erreur.setTranslateX(200);
           		an.getChildren().add(erreur);
           		an.getChildren().remove(list);
           	}
       	
        	
        });
        

     
	

		
	
	valider.setId("id");
	retour.setId("id");
	chercher.setId("id");
	an.getStylesheets().add("dboard.css"); 
	an.getChildren().addAll(t2,t3,t4,t5,year,chercher,valider,table,retour,lab);
	Scene eva=new Scene(an,1100,600);
	primaryStage.setScene(eva);
		
	});	
		
//--------------------personnel--------------------------//
	
	
	Button lp=new Button();
	lp.setGraphic(dossier2);
	Button ap=new Button();
	ap.setGraphic(blank);
	Button pp=new Button();
	pp.setGraphic(progres2);
	Button epe=new Button();
	epe.setGraphic(evaluation);
	Button sp =new Button();
	sp.setGraphic(surveiller);
	Button epe2=new Button();
	epe2.setGraphic(evaluation2);
	lp.setPrefSize(155, 132);
	ap.setPrefSize(155, 132);
	pp.setPrefSize(155, 132);
	epe.setPrefSize(155, 132);
	sp.setPrefSize(155, 132);
	epe2.setPrefSize(155, 132);
	lp.setLayoutX(334);
	lp.setLayoutY(168);
	lp.setId("button");
	ap.setLayoutX(572);
	ap.setLayoutY(168);
	ap.setId("button");
	pp.setLayoutX(815);
	pp.setLayoutY(168);
	pp.setId("button");
	epe.setLayoutX(334);
	epe.setLayoutY(424);
	epe.setId("button");
	sp.setLayoutX(581);
	sp.setLayoutY(424);
	sp.setId("button");
	epe2.setLayoutX(808);
	epe2.setLayoutY(424);
	epe2.setId("button");
	
	
	Button getBack=new Button("retour");
	getBack.setPrefSize(66, 31);
	getBack.setLayoutX(150);
	getBack.setLayoutY(539);
	getBack.setId("id");
	
	
	personnel.setOnAction(e ->{
		String dat;
	    LocalDateTime locdate=LocalDateTime.now();
		   DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("MMMM dd,YYYY");
		   dat=dtf2.format(date1);
		   Label labele=new Label();
		   labele.setText(date);
		   labele.setLayoutX(370);
		   labele.setLayoutY(24);
		   ImageView date22=new ImageView("file:date.png");
			date22.setFitHeight(25);
			date22.setFitWidth(25);
			date22.setLayoutX(340);
			date22.setLayoutY(25);
			labele.setId("nom");
		
		
		AnchorPane ep=new AnchorPane();
		ep.setId("pane");
		ep.getStylesheets().add("dboard.CSS");
		ep.getChildren().addAll(dbox,lp,ap,pp,epe,sp,epe2,labele,date22,labee3);
		Scene p=new Scene(ep,1000,600);
		primaryStage.setScene(p);
		getBack.setOnAction(e3 -> primaryStage.setScene(p));
		TranslateTransition tran1=new TranslateTransition(Duration.seconds(1), ap);
		
		tran1.setDelay(Duration.seconds(0));
		tran1.setToX(0);
		tran1.setFromX(-200);
		tran1.setCycleCount(1);
		tran1.play();
	TranslateTransition tran2=new TranslateTransition(Duration.seconds(1), pp);
		
		tran2.setDelay(Duration.seconds(0));
		tran2.setToX(0);
		tran2.setFromX(-400);
		tran2.setCycleCount(1);
		tran2.play();
	TranslateTransition tran3=new TranslateTransition(Duration.seconds(1), sp);
		
		tran3.setDelay(Duration.seconds(0));
		tran3.setToX(0);
		tran3.setFromX(-200);
		tran3.setCycleCount(1);
		tran3.play();
	TranslateTransition tran4=new TranslateTransition(Duration.seconds(1), epe2);
		
		tran4.setDelay(Duration.seconds(0));
		tran4.setToX(0);
		tran4.setFromX(-400);
		tran4.setCycleCount(1);
		tran4.play();
			
		
		
		
		
	});
	  
	
	
	HBox box = new HBox();
	box.setPrefSize(679, 432);
	box.setLayoutX(317);
	Button ok = new Button("ajouter");
	Button sup = new Button("suprimer");
	ok.setLayoutX(390);
	ok.setLayoutY(561);
	sup.setLayoutX(515);
	sup.setLayoutY(561);
	DatePicker p1 = new DatePicker();
	p1.setPromptText("date de naissance");
	p1.setLayoutX(341);
	p1.setLayoutY(454);
	TextField fi1 = new TextField();
	fi1.setPromptText("id");
	fi1.setLayoutX(524);
	fi1.setLayoutY(454);
	TextField fi2 = new TextField();
	fi2.setPromptText("nom d'utilisateur");
	fi2.setLayoutX(678);
	fi2.setLayoutY(454);
	TextField fi3 = new TextField();
	fi3.setPromptText("mot de passe");
	fi3.setLayoutX(837);
	fi3.setLayoutY(454);

	TextField fi4 = new TextField();
	fi4.setPromptText("nom");
	fi4.setLayoutX(367);
	fi4.setLayoutY(490);
	TextField fi5 = new TextField();
	fi5.setPromptText("prenom");
	fi5.setLayoutX(524);
	fi5.setLayoutY(490);
	TextField fi6 = new TextField();
	fi6.setPromptText("numsecScoiale");
	fi6.setLayoutX(678);
	fi6.setLayoutY(490);
	TextField fi7 = new TextField();
	fi7.setPromptText("adresse");
	fi7.setLayoutX(837);
	fi7.setLayoutY(490);
	TextField fi8 = new TextField();
	fi8.setPromptText("personneRef");
	fi8.setLayoutX(366);
	fi8.setLayoutY(525);
	TextField fi10 = new TextField();
	fi10.setPromptText("type_per");
	fi10.setLayoutX(524);
	fi10.setLayoutY(525);
	TextField fi9 = new TextField();
	fi9.setPromptText("secteurRattachement");
	fi9.setLayoutX(678);
	fi9.setLayoutY(525);
	Label erreur1 = new Label("nom d'utilisateur éxiste déjà !");
	erreur1.setLayoutX(620);
	erreur1.setLayoutY(561);
	erreur1.setId("err");
	Label erreur2 = new Label("numero existe déjà!");
	erreur2.setLayoutX(620);
	erreur2.setLayoutY(561);
	erreur2.setId("err");
	Label erreur3 = new Label("id existe déjà!");
	erreur3.setLayoutX(620);
	erreur3.setLayoutY(561);
	erreur3.setId("err");
	box.getChildren().add(table5);
	ok.setId("id");
	sup.setId("sup");

	ObservableList<Personnel> z=FXCollections.observableArrayList();
	
	
	lp.setOnAction(e4 -> {
		AnchorPane alp = new AnchorPane();
		alp.setId("pane");
		alp.getStylesheets().add("dboard.CSS");
	
		ok.setOnAction(e ->{
			//waa hna	
			
			Connection conexion = null;



	try {
				int i=0 ,j=0,k=0,l=0;
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count from personnel where id="+fi1.getText()+";";
				ResultSet rescheck=conexion.createStatement().executeQuery(check);
				while(rescheck.next()) {
					 i=rescheck.getInt("count");
				}

				String check2="select count(*) as count2 from personnel where num_sec_soc="+fi6.getText()+";";
				ResultSet rescheck2=conexion.createStatement().executeQuery(check2);
				while(rescheck2.next()) {
					 j=rescheck2.getInt("count2");
				}
				String check3="select count(*) as count3 from personnel where login='"+fi2.getText()+"';";
				ResultSet rescheck3=conexion.createStatement().executeQuery(check3);
				while(rescheck3.next()) {
					 k=rescheck3.getInt("count3");
				}
			
				if(i!=0) {
					alp.getChildren().remove(erreur1);
					alp.getChildren().remove(erreur2);
					alp.getChildren().remove(erreur3);
					alp.getChildren().add(erreur3);
					System.out.println(i);
					System.out.println("id occupé par un autre personnel");
					
					fi1.clear();
					i=0;
					
					
				}else if(j!=0) {
					alp.getChildren().remove(erreur1);
					alp.getChildren().remove(erreur3);
					
					alp.getChildren().remove(erreur2);
					alp.getChildren().add(erreur2);
					fi6.clear();
					j=0;
					
				    }
			else if(k!=0) {
				 alp.getChildren().remove(erreur2);
					alp.getChildren().remove(erreur3);
				alp.getChildren().remove(erreur1);
				alp.getChildren().add(erreur1);
				fi2.clear();
				k=0;
		         	}
			
			
				

			
			
			
			
			
			
			else {
				alp.getChildren().removeAll(erreur3,erreur1,erreur2);
			Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
			Statement state=conexion1.createStatement();
			String query="insert into personnel values('"+Integer.parseInt(fi1.getText())+"','" +fi2.getText()
			+"','" +fi3.getText()+"','" +fi4.getText()+"','"+fi5.getText()+"','" +p1.getValue()
			+"','" +Long.parseLong(fi6.getText())+"','" +fi7.getText()+"','" +fi8.getText()
			+"','" +fi9.getText()+"','" +fi10.getText()+"')";
	       state.executeUpdate(query);
	       conexion1.close();               
	       p1.setValue(null);fi2.clear();fi3.clear();fi4.clear();fi5.clear();fi6.clear();fi7.clear();fi8.clear();fi9.clear();fi10.clear();
	       fi1.clear();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	z.clear();
	try {
		Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet rs = conexion1.createStatement().executeQuery("select* from personnel;");
		while(rs.next()) {
			z.add(new Personnel(rs.getInt("id"),rs.getString("login"),rs.getString("login"),rs.getString("password"),
					rs.getString("nom"),rs.getString("prenom"),rs.getDate("date_de_naissance"),rs.getLong("num_sec_soc"),
					rs.getString("adresse"),rs.getString("personne_ref"),rs.getString("secteur_ratt"),rs.getString("type_personnel")));
			
		}
		table5.setItems(z);

	} catch (SQLException edf) {
		// TODO Auto-generated catch block
		edf.printStackTrace();
	}

		  			
			
			
	});
		
		
		
		sup.setOnAction(ex-> {
			
			ObservableList<Personnel> allPersonnel,personnelSelected;
			personnelSelected=FXCollections.observableArrayList();
			allPersonnel=table5.getItems();
			personnelSelected= table5.getSelectionModel().getSelectedItems();
			
			Connection conexion;
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
				Statement state=conexion.createStatement();
				
				for(int i=0;i<personnelSelected.size();i++) {
					String query="delete from personnel where id="+personnelSelected.get(i).getId()
							+";";
					state.executeUpdate(query);}
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			z.clear();
			try {
				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet rs = conexion1.createStatement().executeQuery("select* from personnel;");
				while(rs.next()) {
					z.add(new Personnel(rs.getInt("id"),rs.getString("login"),rs.getString("login"),rs.getString("password"),
							rs.getString("nom"),rs.getString("prenom"),rs.getDate("date_de_naissance"),rs.getLong("num_sec_soc"),
							rs.getString("adresse"),rs.getString("personne_ref"),rs.getString("secteur_ratt"),rs.getString("type_personnel")));
					
				}
				table5.setItems(z);

			} catch (SQLException edf) {
				// TODO Auto-generated catch block
				edf.printStackTrace();
			}
			
			
		});
		
		alp.getChildren().addAll(dbox,box,p1,fi1,fi2,fi3,fi4,fi5,fi6,fi7,fi8,fi9,fi10,ok,sup);
	 // alp.getChildren().removeAll(erreur1,erreur2,erreur3);
	  Scene per=new Scene(alp,1000,600);
	  primaryStage.setScene(per);

	
	
	
	});	

	try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet rs = conexion.createStatement().executeQuery("select* from personnel;");
		while(rs.next()) {
			z.add(new Personnel(rs.getInt("id"),rs.getString("login"),rs.getString("login"),rs.getString("password"),
					rs.getString("nom"),rs.getString("prenom"),rs.getDate("date_de_naissance"),rs.getLong("num_sec_soc"),
					rs.getString("adresse"),rs.getString("personne_ref"),rs.getString("secteur_ratt"),rs.getString("type_personnel")));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	table5.setItems(z);
	
	
	
	Button arrive=new Button("arriver");
	arrive.setLayoutX(571);
	arrive.setLayoutY(484);
	arrive.setId("id");
	Button quitter=new Button("quitter");
	quitter.setLayoutX(803);
	quitter.setLayoutY(484);
	quitter.setId("id");
	VBox sbox=new VBox();
	
	sbox.setLayoutX(318);
	sbox.setLayoutY(89);
	sbox.setPrefSize(681, 365);
	sbox.getChildren().add(table14);
	
	sp.setOnAction(e -> {
		AnchorPane surveiller1 =new AnchorPane();
		surveiller1.setId("pane");
		surveiller1.getStylesheets().add("dboard.CSS");
		surveiller1.getChildren().addAll(dbox,sbox,labee5);
	 
	  Scene sur=new Scene(surveiller1,1000,600);
	  primaryStage.setScene(sur);	
		
	});
	
		
	
	
	
  	  		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                                         //  AJOUTER PERSONNEL//
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	

		
	/*tourne.setOnAction(ex ->{
		
		
		
		
	});	*/
	
	VBox vb = new VBox();
	vb.setLayoutX(317);
	vb.setLayoutY(67);
	vb.setPrefSize(666, 347);
	DatePicker txt111 = new DatePicker();
	TextField txt11 = new TextField();
	TextField txt12 = new TextField();
	TextField txt13 = new TextField();
	TextField txt14 = new TextField();
	txt11.setLayoutX(558);
	txt11.setLayoutY(442);
	txt11.setPromptText("nom personnel");
	txt12.setLayoutX(725);
	txt12.setLayoutY(442);
	txt12.setPromptText("Prenom personnel");
	txt14.setLayoutX(558);
	txt14.setLayoutY(502);
	txt14.setPromptText("abscense");
	txt111.setLayoutX(341);
	txt111.setLayoutY(442);
	Button commit = new Button("valider");
	commit.setLayoutX(737);
	commit.setLayoutY(502);
	commit.setId("id");

	ObservableList<abscence> w = FXCollections.observableArrayList();
	try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		Statement state = conexion.createStatement();

		String sal = "select * from absence;";

		ResultSet res = conexion.createStatement().executeQuery(sal);
		while (res.next()) {
			w.add(new abscence(res.getString("nom"), res.getString("prenom"), res.getString("abscence"),
					res.getDate("date")));
		}

	} catch (SQLException g) {
		g.printStackTrace();

	}
	table6.setItems(w);

	commit.setOnAction(e -> {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state = conexion.createStatement();
			String query = "insert into absence values('" + txt11.getText() + "','" + txt12.getText() + "','"
					+ txt14.getText() + "','" + txt111.getValue() + "')";
			state.executeUpdate(query);
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txt11.clear();
		txt12.clear();
		txt14.clear();
		txt111.setValue(null);
		w.clear();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state = conexion.createStatement();

			String sal = "select * from absence;";

			ResultSet res = conexion.createStatement().executeQuery(sal);
			while (res.next()) {
				w.add(new abscence(res.getString("nom"), res.getString("prenom"), res.getString("abscence"),
						res.getDate("date")));
			}

		} catch (SQLException g) {
			g.printStackTrace();

		}
		table6.setItems(w);

	});

	vb.getChildren().add(table6);

	ap.setOnAction(e -> {
		AnchorPane chor = new AnchorPane();
		chor.setId("pane");
		Label lab=new Label("tableau des abscences");
		lab.setLayoutX(442);
		lab.setLayoutY(14);
        lab.setId("lab2");
		chor.getChildren().addAll(dbox, commit, vb, txt11, txt14, txt111, txt12,lab);
		chor.getStylesheets().add("dboard.CSS");
		Scene k = new Scene(chor, 1000, 600);
		primaryStage.setScene(k);

	});
	
	

	Button but1 = new Button("valider");
	but1.setLayoutX(657);
	but1.setLayoutY(548);
	TextField tp = new TextField();
	TextField tp2 = new TextField();
	TextField tp3 = new TextField();
	DatePicker jour = new DatePicker();
	tp.setPromptText("id du personne");
	tp.setLayoutX(508);
	tp.setLayoutY(443);
	tp2.setPromptText("nom du personnel");
	tp2.setLayoutX(674);
	tp2.setLayoutY(443);
	tp3.setPromptText("prenom personnel");
	tp3.setLayoutX(837);
	tp3.setLayoutY(443);
	TextField ma1=new TextField();
	TextField ma2=new TextField();
	TextField ma3=new TextField();
	ma1.setPromptText("note1");
	ma1.setLayoutX(508);
	ma1.setLayoutY(492);
	ma2.setPromptText("note2");
    ma2.setLayoutX(674);
	ma2.setLayoutY(492);
	ma3.setPromptText("note3");
	ma3.setLayoutX(837);
	ma3.setLayoutY(492);
	jour.setPromptText("prenom personnel");
	jour.setLayoutX(317);
	jour.setLayoutY(443);
	but1.setId("id");
	 Label mistake=new Label("ce personnel n'existe pas");
		mistake.setLayoutX(450);
		mistake.setLayoutY(551);
		mistake.setId("err");
		 Label mistake2=new Label("ce cadre infirmier n'existe pas");
			mistake2.setLayoutX(450);
			mistake2.setLayoutY(551);
			mistake2.setId("err");
		
	
	pp.setOnAction(e -> {
		AnchorPane	par= new AnchorPane();

		VBox p = new VBox();
		p.setPrefSize(670, 350);
		p.setLayoutX(330);
		p.setLayoutY(68);
		p.getChildren().add(table7);
		
		par.setId("pane");
		Label lab=new Label("Progres de travail du personnel");
		lab.setLayoutX(442);
		lab.setLayoutY(14);
	    lab.setId("lab2");
	
		par.getChildren().addAll(dbox, tp, jour, p,but1,ma1,ma2,ma3,lab);
par.getStylesheets().add("dboard.css");
		Scene sp4 = new Scene(par, 1000, 600);
		primaryStage.setScene(sp4);

	
	ObservableList<progrep> progr2 =FXCollections.observableArrayList();
	try {
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet result = conexion.createStatement().executeQuery("select* from progrep;");
		while(result.next()) {
			progr2.add(new progrep(result.getInt("id"),result.getString("nom"),result.getNString("prenom"),
					result.getInt("note1"),result.getInt("note2"),
					result.getInt("note3"),result.getDate("date")));
			
		}
		
	} catch (SQLException eee) {
		// TODO Auto-generated catch block
		eee.printStackTrace();
	}	

	
	table7.setItems(progr2);
	
	but1.setOnAction(ex ->{
		try {
			 try {							 
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
					String check="select count(*) as count,nom,prenom from personnel where id='"+Integer.parseInt(tp.getText())+"';";
					ResultSet rescheck=conexion.createStatement().executeQuery(check);
					while(rescheck.next()) {
				id=rescheck.getInt("count");
				per.setNom(rescheck.getString("nom"));
				per.setPrenom(rescheck.getString("prenom"));
				System.out.println(id+" "+per.getNom()+" "+per.getPrenom());
					}
					
			} catch (SQLException ee) {
				
				ee.printStackTrace();
			}
			
		//progres personnel
			
			
			 if(id!=0) {
		try {
			par.getChildren().remove(mistake);
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state=conexion.createStatement();
			String query1="insert into progrep values('"+Integer.parseInt(tp.getText())+"','"+per.getNom()+"','"
					+per.getPrenom()+"','"+Integer.parseInt(ma1.getText())+"','"+Integer.parseInt(ma2.getText())+"','"+Integer.parseInt(ma3.getText())+"','"+jour.getValue()+"');";
		state.executeUpdate(query1);
		} catch (SQLException ed) {
		
			ed.printStackTrace();
		}}else {
			par.getChildren().remove(mistake);
			par.getChildren().add(mistake);}
		
jour.setValue(null);
		tp.clear();        tp3.clear();    ma2.clear();
		tp2.clear();      ma1.clear();   ma3.clear();
	

		try {
			progr2.clear();
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet result = conexion.createStatement().executeQuery("select* from progrep;");
			while(result.next()) {
				progr2.add(new progrep(result.getInt("id"),result.getString("nom"),result.getNString("prenom"),
						result.getInt("note1"),result.getInt("note2"),
						result.getInt("note3"),result.getDate("date")));
				
			}
			
		} catch (SQLException e2) {
			
			e2.printStackTrace();
		}	
	
		
		table7.setItems(progr2);
	
	
		}catch (NumberFormatException esd) {
		
			//pro.getChildren().add(err);
		}
	});
	
	});
	
	
	
	
//----------------------------------evaluer personnel-------------------	
	//(id,nom,prenom,obsQualite,obsEffort,obsComportement,date)
	
	ObservableList<evaluationp> eg=FXCollections.observableArrayList() ;
	try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is NULL;");
		while(resul.next()) {
			eg.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
					resul.getString("obsQualite"),resul.getString("obsEffort"),
					resul.getString("obsComportement"),resul.getDate("date")));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	table8.setItems(eg);
	ObservableList<evaluationp> egg=FXCollections.observableArrayList() ;
	try {
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is not NULL;");
		while(resul.next()) {
			egg.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
					resul.getString("obsQualite"),resul.getString("obsEffort"),
					resul.getString("obsComportement"),resul.getDate("date")));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	table88.setItems(egg);
	
	
	
epe.setOnAction(e34 ->{
	
	  Parent root;
	  UserRole user;
	  user = new UserRole();
	  
        List<String> perm = user.getUserData();
        logger.info(perm.get(0));                                           ////here
        logger.info(perm.get(1));
        logger.debug("loggin ");
         if(perm.get(1).equals("responsableservice")) {
	
	AnchorPane an=new AnchorPane();
	an.getStylesheets().add("dboard.css");
	an.setId("pane");
	Label lab2=new Label("tableau d'evaluation du personnel");
	lab2.setId("lab2");
	lab2.setFont(f1);
	lab2.setUnderline(true);
	lab2.setLayoutX(300);
	lab2.setLayoutY(14);
	DatePicker year=new DatePicker();
	year.setLayoutX(500);
	year.setLayoutY(514);
	TextField t0=new TextField();
	t0.setPromptText("id");
	t0.setLayoutX(677);
	t0.setLayoutY(514);
	
	TextField t1=new TextField();
	t1.setPromptText("Nom");
	t1.setLayoutX(521);
	t1.setLayoutY(514);

	TextField t2=new TextField();
	t2.setPromptText("Prenom");
	t2.setLayoutX(677);
	t2.setLayoutY(514);
	TextField t3=new TextField();
	t3.setPromptText("observation Qlt");
	t3.setLayoutX(367);
	t3.setLayoutY(408);
	
	TextField t4=new TextField();
	t4.setPromptText("observation Efft");
	t4.setLayoutX(559);
	t4.setLayoutY(408);
	
	TextField t5=new TextField();
	t5.setPromptText("observation Comp");
	t5.setLayoutX(743);
	t5.setLayoutY(408);
	
	Button chercher=new Button("chercher");
	Button valider=new Button("valider");
	valider.setId("id");
	chercher.setId("id");
    chercher.setLayoutX(861);
    chercher.setLayoutY(514);
    valider.setLayoutX(923);
    valider.setLayoutY(408);
    table8.setLayoutX(135);
    table8.setLayoutY(95);
    table8.setPrefHeight(281);
    Label erreur=new Label("ce patient n'existe pas");
 		erreur.setLayoutX(450);
 		erreur.setLayoutY(551);
 		erreur.setId("err");
 		Label exe=new Label("veuillez insérer des valeurs");
 		exe.setLayoutY(565);
 		exe.setLayoutX(670);
 		exe.setId("err");
    an.setId("pane");
    an.getChildren().addAll(t3,t4,t5,year,chercher,valider,table8,getBack,t0,lab2);
	ListView list=new ListView();
		list.setLayoutX(0);
		list.setLayoutY(95);
		list.setPrefSize(133, 281);
    Scene eva=new Scene(an,1100,600);
    primaryStage.setScene(eva);
    valider.setOnAction(esd -> {
		
			
			try {//an.getChildren().remove(exe);
				 
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count,nom,prenom from personnel where id='"+Integer.parseInt(t0.getText())+"';";
				ResultSet rescheck;
					rescheck = conexion.createStatement().executeQuery(check);
					while(rescheck.next()) {
						idd=rescheck.getInt("count");
						per.setNom(rescheck.getString("nom")); 
						per.setPrenom(rescheck.getString("prenom"));
						//System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom()+" "+t2.getText());
							}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

			if(id!=0) {try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
			Statement state=conexion.createStatement();
			String query="insert into evaluationp(id,nom,prenom,obsQualite,obsEffort,obsComportement,date)  values('"+Integer.parseInt(t0.getText())+"','"+per.getNom()+"','"
			+per.getPrenom()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+year.getValue()+"')";
           state.executeUpdate(query);
           conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eg.clear();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is NULL;");
			while(resul.next()) {
				eg.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
						resul.getString("obsQualite"),resul.getString("obsEffort"),
						resul.getString("obsComportement"),resul.getDate("date")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table8.setItems(eg);}
			
			
	   
   });  
    
  //source
	
    chercher.setOnAction(eds ->{
    	
    	try {an.getChildren().remove(exe);
    	an.getChildren().remove(erreur);
    		
    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
    		String check="select count(*) as count,nom,prenom from personnel where id='"+Integer.parseInt(t0.getText())+"';";
    		ResultSet rescheck;
    			rescheck = conexion.createStatement().executeQuery(check);
    			while(rescheck.next()) {
    				id=rescheck.getInt("count");
    				per.setNom(rescheck.getString("nom"));
    				per.setPrenom(rescheck.getString("Prenom"));
    				System.out.println(id+" "+per.getNom()+" "+per.getPrenom());
    					}
    		} catch (SQLException e3) {
    			// TODO Auto-generated catch block
    			e3.printStackTrace();
    		}catch (NumberFormatException es) {
       			
       			an.getChildren().add(exe);
       		}
    	
    	
    	
    	
    	
    	   ObservableList<String> ol=FXCollections.observableArrayList();
       	Connection conexion;
   		if(id!=0) {
       	try {
   			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
   			Statement state=conexion.createStatement();
   			
   			String sal="select id, nom,prenom,AVG(note1) as avgp,AVG(note2) as avgs,AVG(note3) as avgc,extract(year from date) as year from progrep "
   					+ "where id="+t0.getText()+" AND extract(year from Date)='"
   					+year.getValue().getYear()+"';";
   			ResultSet res=conexion.createStatement().executeQuery(sal);
   			while(res.next()) {
   				ol.add(new String(
                                      "id: "+res.getInt("id")+"\n"   						
   						+"Nom: "+res.getString("nom")+"\n"+"Prenom: "+res.getString("prenom")+"\n"
   						           +"moyenne qualite service: "+Double.toString(res.getDouble("avgp"))+"\n"
   						           + "moyenne effort commis: "+Double.toString(res.getDouble("avgs"))+"\n"
   						           + "moyenne Comportement: "+Double.toString(res.getDouble("avgc"))+"\n" 
   						            +"annee: "+res.getLong("year")              ));
   				
   			
   			}
   			
   		} catch (SQLException e1) {
   			
   			e1.printStackTrace();
   		}
   		
   		
   	
   	
   		list.setItems(ol);
   		an.getChildren().add(list);}
   	 	else {
       		erreur.setTranslateX(200);
       		an.getChildren().add(erreur);
       		an.getChildren().remove(list);
       	}
    	
    });}else {
    	 logger.debug("probleme de droits");
      	  conge.setId("int");
      	 Alert interdit=new Alert(Alert.AlertType.WARNING);       //// here again
      	 interdit.setTitle("interdit");
      	 interdit.setHeaderText(null);
      	 interdit.setContentText("option preservé juste pour le responsable");
      	 interdit.showAndWait();
    	
    }
    

 


	

	

	
});	

ObservableList<evaluationp> g=FXCollections.observableArrayList() ;
try {
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is not NULL;");
	while(resul.next()) {
		g.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
				resul.getString("obsQualite"),resul.getString("obsEffort"),
				resul.getString("obsComportement"),resul.getDate("date")));
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
table88.setItems(g);
 


epe2.setOnAction(e-> {
	

		//ici
		AnchorPane an=new AnchorPane();
		an.getStylesheets().add("dboard.css");
		an.setId("pane");
		Label lab2=new Label("tableau d'evaluation du personnel");
		lab2.setId("lab2");
		lab2.setFont(f1);
		lab2.setUnderline(true);
		lab2.setLayoutX(300);
		lab2.setLayoutY(14);
		DatePicker year=new DatePicker();
		year.setLayoutX(500);
		year.setLayoutY(514);
		TextField t0=new TextField();
		t0.setPromptText("id");
		t0.setLayoutX(677);
		t0.setLayoutY(514);
		
		TextField t1=new TextField();
		t1.setPromptText("Nom");
		t1.setLayoutX(521);
		t1.setLayoutY(514);

		TextField t2=new TextField();
		t2.setPromptText("Prenom");
		t2.setLayoutX(677);
		t2.setLayoutY(514);
		TextField t3=new TextField();
		t3.setPromptText("observation Qlt");
		t3.setLayoutX(367);
		t3.setLayoutY(408);
		
		TextField t4=new TextField();
		t4.setPromptText("observation Efft");
		t4.setLayoutX(559);
		t4.setLayoutY(408);
		
		TextField t5=new TextField();
		t5.setPromptText("observation Comp");
		t5.setLayoutX(743);
		t5.setLayoutY(408);
		
		Button chercher=new Button("chercher");
		Button valider=new Button("valider");
		valider.setId("id");
		chercher.setId("id");
	    chercher.setLayoutX(861);
	    chercher.setLayoutY(514);
	    valider.setLayoutX(923);
	    valider.setLayoutY(408);
	    table88.setLayoutX(135);
	    table88.setLayoutY(95);
	    table88.setPrefHeight(281);
	    Label erreur=new Label("ce patient n'existe pas");
	 		erreur.setLayoutX(450);
	 		erreur.setLayoutY(551);
	 		erreur.setId("err");
	 		Label exe=new Label("veuillez insérer des valeurs");
	 		exe.setLayoutY(565);
	 		exe.setLayoutX(670);
	 		exe.setId("err");
	    an.setId("pane");
	    an.getChildren().addAll(t3,t4,t5,year,chercher,valider,table88,getBack,t0,lab2);
		ListView list=new ListView();
			list.setLayoutX(0);
			list.setLayoutY(95);
			list.setPrefSize(133, 281);
	    Scene eva=new Scene(an,1100,600);
	    primaryStage.setScene(eva);
	    valider.setOnAction(esd -> {
			
				
				try {//an.getChildren().remove(exe);
					 
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
					String check="select count(*) as count,nom,prenom from personnel where id='"+Integer.parseInt(t0.getText())+"';";
					ResultSet rescheck;
						rescheck = conexion.createStatement().executeQuery(check);
						while(rescheck.next()) {
							idd=rescheck.getInt("count");
							per.setNom(rescheck.getString("nom")); 
							per.setPrenom(rescheck.getString("prenom"));
							//System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom()+" "+t2.getText());
								}
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}

				if(id!=0) {try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
				Statement state=conexion.createStatement();
				String query="insert into evaluationp values('cadre','"+Integer.parseInt(t0.getText())+"','"+per.getNom()+"','"
				+per.getPrenom()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+year.getValue()+"')";
	           state.executeUpdate(query);
	           conexion.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			g.clear();
			/*ObservableList<evaluationp> g=FXCollections.observableArrayList() ;
try {
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is not NULL;");
	while(resul.next()) {
		g.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
				resul.getString("obsQualite"),resul.getString("obsEffort"),
				resul.getString("obsComportement"),resul.getDate("date")));
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
table88.setItems(g);*/
			
			
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet resul = conexion.createStatement().executeQuery("select id,nom,prenom,obsQualite,obsEffort,obsComportement,date from evaluationp where utilisateur is not NULL;");
				while(resul.next()) {
					g.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
							resul.getString("obsQualite"),resul.getString("obsEffort"),
							resul.getString("obsComportement"),resul.getDate("date")));
					
				}
				
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			table88.setItems(g);}
				
				
		   
	   });  
	    
	    
		
	    chercher.setOnAction(eds ->{
	    	
	    	try {an.getChildren().remove(exe);
	    	an.getChildren().remove(erreur);
	    		
	    		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	    		String check="select count(*) as count,nom,prenom from personnel where id='"+Integer.parseInt(t0.getText())+"';";
	    		ResultSet rescheck;
	    			rescheck = conexion.createStatement().executeQuery(check);
	    			while(rescheck.next()) {
	    				id=rescheck.getInt("count");
	    				per.setNom(rescheck.getString("nom"));
	    				per.setPrenom(rescheck.getString("Prenom"));
	    				System.out.println(id+" "+per.getNom()+" "+per.getPrenom());
	    					}
	    		} catch (SQLException e3) {
	    			// TODO Auto-generated catch block
	    			e3.printStackTrace();
	    		}catch (NumberFormatException es) {
	       			
	       			an.getChildren().add(exe);
	       		}
	    	
	    	
	    	
	    	
	    	
	    	   ObservableList<String> ol=FXCollections.observableArrayList();
	       	Connection conexion;
	   		if(id!=0) {
	       	try {
	   			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
	   			Statement state=conexion.createStatement();
	   			
	   			String sal="select id, nom,prenom,AVG(note1) as avgp,AVG(note2) as avgs,AVG(note3) as avgc,extract(year from date) as year from progrep "
	   					+ "where id="+t0.getText()+" AND extract(year from Date)='"
	   					+year.getValue().getYear()+"';";
	   			ResultSet res=conexion.createStatement().executeQuery(sal);
	   			while(res.next()) {
	   				ol.add(new String(
	                                      "id: "+res.getInt("id")+"\n"   						
	   						+"Nom: "+res.getString("nom")+"\n"+"Prenom: "+res.getString("prenom")+"\n"
	   						           +"moyenne qualite service: "+Double.toString(res.getDouble("avgp"))+"\n"
	   						           + "moyenne effort commis: "+Double.toString(res.getDouble("avgs"))+"\n"
	   						           + "moyenne Comportement: "+Double.toString(res.getDouble("avgc"))+"\n" 
	   						            +"annee: "+res.getLong("year")              ));
	   				
	   			
	   			}
	   			
	   		} catch (SQLException e1) {
	   			
	   			e1.printStackTrace();
	   		}
	   		
	   		
	   	
	   	
	   		list.setItems(ol);
	   		an.getChildren().add(list);}
	   	 	else {
	       		erreur.setTranslateX(200);
	       		an.getChildren().add(erreur);
	       		an.getChildren().remove(list);
	       	}
	    	
	    });
	    

	 


		

		

	

});







	

Button liste=new Button();
Button progrec=new Button();
Button evaluerc=new Button();

liste.setPrefSize(155, 132);
progrec.setPrefSize(155, 132);
evaluerc.setPrefSize(155, 132);

liste.setLayoutX(580);
liste.setLayoutY(184);
liste.setId("button");
liste.setGraphic(dossierc);
progrec.setLayoutX(365);
progrec.setLayoutY(424);
progrec.setId("button");
evaluerc.setLayoutX(808);
evaluerc.setLayoutY(424);
evaluerc.setId("button");

cadre.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event5) {
		String dat;
	    LocalDateTime locdate=LocalDateTime.now();
		   DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("MMMM dd,YYYY");
		   dat=dtf2.format(date1);
		   Label lebel=new Label();
		   lebel.setText(date);
		   lebel.setLayoutX(370);
		   lebel.setLayoutY(24);
		   ImageView date3=new ImageView("file:date.png");
			date3.setFitHeight(25);
			date3.setFitWidth(25);
			date3.setLayoutX(340);
			date3.setLayoutY(25);
			lebel.setId("nom");
		
	
		  Parent root;
		  UserRole user;
		  user = new UserRole();

	        List<String> perm = user.getUserData();
	        logger.info(perm.get(0));
	        logger.info(perm.get(1));
	        logger.debug("loggin ");
             if(perm.get(1).equals("responsableservice")) {
			
	           progrec.setGraphic(progresc);
	           
         		
 				TranslateTransition tran1=new TranslateTransition(Duration.seconds(1), progrec);
 				
 				tran1.setDelay(Duration.seconds(0));
 				tran1.setToX(0);
 				tran1.setToY(0);
 				tran1.setFromX(215);
 				tran1.setFromY(-240);
 				tran1.setCycleCount(1);
 				tran1.play();	 
                
 				evaluerc.setGraphic(evaluerc1);
 				
 				TranslateTransition tran2=new TranslateTransition(Duration.seconds(1), evaluerc);
 				
 				tran2.setDelay(Duration.seconds(0));
 				tran2.setToX(0);
 				tran2.setToY(0);
 				tran2.setFromX(-228);
 				tran2.setFromY(-240);
 				tran2.setCycleCount(1);
 				tran2.play();	 
            	 
            	 
			AnchorPane ch=new AnchorPane();
			ch.setId("pane");
			ch.getChildren().addAll(dbox,liste,progrec,evaluerc,lebel,date3,labee4);
			ch.getStylesheets().add("dboard.CSS");
			Scene s=new Scene(ch,1000,600);
			primaryStage.setScene(s);
			
			
			retour.setOnAction(ec ->{
				AnchorPane anc=new AnchorPane();
				anc.setId("pane");
				anc.getChildren().addAll(dbox,donne,parcourt,Progres,evaluer);
				anc.getStylesheets().add("dboard.CSS");
				Scene sn=new Scene(anc,1000,600);
				
				primaryStage.setScene(sn);
				});
			
             }else {
            	 logger.debug("probleme de droits");
              	  cadre.setId("int");
              	 Alert interdit=new Alert(Alert.AlertType.WARNING);
              	 interdit.setTitle("interdit");
              	 interdit.setHeaderText(null);
              	 interdit.setContentText("option preservé juste pour le responsable");
              	 interdit.showAndWait();
             }//youssef
             
	}
	
	
	
	
	});	 





HBox b = new HBox();
b.setPrefSize(679, 432);
b.setLayoutX(317);
Button add = new Button("ajouter");
Button del = new Button("suprimer");
add.setLayoutX(390);
add.setLayoutY(561);
del.setLayoutX(515);
del.setLayoutY(561);
DatePicker dp1 = new DatePicker();
dp1.setPromptText("date de naissance");
dp1.setLayoutX(341);
dp1.setLayoutY(454);
TextField area1 = new TextField();
area1.setPromptText("id");
area1.setLayoutX(524);
area1.setLayoutY(454);
TextField area2 = new TextField();
area2.setPromptText("nom d'utilisateur");
area2.setLayoutX(678);
area2.setLayoutY(454);
TextField area3 = new TextField();
area3.setPromptText("mot de passe");
area3.setLayoutX(837);
area3.setLayoutY(454);
TextField area4 = new TextField();
area4.setPromptText("nom");
area4.setLayoutX(367);
area4.setLayoutY(490);
TextField area5 = new TextField();
area5.setPromptText("prenom");
area5.setLayoutX(524);
area5.setLayoutY(490);
TextField area6 = new TextField();
area6.setPromptText("numsecScoiale");
area6.setLayoutX(678);
area6.setLayoutY(490);
TextField area7 = new TextField();
area7.setPromptText("adresse");
area7.setLayoutX(837);
area7.setLayoutY(490);
TextField area8 = new TextField();
area8.setPromptText("personneRef");
area8.setLayoutX(366);
area8.setLayoutY(525);

TextField area9 = new TextField();
area9.setPromptText("secteurRattachement");
area9.setLayoutX(678);
area9.setLayoutY(525);
b.getChildren().add(table9);
add.setId("id");
del.setId("sup");


ObservableList<CadreInfirmier> ow=FXCollections.observableArrayList();

liste.setOnAction(e4 -> {
	AnchorPane alp2 = new AnchorPane();
	add.setOnAction(e ->{
	Connection conexion;
	
	try {

	int i=0 ,j=0,k=0,l=0;
	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	String check="select count(*) as count from cadre where id="+area1.getText()+";";
	ResultSet rescheck=conexion.createStatement().executeQuery(check);
	while(rescheck.next()) {
		 i=rescheck.getInt("count");
	}//

	String check2="select count(*) as count2 from cadre where ncss="+area6.getText()+";";
	ResultSet rescheck2=conexion.createStatement().executeQuery(check2);
	while(rescheck2.next()) {
		 j=rescheck2.getInt("count2");
	}
	String check3="select count(*) as count3 from cadre where username='"+area2.getText()+"';";
	ResultSet rescheck3=conexion.createStatement().executeQuery(check3);
	while(rescheck3.next()) {
		 k=rescheck3.getInt("count3");
	}

	if(i!=0) {
		alp2.getChildren().remove(erreur1);
		alp2.getChildren().remove(erreur2);
		alp2.getChildren().remove(erreur3);
		alp2.getChildren().add(erreur3);
		System.out.println(i);
		System.out.println("id occupé par un autre personnel");
		
		area1.clear();
		i=0;
		
		
	}else if(j!=0) {
		alp2.getChildren().remove(erreur1);
		alp2.getChildren().remove(erreur3);
		
		alp2.getChildren().remove(erreur2);
		alp2.getChildren().add(erreur2);
		area6.clear();
		j=0;
		
	    }
else if(k!=0) {
				alp2.getChildren().remove(erreur2);
				alp2.getChildren().remove(erreur3);
				alp2.getChildren().remove(erreur1);
				alp2.getChildren().add(erreur1);
	area2.clear();
	k=0;
     	}
	
	
	
	
	
	
	
else {
				alp2.getChildren().remove(erreur2);
				alp2.getChildren().remove(erreur3);
				alp2.getChildren().remove(erreur1);
	Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
	Statement state=conexion1.createStatement();
	String query="insert into cadre values('"+Integer.parseInt(area1.getText())+"','" +area2.getText()
	+"','" +area3.getText()+"','" +area4.getText()+"','"+area5.getText()+"','" +dp1.getValue()
	+"','" +Long.parseLong(area6.getText())+"','" +area7.getText()+"','" +area8.getText()
	+"','" +area9.getText()+"')";
   state.executeUpdate(query);
   conexion1.close();
   dp1.setValue(null);area2.clear();area3.clear();area4.clear();area5.clear();area6.clear();area7.clear();area8.clear();area9.clear();
   area1.clear();   
}
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
ow.clear();
try {
	Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	ResultSet rs = conexion1.createStatement().executeQuery("select* from cadre;");
	while(rs.next()) {
		ow.add(new CadreInfirmier(rs.getInt("id"),rs.getString("username"),rs.getString("username"),rs.getString("password"),
				rs.getString("nom"),rs.getString("prenom"),rs.getDate("birthday"),rs.getLong("ncss"),
				rs.getString("adresse"),rs.getString("personne_ref"),rs.getString("secteur")));
		
	}
	
} catch (SQLException err) {
	// TODO Auto-generated catch block
	err.printStackTrace();
}
table9.setItems(ow);



  			
 ///hna tah ryal
	

	

});
	
	
	
	
	
	
	
	
	
	alp2.setId("pane");
	alp2.getStylesheets().add("dboard.CSS");
  alp2.getChildren().addAll(dbox,b,dp1,area1,area2,area3,area4,area5,area6,area7,area8,area9,add,del);
  Scene per=new Scene(alp2,1000,600);
  primaryStage.setScene(per);
});	

try {
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	ResultSet rs = conexion.createStatement().executeQuery("select* from cadre;");
	while(rs.next()) {
		ow.add(new CadreInfirmier(rs.getInt("id"),rs.getString("username"),rs.getString("username"),rs.getString("password"),
				rs.getString("nom"),rs.getString("prenom"),rs.getDate("birthday"),rs.getLong("ncss"),
				rs.getString("adresse"),rs.getString("personne_ref"),rs.getString("secteur")));
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
table9.setItems(ow);
	  		




	//-----------------------------------------------noter progres cadre----------------------------



Button butt1 = new Button("valider");
butt1.setLayoutX(657);
butt1.setLayoutY(548);
butt1.setId("id");
TextField tp1 = new TextField();
TextField tp21 = new TextField();
TextField tp31= new TextField();
DatePicker day = new DatePicker();
tp1.setPromptText("id du cadre");
tp1.setLayoutX(508);
tp1.setLayoutY(443);
tp21.setPromptText("nom du cadre");
tp21.setLayoutX(674);
tp21.setLayoutY(443);
tp31.setPromptText("prenom cadre");
tp31.setLayoutX(837);
tp31.setLayoutY(443);
TextField mar1=new TextField();
TextField mar2=new TextField();
TextField mar3=new TextField();
mar1.setPromptText("note Qualite");
mar1.setLayoutX(508);
mar1.setLayoutY(492);
mar2.setPromptText("note effort");
mar2.setLayoutX(674);
mar2.setLayoutY(492);
mar3.setPromptText("note Comportement");
mar3.setLayoutX(837);
mar3.setLayoutY(492);
day.setPromptText("date");
day.setLayoutX(317);
day.setLayoutY(443);

progrec.setOnAction(e -> {
	
	AnchorPane par2 = new AnchorPane();
	/*
		 try {							 
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count,nom,prenom from cadre where id='"+Integer.parseInt(tp1.getText())+"';";
				ResultSet rescheck=conexion.createStatement().executeQuery(check);
				while(rescheck.next()) {
			id=rescheck.getInt("count");
			cad.setNom(rescheck.getString("nom"));
			cad.setPrenom(rescheck.getString("prenom"));
			System.out.println(id+" "+cad.getNom()+" "+cad.getPrenom());
				}
				
		} catch (SQLException ee) {
			
			ee.printStackTrace();
		}
		

		
		
		 if(id!=0) {
	try {
		par2.getChildren().remove(mistake);
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		Statement state=conexion.createStatement();
		String query1="insert into progrec values('"+Integer.parseInt(tp1.getText())+"','"+cad.getNom()+"','"
				+cad.getPrenom()+"','"+Integer.parseInt(mar1.getText())+"','"+Integer.parseInt(mar2.getText())+"','"+Integer.parseInt(mar3.getText())+"','"+day.getValue()+"');";
	state.executeUpdate(query1);
	} catch (SQLException ed) {
	
		ed.printStackTrace();
	}}else {
		par2.getChildren().remove(mistake);
		par2.getChildren().add(mistake);}*/
	
	VBox cp = new VBox();
	cp.setLayoutX(317);
	cp.setLayoutY(67);
	cp.setPrefSize(679, 347);                          //progres du cadre
	cp.getChildren().add(table10);
	
	par2.setId("pane");
	Label lab3=new Label("Progres de travail du cadre infirmier");
	lab3.setLayoutX(430);
	lab3.setLayoutY(14);
    lab3.setId("lab2");
	par2.getChildren().addAll(dbox, tp1,day, cp,butt1,mar1,mar2,mar3,lab3);
par2.getStylesheets().add("dboard.css");
	Scene sp4 = new Scene(par2, 1000, 600);
	primaryStage.setScene(sp4);


ObservableList<progrep> progr3 =FXCollections.observableArrayList();
try {
	
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
	ResultSet result = conexion.createStatement().executeQuery("select* from progrec;");
	while(result.next()) {
		progr3.add(new progrep(result.getInt("id"),result.getString("nom"),result.getNString("prenom"),
				result.getInt("note1"),result.getInt("note2"),
				result.getInt("note3"),result.getDate("date")));
	                      }
	
	
	
     } catch (SQLException e3) {
 	      // TODO Auto-generated catch block
	        e3.printStackTrace();
}	


table10.setItems(progr3);

butt1.setOnAction(ex ->{
	try {
	
		 try {							 
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count,nom,prenom from cadre where id='"+Integer.parseInt(tp1.getText())+"';";
				ResultSet rescheck=conexion.createStatement().executeQuery(check);
				while(rescheck.next()) {
			id=rescheck.getInt("count");
			cad.setNom(rescheck.getString("nom"));
			cad.setPrenom(rescheck.getString("prenom"));
			System.out.println(id+" "+cad.getNom()+" "+cad.getPrenom());
				}
				
		} catch (SQLException ee) {
			
			ee.printStackTrace();
		}		 if(id!=0) {
			try {
				par2.getChildren().remove(mistake2);
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state=conexion.createStatement();
				String query1="insert into progrec values('"+Integer.parseInt(tp1.getText())+"','"+cad.getNom()+"','"
						+cad.getPrenom()+"','"+Integer.parseInt(mar1.getText())+"','"+Integer.parseInt(mar2.getText())+"','"+Integer.parseInt(mar3.getText())+"','"+day.getValue()+"');";
			state.executeUpdate(query1);
			} catch (SQLException ed) {
			
				ed.printStackTrace();
			}}else {
				
				par2.getChildren().remove(mistake2);
				par2.getChildren().add(mistake2);}
	
day.setValue(null);
	tp1.clear();        tp31.clear();    mar2.clear();
	tp21.clear();      mar1.clear();   mar3.clear();


	try {
		progr3.clear();
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet result = conexion.createStatement().executeQuery("select* from progrec;");
		while(result.next()) {
			progr3.add(new progrep(result.getInt("id"),result.getString("nom"),result.getNString("prenom"),
					result.getInt("note1"),result.getInt("note2"),
					result.getInt("note3"),result.getDate("date")));
			
		}
		
	} catch (SQLException e2) {
		
		e2.printStackTrace();
	}	

	
	table10.setItems(progr3);


	}catch (NumberFormatException esd) {
	
		//pro.getChildren().add(err);
	}
});
});
	
	tourne.setOnAction(e -> {
		  Parent root;
		  UserRole user;
		  user = new UserRole();
		  
	        List<String> perm = user.getUserData();
	        logger.info(perm.get(0));
	        logger.info(perm.get(1));
	        logger.debug("loggin ");
             if(perm.get(1).equals("responsableservice")) {
            	 
                 try {
         			Stage st=new Stage();
         			root = FXMLLoader.load(getClass().getResource("/map/mapView.fxml"));
         			Button helback=new Button("retour");
         		  st.setScene(new Scene(root, 1000, 600));
         		st.initModality(Modality.WINDOW_MODAL);
         		  st.initOwner(primaryStage);
                st.showAndWait();
                
         			  
         		} catch (IOException e1) {
         			// TODO Auto-generated catch block
         			e1.printStackTrace();
         		}
         		
             }		
             else {
            	  logger.debug("probleme de droits");
            	  tourne.setId("int");
            	 Alert interdit=new Alert(Alert.AlertType.WARNING);
            	 interdit.setTitle("interdit");
            	 interdit.setHeaderText(null);
            	 interdit.setContentText("option preservé juste pour le responsable");
            	 interdit.showAndWait();
            	
            	  
             }
	
	      
	});
	
	ObservableList rvs=FXCollections.observableArrayList();
	
rv.setOnAction(e-> {
		
	try {
		rvs.clear();
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
		ResultSet rs = conexion.createStatement().executeQuery("select* from rendez_vous ;");
		while(rs.next()) {
			rvs.add(new rdv(rs.getInt("id_patient"),rs.getString("nom_personnel"),rs.getDate("date_rdv"),
					rs.getTime("temps_rdv")));
			
		}
		
	} catch (SQLException ec) {
		// TODO Auto-generated catch block
		ec.printStackTrace();
	}
	table12.setItems(rvs);
	
	VBox vbx=new VBox();
 vbx.setLayoutX(324);
 vbx.setLayoutY(78);
 vbx.setPrefSize(675, 387);
 vbx.getChildren().add(table12);
 DatePicker pic=new DatePicker();
 pic.setPromptText("date rendezvous");;
 pic.setLayoutX(324);
 pic.setLayoutY(488);
 TextField idp=new TextField();
 idp.setPromptText("id patient");
 idp.setLayoutX(676);
  idp.setLayoutY(488);
 TextField np=new TextField();
 np.setPromptText("nom_personnel");
np.setLayoutX(837);
 np.setLayoutY(488);
 Label blab=new Label("gestion des rendez-vous");
		blab.setTextFill(cycleGrad3);
		blab.setFont(f1);
		blab.setUnderline(true);
		blab.setLayoutX(400);
		blab.setLayoutY(14);
		blab.setId("lab2");
 TextField tr=new TextField();
 tr.setPromptText("temps_rdv");
 tr.setLayoutX(513);
 tr.setLayoutY(488);
 Button val=new Button("valider");
 val.setLayoutX(624);
 val.setLayoutY(531);
 val.setId("id");
 AnchorPane rdvs=new AnchorPane();
 rdvs.setId("pane");
 rdvs.getChildren().addAll(dbox,vbx,pic,tr,idp,np,val,blab);
 rdvs.getStylesheets().add("dboard.css");
 
 Scene rdvx=new Scene(rdvs,1000,600);
 primaryStage.setScene(rdvx);
 val.setOnAction(ee -> {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state=conexion.createStatement();
			String query1="insert into rendez_vous values('"+Integer.parseInt(idp.getText())+"','"+np.getText()+"','"
					+pic.getValue()+"','"+Time.valueOf(tr.getText())+"');";
		state.executeUpdate(query1);
		} catch (SQLException eads) {
		
			eads.printStackTrace();
		}
		
idp.clear();tr.clear();np.clear();pic.setValue(null);  
	

		try {
			rvs.clear();
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet result = conexion.createStatement().executeQuery("select* from rendez_vous;");
			while(result.next()) {
				rvs.add(new rdv(result.getInt("id_patient"),result.getString("nom_personnel"),result.getDate("date_rdv"),
						result.getTime("temps_rdv")));
				
			}
			
		} catch (SQLException eef) {
			// TODO Auto-generated catch block
			eef.printStackTrace();
		}
		table12.setItems(rvs);
	 
 });
 
 
	
});


evaluerc.setOnAction(e -> {
	
		
		AnchorPane an=new AnchorPane();
		an.setId("pane");
		Button k=new Button("retour");
		k.setPrefSize(66, 31);
		k.setLayoutX(150);
		k.setLayoutY(539);
		
		Label lab4=new Label("tableau d'evaluation des cadres infirmiers");//tableau 1
		lab4.setTextFill(Color.PINK);
		lab4.setFont(f1);
		lab4.setUnderline(true);
		lab4.setLayoutX(300);
		lab4.setLayoutY(14);
		DatePicker year=new DatePicker();
		year.setLayoutX(500);
		year.setLayoutY(514);
		TextField t0=new TextField();
		t0.setPromptText("id");
		t0.setLayoutX(677);
		t0.setLayoutY(514);
		
		TextField t1=new TextField();
		t1.setPromptText("Nom");
		t1.setLayoutX(521);
		t1.setLayoutY(514);

		TextField t2=new TextField();
		t2.setPromptText("Prenom");
		t2.setLayoutX(677);
		t2.setLayoutY(514);
		TextField t3=new TextField();
		t3.setPromptText("observation Qlt");
		t3.setLayoutX(367);
		t3.setLayoutY(408);
		
		TextField t4=new TextField();
		t4.setPromptText("observation Efft");
		t4.setLayoutX(559);
		t4.setLayoutY(408);
		
		TextField t5=new TextField();
		t5.setPromptText("observation Comp");
		t5.setLayoutX(743);
		t5.setLayoutY(408);
		
		Button chercher=new Button("chercher");
		Button valider=new Button("valider");
		
	    chercher.setLayoutX(861);
	    chercher.setLayoutY(514);
	    valider.setLayoutX(923);
	    valider.setLayoutY(408);
	    tablec.setLayoutX(135);
	    tablec.setLayoutY(95);                            
	    tablec.setPrefHeight(281);
	   
	    valider.setOnAction(esd -> {
	    	
	    	
	    	
	    	try {//an.getChildren().remove(exe);
				 
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				String check="select count(*) as count,nom,prenom from cadre where id='"+Integer.parseInt(t0.getText())+"';";
				ResultSet rescheck;
					rescheck = conexion.createStatement().executeQuery(check);
					while(rescheck.next()) {
						idd=rescheck.getInt("count");
						cad.setNom(rescheck.getString("nom")); 
						cad.setPrenom(rescheck.getString("prenom"));
						//System.out.println(id+" "+pat.getNom()+" "+pat.getPrénom()+" "+t2.getText());
							}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
			if(id!=0){
			
				
				try {
			
				
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
				Statement state=conexion.createStatement();
				String query="insert into evaluationc values('"+Integer.parseInt(t0.getText())+"','"+cad.getNom()+"','"
				+cad.getPrenom()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+year.getValue()+"')";
	           state.executeUpdate(query);
	           conexion.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			eg.clear();
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet resul = conexion.createStatement().executeQuery("select* from evaluationc;");
				while(resul.next()) {
					eg.add(new evaluationp(resul.getInt("id"),resul.getString("nom"),resul.getString("prenom"),
							resul.getString("obsQualite"),resul.getString("obsEffort"),
							resul.getString("obsComportement"),resul.getDate("date")));
					
				}
				
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			tablec.setItems(eg);}
				
	    });
		   
	
	    
	    //target
		
	    chercher.setOnAction(eds ->{
	    	//an.getChildren().remove(exe);
	    	//an.getChildren().remove(erreur);
	    	   ObservableList<String> ol=FXCollections.observableArrayList();
	       	Connection conexion;
	   		try {
	   			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad","essiad","1234");
	   			Statement state=conexion.createStatement();
	   			
	   			String sal="select id, nom,prenom,AVG(note1) as avgp,AVG(note2) as avgs,AVG(note3) as avgc,extract(year from date) as year from progrec "
	   					+ "where id="+t0.getText()+" AND extract(year from Date)='"
	   					+year.getValue().getYear()+"';";
	   			ResultSet res=conexion.createStatement().executeQuery(sal);
	   			while(res.next()) {
	   				ol.add(new String(
	                                      "id: "+res.getInt("id")+"\n"   						
	   						+"Nom: "+res.getString("nom")+"\n"+"Prenom: "+res.getString("prenom")+"\n"
	   						           +"moyenne qualite service: "+Double.toString(res.getDouble("avgp"))+"\n"
	   						           + "moyenne effort commis: "+Double.toString(res.getDouble("avgs"))+"\n"
	   						           + "moyenne Comportement: "+Double.toString(res.getDouble("avgc"))+"\n" 
	   						            +"annee: "+res.getLong("year")              ));
	   				
	   			
	   			}
	   			
	   		} catch (SQLException e1) {
	   			
	   			e1.printStackTrace();
	   		}
	   
	   		
	   	
	   		ListView list=new ListView();
	   		list.setLayoutX(0);
	   		list.setLayoutY(95);
	   		list.setPrefSize(133, 281);
	   		list.setItems(ol);
	   		an.getChildren().add(list); });
	    	
	    k.setOnAction(exs -> {
	    	AnchorPane r=new AnchorPane();
	    	r.setId("pane");
	    	r.getChildren().addAll(dbox,liste,progrec,evaluerc);
			r.getStylesheets().add("dboard.CSS");
			Scene s=new Scene(r,1000,600);
			primaryStage.setScene(s);
	    });
	    
	    chercher.setId("id");
	    valider.setId("id");
	    k.setId("id");
	    an.getChildren().addAll(t3,t4,t5,year,chercher,valider,tablec,k,t0,lab4);
	    an.getStylesheets().add("dboard.css");
	    an.setId("pane");
	    Scene eva=new Scene(an,1100,600);
	    primaryStage.setScene(eva);
	    
});;
	
	
	

//------------------------------DASHBOARD PERSONNEL----------------------------------//
//-----------------------------------------------------------------------------------------//
	
	AnchorPane perso=new AnchorPane();
	perso.setId("pane");
	
	
	VBox dbox2 = new VBox();
	dbox2.setPrefSize(317, 1000);
	Pane pane2 = new Pane();
	pane2.setPrefSize(269, 132);
	

	
	pane2.getChildren().addAll(logo2, nom2);

	Button sais = new Button("Saisir observation");
	Button cons = new Button("Consulter tournée");
	Button red = new Button("Rediger rapport");
	Button dem = new Button("Demander Congé");
	Button lo = new Button("Se déconnecter");
	Button csd=new Button("poursuivre demande");
	Button notif=new Button("Notifier");
	ImageView ico0 = new ImageView("file:prsv.png");
	ico0.setFitWidth(28);
	ico0.setFitHeight(28);
	csd.setGraphic(ico0);
	ImageView ico1 = new ImageView("file:obs.png");
	ico1.setFitWidth(28);
	ico1.setFitHeight(28);
	sais.setGraphic(ico1);
	ImageView ico2 = new ImageView("file:tour.png");
	ico2.setFitWidth(25);
	ico2.setFitHeight(25);
	cons.setGraphic(ico2);
	ImageView ico3 = new ImageView("file:rapp.png");
	ico3.setFitWidth(25);
	ico3.setFitHeight(25);
	red.setGraphic(ico3);
	ImageView ico4 = new ImageView("file:conge.png");
	ico4.setFitWidth(25);
	ico4.setFitHeight(25);
	dem.setGraphic(ico4);
	ImageView ico5 = new ImageView("file:lo.png");
	ico5.setFitWidth(25);
	ico5.setFitHeight(25);
	lo.setGraphic(ico5);
	ImageView imgx = new ImageView("file:infirmier.jpg");
	imgx.setLayoutX(316);
	imgx.setLayoutY(0);
	imgx.setFitWidth(685);
	imgx.setFitHeight(606);

	dbox2.setMargin(lo, new Insets(200, 0, 0, 0));
    
	dbox2.getChildren().addAll(pane2, sais,notif ,cons, red, dem,csd, lo);
	Label wel = new Label("Let US SPREAD some HOPE");
	wel.setId("wel");
	wel.setLayoutX(330);
	wel.setLayoutY(24);
	perso.setPrefSize(700, 700);

	dbox2.setId("dbox");
	perso.getStylesheets().add("dboard.CSS");
	Circle circle = new Circle();
	circle.setRadius(100);
	Line line = new Line();
	line.setLayoutX(290);
	line.setLayoutY(58);
	line.setStartX(-589);
	line.setStartY(-8.000015258789062);
	line.setEndX(600);
	line.setEndY(-8.000015258789062);
	PathTransition transition = new PathTransition();
	transition.setNode(wel);
	transition.setDuration(Duration.seconds(10));
	transition.setPath(line);
	transition.setCycleCount(PathTransition.INDEFINITE);
	transition.play();
	perso.getChildren().addAll(dbox2, imgx, wel);
	Scene pesro = new Scene(perso, 1000, 600);
	
	sais.setOnAction(e-> {
		AnchorPane road=new AnchorPane();
		road.setId("pane");
		TextField txt=new TextField();
		txt.setLayoutX(382);
		txt.setLayoutY(218);
		txt.setPromptText("id patient");
		TextField tx=new TextField();
		tx.setLayoutX(382);
		tx.setLayoutY(250);
		tx.setPromptText("id personnel");
		DatePicker tx2=new DatePicker();
		tx2.setLayoutX(382);
		tx2.setLayoutY(290);
		tx2.setPromptText("date");
		TextArea text=new TextArea();
		text.setLayoutX(584);
		text.setLayoutY(218);
		text.setPrefSize(200, 200);
		text.setPromptText("  observation");
		Button vald=new Button("valider");
        vald.setLayoutX(635);
        vald.setLayoutY(420);
        vald.setId("id");
		road.getStylesheets().add("dboard.css");
		road.getChildren().addAll(dbox2,txt,tx,tx2,text,vald);
		Scene pesroc = new Scene(road, 1000, 600);
		primaryStage.setScene(pesroc);
		vald.setOnAction(e1-> {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state=conexion.createStatement();
				String query1="insert into observation values ('"+Integer.parseInt(txt.getText())+"','"
				+Integer.parseInt(tx.getText())+"','"+tx2.getValue()+"','"+text.getText()+"');";
			state.executeUpdate(query1);
			} catch (SQLException ere) {
			
				ere.printStackTrace();
			}
			txt.clear();text.clear();tx.clear();tx2.setValue(null);
		});
		
	});
	
	dem.setOnAction(e-> {
		AnchorPane cong=new AnchorPane();
		cong.setId("pane");
		TextField idp=new TextField();
		idp.setPromptText("id du personnel");
		idp.setLayoutX(381);
		idp.setLayoutY(245);
		DatePicker debut=new DatePicker();
	debut.setPromptText("date debut");
		debut.setLayoutX(595);
		debut.setLayoutY(245);
		DatePicker fin=new DatePicker();
		fin.setPromptText("date de fin");
		fin.setLayoutX(799);
		fin.setLayoutY(245);
		ChoiceBox choice1=new ChoiceBox();
		choice1.getItems().addAll("congé sabbatique","conge maternel","CIF","conge paternité");
		choice1.setLayoutX(589);
		choice1.setLayoutY(341);
		Label typ=new Label("type du congé: ");
		typ.setLayoutX(487);
		typ.setLayoutY(345);
		typ.setUnderline(true);
		Button env=new Button("envoyer");
		env.setLayoutX(620);
		env.setLayoutY(409);
		env.setId("id");
		cong.getChildren().addAll(dbox2,idp,debut,fin,choice1,typ,env);
		cong.getStylesheets().add("dboard.css");
		Scene con=new Scene(cong,1000,600);
		primaryStage.setScene(con);
		 
		env.setOnAction(ec-> {
			try {
				String tr="encours de traitement...";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state=conexion.createStatement();
				String query1="insert into  conge values('"+Integer.parseInt(idp.getText())+"','"+choice1.getValue()+"','"+
				debut.getValue()+"','"+fin.getValue()+"','"+tr+"');";
		state.executeUpdate(query1);
			} catch (SQLException ere) {
			
				ere.printStackTrace();
			}
			idholder=idp.getText();
			idp.clear();choice1.setValue(null);debut.setValue(null);fin.setValue(null);
		});
		
		
	});
	
	csd.setOnAction(e-> {
		ObservableList congee=FXCollections.observableArrayList();	
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet rs = conexion.createStatement().executeQuery("select* from conge where idPersonnel=(select id from personnel where login='"+userpe+"')"+";");
			while(rs.next()) {
				congee.add(new Conge(rs.getInt("idPersonnel"),rs.getString("typeConge"),rs.getDate("debutConge"),
						rs.getDate("finConge"),rs.getString("reponse")));
				
			}
			
		} catch (SQLException ec) {
			// TODO Auto-generated catch block
			ec.printStackTrace();
		}
		table11.setItems(congee);
		AnchorPane a=new AnchorPane();
		a.setId("pane");
		VBox cbox=new VBox();
		cbox.setLayoutX(317);
		cbox.setLayoutY(49);
		cbox.setPrefSize(681, 435);
		cbox.getChildren().add(table11);
		a.getChildren().addAll(dbox2,cbox);
		a.getStylesheets().add("dboard.css");
		Scene ab=new Scene(a,1000,600);
		primaryStage.setScene(ab);
		
	});
	
	red.setOnAction(e-> {
		AnchorPane redi=new AnchorPane();
	
		TextField id_p=new TextField();
		id_p.setLayoutX(335);
		id_p.setLayoutY(71);
		id_p.setPromptText("id personnel");
		TextField id_pat=new TextField();
		id_pat.setLayoutX(500);
		id_pat.setLayoutY(71);
		id_pat.setPromptText("id patient");
		TextArea xtx= new TextArea();
		xtx.setLayoutX(335);
		xtx.setLayoutY(93);
		xtx.setPrefSize(663, 454);
		xtx.setPromptText("votre rapport");
		Button conf=new Button("envoyer");
		conf.setLayoutX(588);
		conf.setLayoutY(561);
		conf.setId("id");
		redi.getChildren().addAll(dbox2,id_p,id_pat,xtx,conf);
		dbox2.setStyle("-fx-background-color:  #3F2B63;");
		redi.getStylesheets().add("dboard.css");
		redi.setId("pane");
		Scene sn=new Scene(redi,1000,600);
		primaryStage.setScene(sn);
		
		conf.setOnAction(e2-> {
			try {
			Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state=conexion1.createStatement();
			String query1="insert into rapport values('"+Integer.parseInt(id_pat.getText())+"','"+Integer.parseInt(id_p.getText())
			+"','"+xtx.getText()+"');";
		state.executeUpdate(query1);
		} catch (SQLException ex) {
		
			ex.printStackTrace();
		}
			xtx.clear();id_p.clear();id_pat.clear();
				
		});
		
		
	});
	
	
	
	cons.setOnAction(e-> {
		
		  Stage stage = new Stage();
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/personnel/map/mappersonnel.fxml"));
	        stage.setTitle("Localisation de Patient");
	        try {
				stage.setScene(new Scene(loader.load(), 1000, 600));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        stage.initModality(Modality.WINDOW_MODAL);
	        Scene s = cons.getScene();
	        stage.initOwner(s.getWindow());
	        stage.show();
	}

			);
	
	Button arrive1=new Button("arriver");
	arrive1.setLayoutX(571);
	arrive1.setLayoutY(484);
	arrive1.setId("id");
	Button quitter1=new Button("quitter");
	quitter1.setLayoutX(803);
	quitter1.setLayoutY(484);
	quitter1.setId("id");
	VBox sbox1=new VBox();
	sbox1.setLayoutX(318);
	sbox1.setLayoutY(89);
	sbox1.setPrefSize(681, 365);
	sbox1.getChildren().add(table14);
	
	
	ObservableList<Surveillance> sur=FXCollections.observableArrayList();
	notif.setOnAction(e ->{
		
		sur.clear();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			Statement state = conexion.createStatement();

			String sal = "select * from surveillance;";

			ResultSet res = conexion.createStatement().executeQuery(sal);
			while (res.next()) {
				sur.add(new Surveillance(res.getInt("id_personnel"), res.getString("adresse_patient"), res.getDate("date")
			,res.getString("arrive"),res.getTime("heure_arrive"),res.getString("quitter"),res.getTime("heure_quitter")));
			}

		} catch (SQLException ge) {
			ge.printStackTrace();

		}
		table14.setItems(sur);
		 arrive1.setOnAction(e2->{
			 
			    LocalDateTime date2=LocalDateTime.now();
				   DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("h:mm a");
				String   datex=dtf2.format(date2);
			 System.out.println(datex);
				ObservableList<Surveillance> allitems, itemSelected;
				itemSelected = FXCollections.observableArrayList();
				allitems = table14.getItems();
				itemSelected = table14.getSelectionModel().getSelectedItems();
			 String arr="je suis arrivé";
			 Connection conexion = null;
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
					Statement state = conexion.createStatement();

					for (int i = 0; i < itemSelected.size(); i++) {
						String query = "insert into surveillance(arrive,heure_arrive) values ('"+arr+"','"+dtf2.format(date2)+"') where id_personnel=(select id from personnel where login='"+userpe+"')"+";";
							
						state.executeUpdate(query);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					sur.clear();
					String sal = "select * from surveillance;";

					ResultSet res = conexion.createStatement().executeQuery(sal);
					while (res.next()) {
						sur.add(new Surveillance(res.getInt("id_patient"), res.getString("adresse_personnel"), res.getDate("date"),
					res.getString("arrive"),res.getTime("heure_arrive"),res.getString("quitter"),res.getTime("heure_quitter")));
					}

					

				} catch (SQLException ec) {
					// TODO Auto-generated catch block
					ec.printStackTrace();
				}
				table14.setItems(sur);
			 
			 
		 });	
		 
		 
		 
		quitter1.setOnAction(e3 ->{
			
		    LocalDateTime date2=LocalDateTime.now();
			   DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("h:mm a");
			   //date=dtf2.format(date2);
		 
			ObservableList<Surveillance> allitems, itemSelected;
			itemSelected = FXCollections.observableArrayList();
			allitems = table14.getItems();
			itemSelected = table14.getSelectionModel().getSelectedItems();
		 
		 Connection conexion = null;
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state = conexion.createStatement();

				for (int i = 0; i < itemSelected.size(); i++) {
					String query = "update surveillance set quitter='jai quitté',heure_quitter='"+dtf2.format(date2)+"' where adresse_patient='" 
							+ itemSelected.get(i).getAdresse_patient() + ";";
					state.executeUpdate(query);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				sur.clear();
				String sal = "select * from surveillance;";

				ResultSet res = conexion.createStatement().executeQuery(sal);
				while (res.next()) {
					sur.add(new Surveillance(res.getInt("id_personnel"), res.getString("adresse_patient"), res.getDate("date"),
					res.getString("arrive"),res.getTime("heure_arrive"),res.getString("quitter"),res.getTime("heure_quitter")));
				}

				

			} catch (SQLException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}
			table14.setItems(sur);
			
			
			
			
			
		});
		
		

		AnchorPane surveiller1 = new AnchorPane();
		surveiller1.setId("pane");
		surveiller1.getStylesheets().add("dboard.CSS");
		surveiller1.getChildren().addAll(dbox2, sbox1, labee5, arrive1, quitter1);
		Scene sure = new Scene(surveiller1, 1000, 600);
		primaryStage.setScene(sure);
		
	});
	
	
	
	
	
	
	lo.setOnAction(e-> {
		LDAPauthentication auth=new LDAPauthentication();
		auth.closeauthent();
		logger.info("you are successfuly disconnected");
		perso.getChildren().removeAll(dbox2, imgx, wel);
		perso.getChildren().addAll(dbox2, imgx, wel);
		
		txtx.clear();
		pwdx.clear();
		primaryStage.setScene(scene);
	});
	
	
	//--------------------------gestion du conge par le respo---------------//
	ObservableList<Conge> li=FXCollections.observableArrayList();
	
	
	conge.setOnAction(e->{
		  Parent root;
		  UserRole user;
		  user = new UserRole();
		  
	        List<String> perm = user.getUserData();
	        logger.info(perm.get(0));                                        
	        logger.info(perm.get(1));
	        logger.debug("loggin ");
             if(perm.get(1).equals("responsableservice")) {
		
		try {
			li.clear();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet rs = conexion.createStatement().executeQuery("select* from conge ;");
			while(rs.next()) {
				li.add(new Conge(rs.getInt("idPersonnel"),rs.getString("typeConge"),rs.getDate("debutConge"),
						rs.getDate("finConge"),rs.getString("reponse")));
				
				
			}
			
		} catch (SQLException ec) {
			// TODO Auto-generated catch block
			ec.printStackTrace();
		}
		table11.setItems(li);
		AnchorPane rp=new AnchorPane();
		rp.setId("pane");
		Button acc=new Button("accepter");
		Button refus=new Button("refuser");
		acc.setLayoutX(449);
		acc.setLayoutY(508);
		refus.setLayoutX(689);
		refus.setLayoutY(508);
		acc.setId("id");
		refus.setId("id");
		
		Label alab=new Label("gestion des congés");
		alab.setTextFill(cycleGrad3);
		alab.setFont(f1);
		alab.setUnderline(true);
		alab.setLayoutX(450);
		alab.setLayoutY(14);
        alab.setId("lab2");
        
	VBox bb=new VBox();
	bb.setLayoutX(317);
	bb.setLayoutY(70);
	bb.setPrefSize(681, 397);
	bb.getChildren().add(table11);
	rp.getChildren().addAll(dbox,bb,refus,acc,alab);
	rp.getStylesheets().add("dboard.css");
	Scene cscene=new Scene(rp,1000,600);
	primaryStage.setScene(cscene);
	
	
		acc.setOnAction(ee -> {

			ObservableList<Conge> allitems, itemSelected;
			itemSelected = FXCollections.observableArrayList();
			allitems = table11.getItems();
			itemSelected = table11.getSelectionModel().getSelectedItems();
//select
			Connection conexion;
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state = conexion.createStatement();

				for (int i = 0; i < itemSelected.size(); i++) {
					String query = "update conge set reponse=" + "'" + "demande acceptée" + "'where idPersonnel="
							+ itemSelected.get(i).getIdPersonnel() + ";";
					state.executeUpdate(query);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				li.clear();
				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet rs = conexion1.createStatement().executeQuery("select* from conge ;");
				while (rs.next()) {
					li.add(new Conge(rs.getInt("idPersonnel"), rs.getString("typeConge"), rs.getDate("debutConge"),
							rs.getDate("finConge"), rs.getString("reponse")));

				}

			} catch (SQLException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}
			table11.setItems(li);
		});
		
		
		
	refus.setOnAction(ee -> {

			ObservableList<Conge> allitems, itemSelected;
			itemSelected = FXCollections.observableArrayList();
			allitems = table11.getItems();
			itemSelected = table11.getSelectionModel().getSelectedItems();

			Connection conexion;
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state = conexion.createStatement();

				for (int i = 0; i < itemSelected.size(); i++) {
					String query = "update conge set reponse=" + "'" + "demande refusée" + "'where idPersonnel="
							+ itemSelected.get(i).getIdPersonnel() + ";";
					state.executeUpdate(query);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				li.clear();
				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				ResultSet rs = conexion1.createStatement().executeQuery("select* from conge ;");
				while (rs.next()) {
					li.add(new Conge(rs.getInt("idPersonnel"), rs.getString("typeConge"), rs.getDate("debutConge"),
							rs.getDate("finConge"), rs.getString("reponse")));

				}

			} catch (SQLException ec) {
				// TODO Auto-generated catch block
				ec.printStackTrace();
			}
			table11.setItems(li);
		});
             }
             
             else {
            	 
            	 logger.debug("probleme de droits");
           	  conge.setId("int");
           	 Alert interdit=new Alert(Alert.AlertType.WARNING);       //// here again
           	 interdit.setTitle("interdit");
           	 interdit.setHeaderText(null);
           	 interdit.setContentText("option preservé juste pour le responsable");
           	 interdit.showAndWait();
             }
             
		
	});
	
//-------------------------------dash board du patient----------------------------------------//
	AnchorPane pat=new AnchorPane();
	pat.setId("pane");
	Pane ppp=new Pane();
	ppp.setId("ppp");
	
	ppp.setPrefSize(269, 132);
	ppp.getChildren().addAll(logo3,nom3);
	
	VBox patb=new VBox();
	patb.setPrefSize(322, 600);
	patb.setId("dbox");
	ImageView ip=new ImageView("file:addnew.png");
	ip.setFitWidth(25);
	ip.setFitHeight(25);
	Button ajt=new Button("ajouter acteur");
	ImageView ptt=new ImageView("file:pat.jpg");
	ptt.setFitWidth(700);
	ptt.setFitHeight(594);
	ptt.setLayoutX(310);;
	ajt.setGraphic(ico3);
	ajt.setGraphic(ip);
	Button rdv=new Button("consulter rendez-vous");
	ImageView ip2=new ImageView("file:calen.png");
	ip2.setFitWidth(25);
	ip2.setFitHeight(25);
	rdv.setGraphic(ico3);
	Button logout=new Button("Se déconnecter");
	logout.setGraphic(ico5);
	patb.setMargin(logout,new Insets(200, 0, 0, 0) );

	patb.getChildren().addAll(ppp,ajt,rdv,logout);
	pat.getStylesheets().add("dboard.css");
	pat.getChildren().addAll(patb,ptt);
	Scene pats =new Scene(pat,1000,600);

	btn1.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event1) {
			LDAPauthentication auth = new LDAPauthentication();
			auth.authent(txt1.getText(), pwd1.getText(),"patients");
			
			if ((auth.authent(txt1.getText(), pwd1.getText(), "patients") == 1) ){
				userpa=txt1.getText();
				System.out.println(user_pat);
				primaryStage.setScene(pats);
				primaryStage.show();
				logger.info("loggin was a success");
				g1.getChildren().remove(error);
			} else {
				g1.getChildren().remove(error);
				g1.getChildren().add(error);
				System.out.println("user not found");
				logger.debug("smtg wrong login failed");;
			}

		}
	});
	
	logout.setOnAction(e->{
		LDAPauthentication auth = new LDAPauthentication();
		 auth.closeauthent() ;
			
		pat.getChildren().removeAll(patb,ptt);	
		 pat.getChildren().addAll(patb,ptt);
	txt1.clear();
	pwd1.clear();
		primaryStage.setScene(scene);
	
		
	
	
		
	});
	
	btnz.setOnAction(e-> primaryStage.setScene(scene1));
	btnx.setOnAction(ez-> {
		
			LDAPauthentication auth = new LDAPauthentication();
			auth.authent(txtx.getText(), pwdx.getText(),"personnel");
			
			if ((auth.authent(txtx.getText(), pwdx.getText(), "personnel") == 1) ){
				userpe=txtx.getText();
				primaryStage.setScene(pesro);
				
				logger.info("loggin was a success");
			} else {
				g1.getChildren().add(error);
				System.out.println("utilisateur untrouvable !");
				logger.debug("smtg wrong login failed");;
			}

		
		
	});	
		
	ajt.setOnAction(e-> {
		AnchorPane temp=new AnchorPane();
		temp.setId("pane");
		
	});
	 Button rj=new Button("retour");
     rj.setLayoutX(385);
     rj.setLayoutY(531);
     rj.setId("id");
     rj.setOnAction(ee ->{ 
    	 AnchorPane backbut=new AnchorPane();
    	 backbut.setId("pane");
    	 backbut.getStylesheets().add("dboard.css");
    	 backbut.getChildren().add(patb);
    	 Scene sr=new Scene(backbut,1000,600);
    	 primaryStage.setScene(sr);
    	 });
	rdv.setOnAction(e -> {
		try {
			rvs.clear();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet rs = conexion.createStatement().executeQuery("select* from rendez_vous ;");
			while(rs.next()) {
				rvs.add(new rdv(rs.getInt("id_patient"),rs.getString("nom_personnel"),rs.getDate("date_rdv"),
						rs.getTime("temps_rdv")));
				
			}
			
		} catch (SQLException ec) {
			// TODO Auto-generated catch block
			ec.printStackTrace();
		}
		table12.setItems(rvs);
     AnchorPane patr=new AnchorPane();
     patr.setId("pane");
     VBox bbox=new VBox();
     
     bbox.setLayoutX(324);
     bbox.setLayoutY(78);
     bbox.setPrefSize(675, 387);
     bbox.getChildren().add(table12);
  
     patr.getChildren().addAll(patb,bbox,rj);
     patr.getStylesheets().add("dboard.css"); 
     
   patr.setId("dbox");
     Scene cn=new Scene(patr,1000,600);
     primaryStage.setScene(cn);
	});
	ajt.setOnAction(e-> {
		AnchorPane anch=new AnchorPane();
		anch.setId("pane");
		anch.getStylesheets().add("dboard.css");
		TextField nom_acteur=new TextField();
		nom_acteur.setPromptText("nom d'acteur");
		nom_acteur.setLayoutX(574);
		nom_acteur.setLayoutY(131);
		TextField fon_acteur=new TextField();
		fon_acteur.setPromptText("fonctionnalite d'acteur");
		fon_acteur.setLayoutX(805);
		fon_acteur.setLayoutY(238);
		TextField adr_acteur=new TextField();
		adr_acteur.setPromptText("adresse d'acteur");
		adr_acteur.setLayoutX(574);
		adr_acteur.setLayoutY(348);
		TextField tel_acteur=new TextField();
		tel_acteur.setPromptText("tel d'acteur");
		tel_acteur.setLayoutX(341);
		tel_acteur.setLayoutY(238);
		Button valid=new Button("ajouter");
		valid.setLayoutX(624);
		valid.setLayoutY(238);
		valid.setId("id");
		anch.getChildren().addAll(patb,nom_acteur,fon_acteur,adr_acteur,tel_acteur,valid,rj);
		Scene act=new Scene(anch,1000,600);
		primaryStage.setScene(act);
		
		valid.setOnAction(exc ->{
			try {
				System.out.println(user_pat);
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
				Statement state=conexion.createStatement();
				String query1="update  patient set nom_acteur='"+nom_acteur.getText()+"', fonctionalite_acteur='"+fon_acteur.getText()+"',adresse_acteur='"+adr_acteur.getText()+"',tel_acteur="+Integer.parseInt(tel_acteur.getText())+
						" where "+"username='"+user_pat+"' "+";"
			;
			state.executeUpdate(query1);
			} catch (SQLException ere) {
			
				ere.printStackTrace();
			}
			
		});
		
		
	});
	
	ObservableList<observation> obser=FXCollections.observableArrayList();
	
	obs.setOnAction(e2 -> {
		obser.clear();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/essiad", "essiad", "1234");
			ResultSet res = conexion.createStatement().executeQuery("select* from observation;");
			while (res.next()) {
				obser.add(new observation(res.getInt("id_patient"),res.getInt("id_personnel"),res.getDate("date"),res.getString("observation")));
				
				
				}
			conexion.close();	
			
			}
		
		 catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		table13.setItems(obser);
		
		AnchorPane os=new AnchorPane();
		os.setId("pane");
		VBox oxbox=new VBox();
		oxbox.setPrefSize(670, 461);
		oxbox.setLayoutX(330);
		oxbox.setLayoutY(68);
		oxbox.getChildren().add(table13);
		os.getChildren().addAll(dbox,oxbox);
		os.clearConstraints(dbox);
		os.getStylesheets().add("dboard.css");
		Scene obsc=new Scene(os,1000,600);
		primaryStage.setScene(obsc);
		
		
	});
		
	
	dscene.getAntiAliasing();	
	//hna ta7 rial	
	primaryStage.setScene(scene);
	//primaryStage.setWidth(1000);
	//primaryStage.setHeight(600);
	primaryStage.setResizable(true);
	//dbox.layoutXProperty().bind(dbox.layoutXProperty());
	primaryStage.show();
		
	}	
	

	public static void main(String[] args) {
		launch(args);
	}
}
