package im.akari.gittracer.presenter.contract;

import im.akari.gittracer.model.entity.QuestionResult;

/**
 * Created by akari on 2017/6/22.
 */

public interface QuestionAnalysisContract {

    interface View {

        void showAnalysis(QuestionResult analysis);


    }

    interface Presenter {

        void getQuestionAnalysisByThreeIds(String token, int assignId, int stdId, int questionId);

    }

}
