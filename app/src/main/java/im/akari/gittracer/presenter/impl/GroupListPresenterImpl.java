package im.akari.gittracer.presenter.impl;

import android.util.Log;

import java.util.List;

import im.akari.gittracer.model.entity.Group;
import im.akari.gittracer.model.service.ApiManager;
import im.akari.gittracer.presenter.contract.GroupContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by akari on 2017/6/13.
 */

public class GroupListPresenterImpl implements GroupContract.Presenter {


    private GroupContract.View view;

    public GroupListPresenterImpl(GroupContract.View view) {

        if (view == null) {
            throw new IllegalArgumentException("groupview must not be null");
        }
        this.view = view;

    }

    @Override
    public void getAllGroups(String token) {

        ApiManager.getInstance().getTeacherApi().getAllGroups(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Group>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String err = (e.getMessage() == null) ? "Get Groups failed" : e.getMessage();
                        Log.e("error:", err);
                    }

                    @Override
                    public void onNext(List<Group> groups) {
                        Log.d("groupSize", groups.size() + "");
                        view.showGroups(groups);
                    }
                });
    }
}
