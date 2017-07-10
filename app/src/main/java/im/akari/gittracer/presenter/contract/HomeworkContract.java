package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Homework;

/**
 * Created by akari on 2017/6/16.
 */

public interface HomeworkContract {

    interface View {
        void showHomework(List<Homework> homeworkList);
    }


    interface Presenter {
        void getHomeworkByCourseId(String token, int courseId);

    }
}
