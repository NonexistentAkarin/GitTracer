package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Exam;

/**
 * Created by akari on 2017/6/16.
 */

public interface ExamContract {

    interface View {

        void showExam(List<Exam> examList);

    }

    interface Presenter {
        void getExamByCourseId(String token, int courseId);
    }

}
