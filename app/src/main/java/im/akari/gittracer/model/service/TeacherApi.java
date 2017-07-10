package im.akari.gittracer.model.service;

import java.util.List;

import im.akari.gittracer.model.entity.AssignmentScore;
import im.akari.gittracer.model.entity.Group;
import im.akari.gittracer.model.entity.Student;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by akari on 2017/6/12.
 */

public interface TeacherApi {

    @GET("group")
    Observable<List<Group>> getAllGroups(@Header("Authorization") String token);

    @GET("group/{groupId}/students")
    Observable<List<Student>> getStudentsByGroupId(@Header("Authorization") String token, @Path("groupId") int id);


    @GET("assignment/{assignmentId}/score")
    Observable<AssignmentScore> getScoreInfoByAssignmentId(@Header("Authorization") String token, @Path("assignmentId") int id);
}
