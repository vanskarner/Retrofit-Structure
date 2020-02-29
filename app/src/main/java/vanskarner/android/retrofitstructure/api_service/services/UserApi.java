package vanskarner.android.retrofitstructure.api_service.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import vanskarner.android.retrofitstructure.BuildConfig;
import vanskarner.android.retrofitstructure.api_service.request.UserReq;
import vanskarner.android.retrofitstructure.api_service.response.UserRes;

public interface UserApi {
    String Authorization= BuildConfig.AUTHORIZATION;

//  @Headers({"Authorization: "+Authorization})
    @GET("/posts/1")
    Call<UserRes> posts_GET();

//  @Headers({"Content-Type: application/json", "Authorization: "+Authorization})
    @Headers({"Content-Type: application/json"})
    @POST("/posts")
    Call<UserRes> posts_POST(@Body UserReq userReq);

//  @Headers({"Content-Type: application/json", "Authorization: "+Authorization})
    @Headers({"Content-Type: application/json"})
    @PUT("/posts/1")
    Call<UserRes> posts_PUT(@Body UserReq userReq);

    @DELETE("/posts/1")
    Call<UserRes> posts_DELETE();
}
