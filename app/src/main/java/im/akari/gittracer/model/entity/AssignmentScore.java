package im.akari.gittracer.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akari on 2017/6/22.
 * 查询每次任务的分数的返回体
 */

public class AssignmentScore implements Serializable {
    @SerializedName("assignmentId")
    private int assignmentId;
    @SerializedName("questions")
    private QuestionScore[] questionScores;

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public QuestionScore[] getQuestionScores() {
        return questionScores;
    }

    public void setQuestionScores(QuestionScore[] questionScores) {
        this.questionScores = questionScores;
    }
}
