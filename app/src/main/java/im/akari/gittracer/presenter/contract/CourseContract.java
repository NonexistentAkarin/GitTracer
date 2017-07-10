package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Course;

/**
 * Created by akari on 2017/6/16.
 */

public interface CourseContract {

    interface View {

        void showCourses(List<Course> courses);

    }

    interface Presenter {

        void getCoursesByUsername(String token, String username);

    }
}
