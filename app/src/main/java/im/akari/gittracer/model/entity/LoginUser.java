package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by akari on 2017/6/13.
 */

public class LoginUser {


    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public LoginUser() {

    }

    public LoginUser(String u, String p) {
        this.username = u;
        this.password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
