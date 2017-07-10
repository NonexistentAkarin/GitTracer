package im.akari.gittracer.presenter.contract;

import im.akari.gittracer.model.entity.User;

/**
 * Created by akari on 2017/6/12.
 */

public interface LoginContract {

    interface View {

        void enterMain(User user);

        void showError();

    }

    interface Presenter {

        void getUserInfo(String username, String password);

    }


}
