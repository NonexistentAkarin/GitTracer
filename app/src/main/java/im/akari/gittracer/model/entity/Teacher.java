package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/12.
 */

public class Teacher extends User implements Serializable {

    @SerializedName("authority")
    private boolean authority;

    public boolean isAuthority() {
        return authority;
    }

    public void setAuthority(boolean authority) {
        this.authority = authority;
    }
}
