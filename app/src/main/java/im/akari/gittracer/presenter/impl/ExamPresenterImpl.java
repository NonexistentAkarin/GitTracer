package im.akari.gittracer.presenter.impl;

import android.util.Log;

import java.util.List;

import im.akari.gittracer.model.entity.Exam;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.ExamContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/16.
 */

public class ExamPresenterImpl implements ExamContract.Presenter {

    private ExamContract.View view;

    public ExamPresenterImpl(ExamContract.View view) {

        this.view = view;

    }


    @Override
    public void getExamByCourseId(String token, int courseId) {
        ApiManager.getInstance().getCommonApi().getExamByCourseId(token, courseId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Exam>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String err = (e.getMessage() == null) ? "Get Groups failed" : e.getMessage();
                        Log.e("error:", err);
                    }

                    @Override
                    public void onNext(List<Exam> examList) {
                        Log.d("examSize", examList.size() + "");
                        view.showExam(examList);
                    }
                });
    }
}
