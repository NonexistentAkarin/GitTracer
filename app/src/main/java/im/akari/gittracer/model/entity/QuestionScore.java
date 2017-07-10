package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/22.
 */

public class QuestionScore implements Serializable {
    @SerializedName("questionInfo")
    private QuestionInfo questionInfo;
    @SerializedName("students")
    private StudentScore[] studentScores;

    public QuestionInfo getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(QuestionInfo questionInfo) {
        this.questionInfo = questionInfo;
    }

    public StudentScore[] getStudentScores() {
        return studentScores;
    }

    public void setStudentScores(StudentScore[] studentScores) {
        this.studentScores = studentScores;
    }
}
