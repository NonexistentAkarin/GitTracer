package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/22.
 */

public class TestResult implements Serializable {

    @SerializedName("git_url")
    private String git_url;
    @SerializedName("compile_succeeded")
    private boolean compile_succeeded;
    @SerializedName("tested")
    private boolean tested;
    @SerializedName("testcases")
    private TestCase[] testCases;

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public boolean isCompile_succeeded() {
        return compile_succeeded;
    }

    public void setCompile_succeeded(boolean compile_succeeded) {
        this.compile_succeeded = compile_succeeded;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public TestCase[] getTestCases() {
        return testCases;
    }

    public void setTestCases(TestCase[] testCases) {
        this.testCases = testCases;
    }
}
