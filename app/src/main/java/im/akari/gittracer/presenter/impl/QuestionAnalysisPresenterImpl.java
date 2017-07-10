package im.akari.gittracer.presenter.impl;

import android.util.Log;

import im.akari.gittracer.model.entity.AssignmentAnalysis;
import im.akari.gittracer.model.entity.QuestionResult;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.QuestionAnalysisContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/22.
 */

public class QuestionAnalysisPresenterImpl implements QuestionAnalysisContract.Presenter {

    private QuestionAnalysisContract.View view;

    public QuestionAnalysisPresenterImpl(QuestionAnalysisContract.View view) {
        this.view = view;
    }


    @Override
    public void getQuestionAnalysisByThreeIds(String token, final int assignId, int stdId, final int questionId) {
        ApiManager.getInstance().getStudentApi().getAssignmentAnalysisBy(token, assignId, stdId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AssignmentAnalysis>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String err = (e.getMessage() == null) ? "Get Analysis failed" : e.getMessage();
                        Log.e("error:", err);
                    }

                    @Override
                    public void onNext(AssignmentAnalysis assignmentAnalysis) {
                        QuestionResult[] questionResults = assignmentAnalysis.getQuestionResults();
                        QuestionResult questionResult = null;
                        for (QuestionResult questionResult1 : questionResults) {
                            if (questionResult1.getQuestionId() == questionId) {
                                questionResult = questionResult1;
                                break;
                            }
                        }
                        view.showAnalysis(questionResult);
                    }
                });
    }
}
