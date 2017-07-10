package im.akari.gittracer.presenter.impl;

import android.util.Log;

import im.akari.gittracer.model.entity.AssignmentScore;
import im.akari.gittracer.model.entity.QuestionScore;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.QuestionScoreContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/22.
 */

public class QuestionScorePresenterImpl implements QuestionScoreContract.Presenter {

    private QuestionScoreContract.View view;

    public QuestionScorePresenterImpl(QuestionScoreContract.View view) {

        this.view = view;

    }


    @Override
    public void getQuestionScoreBy(String token, final int assignmentId, final int questionId) {
        ApiManager.getInstance().getTeacherApi().getScoreInfoByAssignmentId(token, assignmentId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AssignmentScore>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                    }

                    @Override
                    public void onNext(AssignmentScore assignmentScore) {
                        QuestionScore[] questionScores = assignmentScore.getQuestionScores();
                        QuestionScore result = null;
                        for (QuestionScore questionScore : questionScores) {
                            if (questionScore.getQuestionInfo().getId() == questionId) {
                                result = questionScore;
                                break;
                            }
                        }
                        view.showScoreGraph(result);
                        view.showScoreList(result);
                    }
                });
    }
}
