package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/22.
 */

public class AssignmentAnalysis implements Serializable {
    @SerializedName("studentId")
    private int studentId;
    @SerializedName("assignmentId")
    private int assignmentId;
    @SerializedName("questionResults")
    private QuestionResult[] questionResults;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public QuestionResult[] getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(QuestionResult[] questionResults) {
        this.questionResults = questionResults;
    }
}
