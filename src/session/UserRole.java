package session;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class UserRole {
    Preferences userPreferences  = Preferences.userNodeForPackage(UserRole.class) ;

    public void setUserData(String userId,String userRole){
        userPreferences.put("uid",userId);
        userPreferences.put("user_role",userRole);
    }


    public List<String> getUserData(){
        String uID = userPreferences.get("uid","not exist");
        String uRole = userPreferences.get("user_role","not exist");
        List<String> res = new ArrayList<>();
        res.add(uID);
        res.add(uRole);
        return res;
    }

}
