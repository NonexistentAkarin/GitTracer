package im.akari.gittracer.presenter.contract;

import java.util.List;

import im.akari.gittracer.model.entity.Exercise;

/**
 * Created by akari on 2017/6/16.
 */

public interface ExerciseContract {

    interface View {

        void showExercise(List<Exercise> exerciseList);

    }

    interface Presenter {

        void getExerciseByCourseId(String token, int courseId);

    }

}
