package personnel.map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Classes.Conge;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import org.apache.log4j.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import map.MapController;
import session.UserRole;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MapPersonnelController implements Initializable {
	public String pos;
    private static final String API_KEY = "0e196c7cb4a45fa10cfb8ae7b47eb127";
    public static String GOOGLE_MAP_URL = null;
    public static String API_POSITION_TRACK_URL= "http://api.positionstack.com";
    String lat = "33.589886", lon = "-7.603869";
    ///Rabat
    String rlat = "33.953913", rlan = "-6.873546";
    //Settat 
    

   
    @FXML
    WebView webView;

    WebEngine webEngine;

  
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
        //////here
    	 List<Patient> lepatients = new ArrayList<>(); 
    	ObservableList tourne=FXCollections.observableArrayList();	
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/essiad", "root", "123");
			ResultSet rs = conexion.createStatement().executeQuery("select* from tourne;");
			while(rs.next()) {
				lepatients.add(new Patient(rs.getInt("id_personnel"),rs.getString("adresse_patient"),rs.getDate("date")));
				pos=rs.getString("adresse_patient");
			}}catch(SQLException e) {
				e.printStackTrace();
			}

		       
       


        //init Logger
        logger = Logger.getLogger(MapController.class);

//////////////////##SESSION #PREFERENCES/////////////////////////////////////////////////////////////
        user = new UserRole();
        List<String> perm = user.getUserData();
        logger.info(perm.get(0));
        logger.info(perm.get(1));
///////////////////////////////////////////////////////////////////////////////////////////////////
        GOOGLE_MAP_URL = getClass().getResource("map.html").toExternalForm();

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

        addAllPatientByInferimereAndDay(lepatients);
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(GOOGLE_MAP_URL);
    }

    public void addAllPatientByInferimereAndDay(List<Patient> lesPatients){

        for (Patient patient: lesPatients){

                //init retrofit

                //Maroc Securite, 73 Bd De Paris, Casablanca
                //Boulevard d'Anfa, Casablanca 20250

                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_POSITION_TRACK_URL)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                MapPersonnelController.GetConverterAddrToLatLng inter_api = retrofit.create(MapPersonnelController.GetConverterAddrToLatLng.class);
                Call<MapPersonnelController.DataAddr> call = inter_api.getConverterLatLong( patient.getAddrese(),1);
                call.enqueue(new Callback<DataAddr>() {
                    @Override
                    public void onResponse(Call<DataAddr> call, Response<DataAddr> response) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                MapPersonnelController.DataAddr data = response.body();
                                String Lat = data.getData()[0].getLatitude();
                                String Lang = data.getData()[0].getLongitude();
                                  // methode 1 pour declencher map                              
                                 javaConnector = new MapPersonnelController.JavaConnector(Lat,Lang,pos);
                                // set an interface object named 'javaConnector' in the web engine's page
                                JSObject window = (JSObject) webEngine.executeScript("window");
                                window.setMember("javaConnector", javaConnector);

                                // get the Javascript connector object.
                                javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
                               webEngine.executeScript("sendToJava();");
                                //methode2
                                /* webEngine.executeScript(
                                        "var latt="+Lat+";" +
                                                "var langg="+Lang+";" +"addMarker(latt, langg);"
                                );*/

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<DataAddr> call, Throwable throwable) {

                    }


                });






        }
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



    interface GetConverterAddrToLatLng{
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




class  Patient{
    String addrese;
    int id_personnel;
    Date date;
	public Patient( int id_personnel,String addrese, Date date) {
		
		this.addrese = addrese;
		this.id_personnel = id_personnel;
		this.date = date;
	}
	public String getAddrese() {
		return addrese;
	}
	public void setAddrese(String addrese) {
		this.addrese = addrese;
	}
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}