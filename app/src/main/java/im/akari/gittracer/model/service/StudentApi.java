package im.akari.gittracer.model.service;

import im.akari.gittracer.model.entity.AssignmentAnalysis;
import im.akari.gittracer.model.entity.ReadMe;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by akari on 2017/6/12.
 */

public interface StudentApi {

    @GET("assignment/{assignmentID}/student/{studentID}/question/{questionID}")
    Observable<ReadMe> getReadMeBy(@Header("Authorization") String token,
                                   @Path("assignmentID") int assignmentId, @Path("studentID") int stdId,
                                   @Path("questionID") int questionId);


    @GET("assignment/{assignmentID}/student/{studentID}/analysis")
    Observable<AssignmentAnalysis> getAssignmentAnalysisBy(@Header("Authorization") String token,
                                                           @Path("assignmentID") int assignmentId, @Path("studentID") int stdId);
}
