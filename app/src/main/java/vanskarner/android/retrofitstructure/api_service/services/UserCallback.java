package vanskarner.android.retrofitstructure.api_service.services;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vanskarner.android.retrofitstructure.api_service.OnCompleteListener;
import vanskarner.android.retrofitstructure.api_service.codeapi.CodeApi;
import vanskarner.android.retrofitstructure.api_service.codeapi.CodeApiInstance;
import vanskarner.android.retrofitstructure.api_service.response.UserRes;

class UserCallback {
    private static final String TAG = "UserCallback";
    private static CodeApi codeApi = CodeApiInstance.getInstance();

        /*TODO: If you need a more personalized listener declare it here

    public interface OnUserListener <T> {
            void onSuccess(T object);

            void onFail(String message);

        }

    */

    static Callback<UserRes> defaultCallBack(final OnCompleteListener<UserRes> listener) {
        return new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, final Response<UserRes> response) {
                //TODO: Comment on this line of code (line 32) and enable the commented block (line 33 to 43) if your api is handled by codes
                listener.onSuccess(response.body());
                /*codeApi.checkCodeApi(response.body().getCodeStatus(), new OnCodeApiListener() {
                    @Override
                    public void onSuccess() {
                        listener.onSuccess(response.body());
                    }

                    @Override
                    public void onFail(String message) {
                        listener.onFail(message);
                    }
                });*/
            }

            @Override
            public void onFailure(Call<UserRes> call, Throwable t) {
                listener.onFail(t.getMessage());
                Log.d(TAG,t.getMessage());
            }
        };
    }
}
