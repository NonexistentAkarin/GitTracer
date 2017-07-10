package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Student;

/**
 * Created by akari on 2017/6/14.
 */

public interface GroupDetailContract {

    interface View {

        void showStudents(List<Student> students);

    }

    interface Presenter {

        void getStudentsByGroupId(String token, int groupId);

    }
}
