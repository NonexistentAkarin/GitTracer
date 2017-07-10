package im.akari.gittracer.presenter.contract;


import im.akari.gittracer.model.entity.QuestionScore;

/**
 * Created by akari on 2017/6/22.
 */

public interface QuestionScoreContract {

    interface View {

        void showScoreGraph(QuestionScore questionScore);

        void showScoreList(QuestionScore questionScore);

    }

    interface Presenter {

        void getQuestionScoreBy(String token, int assignmentId, int questionId);

    }
}
