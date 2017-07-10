package im.akari.gittracer.presenter.impl;

import android.util.Log;

import im.akari.gittracer.model.entity.ReadMe;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.ReadMeContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/22.
 */

public class ReadMePresenterImpl implements ReadMeContract.Presenter {

    private ReadMeContract.View view;

    public ReadMePresenterImpl(ReadMeContract.View view) {
        this.view = view;
    }

    @Override
    public void getReadMeByThreeIds(String token, int assignId, int stdId, int questionId) {
        ApiManager.getInstance().getStudentApi().getReadMeBy(token, assignId, stdId, questionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ReadMe>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ReadMe readMe) {
                        Log.d("readMe", readMe.getContent());

                        view.showReadMe(readMe);
                    }
                });
    }
}
