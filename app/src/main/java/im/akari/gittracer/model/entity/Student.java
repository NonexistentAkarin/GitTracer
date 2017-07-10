package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/12.
 */

public class Student extends User implements Serializable {

    @SerializedName("gidId")
    private int gitId;
    @SerializedName("number")

    private String number;

    public int getGitId() {
        return gitId;
    }

    public void setGitId(int gitId) {
        this.gitId = gitId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
