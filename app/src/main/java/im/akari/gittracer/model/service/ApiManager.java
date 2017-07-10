package im.akari.gittracer.model.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by akari on 2017/6/12.
 */

public class ApiManager {

    private static final String baseUrl = "http://115.29.184.56:8090/api/";
    private static ApiManager apiManager;
    private static StudentApi studentApi;
    private static TeacherApi teacherApi;
    private static CommonApi commonApi;

    private ApiManager() {
        initApi();
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            synchronized (ApiManager.class) {
                if (apiManager == null) {
                    apiManager = new ApiManager();
                }
            }
        }
        return apiManager;
    }

    private static void initApi() {
        commonApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                // .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(CommonApi.class);


        studentApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                // .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(StudentApi.class);


        teacherApi = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                // .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TeacherApi.class);
    }


    public StudentApi getStudentApi() {
        return studentApi;
    }

    public TeacherApi getTeacherApi() {
        return teacherApi;
    }

    public CommonApi getCommonApi() {
        return commonApi;
    }
}
