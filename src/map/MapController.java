package map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Classes.tourne;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import netscape.javascript.JSObject;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import session.UserRole;


public class MapController implements Initializable {
    private static final String API_KEY = "0e196c7cb4a45fa10cfb8ae7b47eb127";
    public static String GOOGLE_MAP_URL = null;
    public static String API_POSITION_TRACK_URL= "http://api.positionstack.com";
    String lat = "33.589886", lon = "-7.603869";
    ///Rabat
    String rlat = "33.953913", rlan = "-6.873546";
    //Settat

    
    @FXML
    private TextField infirmier;

    @FXML
    private DatePicker datetourne;
    @FXML
    private ProgressBar progress;
    @FXML
    TextField patient_address;

    @FXML
    WebView webView;

    WebEngine webEngine;

    @FXML
    private Spinner<Object> map_type;
    @FXML
    Button changeMap ;
    @FXML
    Label error;
    @FXML
    Button exitBtn;
    @FXML
    Button patient_btn;
    UserRole user ;
    /**
     * for communication to the Javascript engine.
     */
    private JSObject javascriptConnector;
    private JSObject javascriptConnectorSetting;

    /**
     * for communication from the Javascript engine.
     */
    private JavaConnector javaConnector ;
    JavaConnector javaConnectorSetting;
/////////////////////////////////////// setup logger
    Logger logger = null;
    public void initialize(URL location, ResourceBundle resources) {
        //init Logger
        logger = Logger.getLogger(MapController.class);

//////////////////##SESSION #PREFERENCES/////////////////////////////////////////////////////////////
        user = new UserRole();
        List<String> perm = user.getUserData();
        logger.info(perm.get(0));
        logger.info(perm.get(1));
///////////////////////////////////////////////////////////////////////////////////////////////////

        error.setVisible(false);
        error.setText("");
        //configure spinner
        java.util.List<Object> mapTypesID = new ArrayList<Object>();
        mapTypesID.add("roadmap");
        mapTypesID.add("satellite");
        mapTypesID.add("terrain");
        mapTypesID.add("hybrid");
        map_type.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<Object>(FXCollections.observableArrayList(mapTypesID)));

       // SpinnerValueFactory<String> mapTypeId = SpinnerValueFactory.ListSpinnerValueFactory;
        //init html file of map
        progress.setVisible(false);
        GOOGLE_MAP_URL = getClass().getResource("mapV2.html").toExternalForm();

        webEngine = webView.getEngine();

        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    javaConnector = new JavaConnector("hell o from java");
                    // set an interface object named 'javaConnector' in the web engine's page
                    JSObject window = (JSObject) webEngine.executeScript("window");
                    window.setMember("javaConnector", javaConnector);

                    // get the Javascript connector object.
                    javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");

                }
            }
        });
        // add markers

        webEngine.setJavaScriptEnabled(true);
        webEngine.load(GOOGLE_MAP_URL);
    }

    public void settingMapAction(){
        String map_type_id = map_type.getValue().toString();
        logger.info("change the map type");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                logger.debug("the map type is <"+map_type_id+">");
                 javaConnectorSetting = new JavaConnector();
                 javaConnectorSetting.setMaptype(map_type_id);
                // set an interface object named 'javaConnector' in the web engine's page
                JSObject window = (JSObject) webEngine.executeScript("window");
                window.setMember("javaConnectors", javaConnectorSetting);
                // get the Javascript connector object.
                javascriptConnectorSetting = (JSObject) webEngine.executeScript("getJsSetting()");
                webEngine.executeScript("sendToJavas();");

            }
        });
    }



    public void AddPatientAction() {
        ////add process to progress bar

        //init retrofit
        logger.debug("ajouter patient");
        //Maroc Securite, 73 Bd De Paris, Casablanca
        //Boulevard d'Anfa, Casablanca 20250

        String addr = patient_address.getText();

        if (addr.equals("")){
            logger.error("the address field is empty");
            error.setText("Address field is empty");
            error.setVisible(true);
            patient_address.setText("");
        }else {
            error.setVisible(false);
            progress.setVisible(true);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_POSITION_TRACK_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            progress.setProgress(6);
            GetConverterAddrToLatLng inter_api = retrofit.create(GetConverterAddrToLatLng.class);
            progress.setProgress(12);
            Call<DataAddr> call = inter_api.getConverterLatLong(addr, 1);
            logger.info("fetch data from <"+API_POSITION_TRACK_URL+">");
            call.enqueue(new Callback<DataAddr>() {
                @Override
                public void onResponse(Call<DataAddr> call, Response<DataAddr> response) {
                    int code_ = response.code();
                    if (response.code()==200){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                DataAddr data = response.body();
                                progress.setProgress(46);
                                String Lat = data.getData()[0].getLatitude();
                                String Lang = data.getData()[0].getLongitude();
                                String label = data.getData()[0].getLabel();
                                logger.info("API RESULT <"+data.getData()[0].toString()+">");
                                //// calll database fontion to store info
                                long date  = System.currentTimeMillis(); ////64646477383387// date jt/mois/annne idd
                                ///storePatientAddress(Lat,Long,date ,idInf);
                                // login -< cookies
                                    javaConnector = new JavaConnector(Lat, Lang, label);
                                    // set an interface object named 'javaConnector' in the web engine's page
                                    progress.setProgress(76);
                                    JSObject window = (JSObject) webEngine.executeScript("window");
                                    window.setMember("javaConnector", javaConnector);

                                    // get the Javascript connector object.
                                    javascriptConnectorSetting = (JSObject) webEngine.executeScript("getJsConnector()");
                                    webEngine.executeScript("sendToJava();");
                                    progress.setProgress(100);
                            }
                        });
                        progress.setVisible(false);

                    }else{

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                PauseTransition p = new PauseTransition(Duration.seconds(5));
                                p.setOnFinished(event -> error.setVisible(false));
                                //pass
                                progress.setVisible(false);
                                error.setText("");
                                error.setText("address not valid! Please try other one");
                                error.setVisible(true);
                                logger.error("INVALID ADDRESS");
                                p.play();
                            }
                        });
                    }
                
                ObservableList<tourne> reg=FXCollections.observableArrayList();
            	try {
    				
    				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad","root","123");
    				Statement state=conexion.createStatement();
    				String query="insert into tourne values('"+Integer.parseInt(infirmier.getText())+"','"+patient_address.getText()+"','"+
    				datetourne.getValue()		+"')";
    	           state.executeUpdate(query);
    	           conexion.close();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
 	try {
    				
    				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad","root","123");
    				Statement state=conexion.createStatement();
    				String query="insert into surveillance(id_personnel,adresse_patient,date) values('"+Integer.parseInt(infirmier.getText())+"','"+patient_address.getText()+"','"+
    				datetourne.getValue()		+"')";
    	           state.executeUpdate(query);
    	           conexion.close();
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            	
            	
                 
                
                }
                
                

                @Override
                public void onFailure(Call<DataAddr> call, Throwable throwable) {

                }

            });


        }

    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    public class JavaConnector {
        public String address ;
        public String lat_,lan_;
        public String maptype ;

        public String getMaptype() {
            return maptype;
        }

        public void setMaptype(String maptype) {
            this.maptype = maptype;
        }

        public JavaConnector(){}
        public JavaConnector(String address){
            this.address =address;
        }
        public JavaConnector(String lt,String ln,String addr){
            this.lat_ = lt;
            this.lan_ = ln;
            this.address= addr;
        }

        public void SendPatientAddress(){
            javascriptConnector.call("addPatientLoaction",address);
        }

        public void SendPatientLatLng(){
            javascriptConnector.call("addPatientLatLng",lat_,lan_,address);
        }

        public void settingMap(){
            javascriptConnectorSetting.call("settingMapJs",maptype);
        }

    }


    public interface GetConverterAddrToLatLng{
        @GET("v1/forward?access_key=0e196c7cb4a45fa10cfb8ae7b47eb127")
        Call<DataAddr> getConverterLatLong(@Query("query") String query, @Query("limit") Integer number);
    }
    class  DataAddr{

        public Data[] data;

        public Data[] getData ()
        {
            return data;
        }

        public void setData (Data[] data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return " [data = "+data+"]";
        }
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////

    class test {

        public ArrayList<String> _address_list  ;
        public int i ;

        public void getAllAdressFromDatabase(){
            //// store all adrress in address_list
        }

        public void AddAllPatients() {
            //init retrofit

            //Maroc Securite, 73 Bd De Paris, Casablanca
            //Boulevard d'Anfa, Casablanca 20250
            for (i = 0;i<_address_list.size();i++){}

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_POSITION_TRACK_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            MapController.GetConverterAddrToLatLng inter_api = retrofit.create(MapController.GetConverterAddrToLatLng.class);
            Call<MapController.DataAddr> call = inter_api.getConverterLatLong( _address_list.get(i),1);
            call.enqueue(new Callback<MapController.DataAddr>() {
                @Override
                public void onResponse(Call<DataAddr> call, Response<DataAddr> response) {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            MapController.DataAddr data = response.body();
                            String Lat = data.getData()[0].getLatitude();
                            String Lang = data.getData()[0].getLongitude();
                            javaConnector = new MapController.JavaConnector(Lat,Lang,"hell");
                            // set an interface object named 'javaConnector' in the web engine's page
                            JSObject window = (JSObject) webEngine.executeScript("window");
                            window.setMember("javaConnector", javaConnector);

                            // get the Javascript connector object.
                            javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
                            webEngine.executeScript("sendToJava();");

                        }
                    });
                    progress.setVisible(false);
                }

                @Override
                public void onFailure(Call<DataAddr> call, Throwable throwable) {

                }


            });





        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////


}

class Data
{
    public String continent;

    public String country;

    public String latitude;

    public String confidence;

    public String county;

    public String locality;

    public String administrative_area;

    public String label;

    public String type;

    public String number;

    public String country_code;

    public String street;

    public String neighbourhood;

    public String name;

    public String postal_code;

    public String region;

    public String longitude;

    public String region_code;

    public String getContinent ()
    {
        return continent;
    }

    public void setContinent (String continent)
    {
        this.continent = continent;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getConfidence ()
    {
        return confidence;
    }

    public void setConfidence (String confidence)
    {
        this.confidence = confidence;
    }

    public String getCounty ()
    {
        return county;
    }

    public void setCounty (String county)
    {
        this.county = county;
    }

    public String getLocality ()
    {
        return locality;
    }

    public void setLocality (String locality)
    {
        this.locality = locality;
    }

    public String getAdministrative_area ()
{
    return administrative_area;
}

    public void setAdministrative_area (String administrative_area)
    {
        this.administrative_area = administrative_area;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getNumber ()
{
    return number;
}

    public void setNumber (String number)
    {
        this.number = number;
    }

    public String getCountry_code ()
    {
        return country_code;
    }

    public void setCountry_code (String country_code)
    {
        this.country_code = country_code;
    }

    public String getStreet ()
{
    return street;
}

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getNeighbourhood ()
{
    return neighbourhood;
}

    public void setNeighbourhood (String neighbourhood)
    {
        this.neighbourhood = neighbourhood;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPostal_code ()
{
    return postal_code;
}

    public void setPostal_code (String postal_code)
    {
        this.postal_code = postal_code;
    }

    public String getRegion ()
    {
        return region;
    }

    public void setRegion (String region)
    {
        this.region = region;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getRegion_code ()
    {
        return region_code;
    }

    public void setRegion_code (String region_code)
    {
        this.region_code = region_code;
    }

    @Override
    public String toString()
    {
        return "[continent = "+continent+", country = "+country+", latitude = "+latitude+", confidence = "+confidence+", county = "+county+", locality = "+locality+", administrative_area = "+administrative_area+", label = "+label+", type = "+type+", number = "+number+", country_code = "+country_code+", street = "+street+", neighbourhood = "+neighbourhood+", name = "+name+", postal_code = "+postal_code+", region = "+region+", longitude = "+longitude+", region_code = "+region_code+"]";
    }
}

