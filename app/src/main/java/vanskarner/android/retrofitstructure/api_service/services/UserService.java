package vanskarner.android.retrofitstructure.api_service.services;


import vanskarner.android.retrofitstructure.BuildConfig;
import vanskarner.android.retrofitstructure.api_service.OnCompleteListener;
import vanskarner.android.retrofitstructure.api_service.configuration.ConfigRetrofit;
import vanskarner.android.retrofitstructure.api_service.request.UserReq;
import vanskarner.android.retrofitstructure.api_service.response.UserRes;

public class UserService {
    private static String BASE_URL = BuildConfig.URL_BASE;
    private static UserApi userApi = ConfigRetrofit.createService(UserApi.class, BASE_URL);


    public static void posts_GET(OnCompleteListener<UserRes> listener) {
        userApi.posts_GET().enqueue(UserCallback.defaultCallBack(listener));
    }

    public static void posts_POST(UserReq user, OnCompleteListener<UserRes> listener) {
        userApi.posts_POST(user).enqueue(UserCallback.defaultCallBack(listener));
    }

    public static void posts_PUT(UserReq user, OnCompleteListener<UserRes> listener) {
        userApi.posts_PUT(user).enqueue(UserCallback.defaultCallBack(listener));
    }

    public static void posts_DELETE(OnCompleteListener<UserRes> listener) {
        userApi.posts_DELETE().enqueue(UserCallback.defaultCallBack(listener));
    }

}
