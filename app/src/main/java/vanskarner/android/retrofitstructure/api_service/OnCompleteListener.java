package vanskarner.android.retrofitstructure.api_service;


//General listener for all services
public interface OnCompleteListener<T> {

    void onSuccess(T object);

    void onFail(String message);
}