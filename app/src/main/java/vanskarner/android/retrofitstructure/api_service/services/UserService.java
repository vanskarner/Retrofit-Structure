package vanskarner.android.retrofitstructure.api_service.services;


import vanskarner.android.retrofitstructure.BuildConfig;
import vanskarner.android.retrofitstructure.api_service.OnCompleteListener;
import vanskarner.android.retrofitstructure.api_service.configuration.ConfigRetrofit;
import vanskarner.android.retrofitstructure.api_service.request.UserReq;
import vanskarner.android.retrofitstructure.api_service.response.UserRes;

public class UserService {
    private static String BASE_URL = BuildConfig.URL_BASE;
    private static UserApi userApi = ConfigRetrofit.createService(UserApi.class, BASE_URL);

    public void posts_GET(OnCompleteListener<UserRes> listener) {
        userApi.posts_GET().enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_POST(UserReq user, OnCompleteListener<UserRes> listener) {
        userApi.posts_POST(user).enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_PUT(UserReq user, OnCompleteListener<UserRes> listener) {
        userApi.posts_PUT(user).enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_DELETE(OnCompleteListener<UserRes> listener) {
        userApi.posts_DELETE().enqueue(UserCallback.defaultCallBack(listener));
    }

    /*Patter Singleton*/
    private static UserService instance=null;

    private UserService() {
    }

    private static void crearInstance(){
        if (instance==null){
            synchronized (UserService.class){
                if (instance==null){
                    instance=new UserService();
                }
            }
        }
    }

    public static UserService getInstance(){
        if (instance==null)
            crearInstance();
        return instance;
    }
}
