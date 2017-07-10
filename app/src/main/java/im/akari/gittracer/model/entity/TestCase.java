package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/22.
 */

public class TestCase implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("passed")
    private boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
