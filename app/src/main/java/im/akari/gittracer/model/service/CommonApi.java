package im.akari.gittracer.model.service;


import java.util.List;

import im.akari.gittracer.model.entity.Course;
import im.akari.gittracer.model.entity.Exam;
import im.akari.gittracer.model.entity.Exercise;
import im.akari.gittracer.model.entity.Homework;
import im.akari.gittracer.model.entity.User;
import im.akari.gittracer.model.entity.LoginUser;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by akari on 2017/6/12.
 */

public interface CommonApi {

    @POST("user/auth")
    Observable<Response<User>> login(@Body LoginUser user);


    @GET("user/{username}/course")
    Observable<List<Course>> getCoursesByUsername
            (@Header("Authorization") String token, @Path("username") String username);


    @GET("course/{courseId}/homework")
    Observable<List<Homework>> getHomeworkByCourseId
            (@Header("Authorization") String token, @Path("courseId") int courseId);

    @GET("course/{courseId}/exercise")
    Observable<List<Exercise>> getExerciseByCourseId
            (@Header("Authorization") String token, @Path("courseId") int courseId);

    @GET("course/{courseId}/exam")
    Observable<List<Exam>> getExamByCourseId
            (@Header("Authorization") String token, @Path("courseId") int courseId);

}
