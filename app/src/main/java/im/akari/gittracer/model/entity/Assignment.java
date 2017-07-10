package im.akari.gittracer.model.entity;

/**
 * Created by akari on 2017/6/12.
 */

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import im.akari.gittracer.util.Status;

/**
 * 任务
 */
public class Assignment implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("startAt")
    private String startAt;
    @SerializedName("endAt")
    private String endAt;
    @SerializedName("questions")
    private List<Question> questions;
    @SerializedName("course")
    private int courseId;
    @SerializedName("status")
    private Status status;
    @SerializedName("currentTime")
    private String currentTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
