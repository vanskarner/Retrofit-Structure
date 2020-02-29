package vanskarner.android.retrofitstructure.api_service;

import vanskarner.android.retrofitstructure.api_service.services.UserService;

public class ServicesCallback {

    /*Here you register all your services*/
    public static UserService userService() {
        return UserService.getInstance();
    }

}
