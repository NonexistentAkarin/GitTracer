package im.akari.gittracer.presenter.impl;

import android.util.Log;

import java.util.List;

import im.akari.gittracer.model.entity.Homework;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.HomeworkContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/16.
 */

public class HomeworkPresenterImpl implements HomeworkContract.Presenter {

    private HomeworkContract.View view;

    public HomeworkPresenterImpl(HomeworkContract.View view) {

        this.view = view;

    }

    @Override
    public void getHomeworkByCourseId(String token, int courseId) {
        ApiManager.getInstance().getCommonApi().getHomeworkByCourseId(token, courseId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Homework>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(List<Homework> homeworkList) {
                        Log.d("homeworkSize", homeworkList.size() + "");
                        view.showHomework(homeworkList);
                    }
                });
    }
}
