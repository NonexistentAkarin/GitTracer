package im.akari.gittracer.presenter.contract;

import im.akari.gittracer.model.entity.ReadMe;

/**
 * Created by akari on 2017/6/22.
 */

public interface ReadMeContract {


    interface View {

        void showReadMe(ReadMe readMe);

    }

    interface Presenter {

        void getReadMeByThreeIds(String token, int assignId, int stdId, int questionId);

    }
}
