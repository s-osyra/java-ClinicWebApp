package pl.deso.ClinicWebApp.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name="userDB")
public class User {

    @Id
    private String userEmail;
    private String userName;
    private String userSurname;
    private String userPassword;
    private boolean userActive;
    private String userRole;

    public User(String userEmail, String userName, String userSurname, String userPassword, boolean userActive, String userRole) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
        this.userActive = userActive;
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "userEmail: " + this.userEmail + "\nuserName: " + this.userName +"\nuserSurname: " + this.userSurname
                + "\nuserActive: " + this.userActive + "\nuserRole: " + userRole + "\nuserPassword: " + this.userPassword;
    }

    public void updateUser (Map<String , String> map) {

        if (map.keySet().contains("userName")) {
            this.userName = map.get("userName");
        }
        if (map.keySet().contains("userSurname")) {
            this.userSurname = map.get("userSurname");
        }
        if (map.keySet().contains("userEmail")) {
            this.userEmail = map.get("userEmail");
        }
        if (map.keySet().contains("userPassword")) {
            this.userPassword = map.get("userPassword");
        }

    }


}
