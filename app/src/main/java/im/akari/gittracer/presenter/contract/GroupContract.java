package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Group;

/**
 * Created by akari on 2017/6/13.
 */

public interface GroupContract {

    interface View {

        void showGroups(List<Group> groups);

    }

    interface Presenter {

        void getAllGroups(String token);

    }

}
