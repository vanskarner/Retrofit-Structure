package vanskarner.android.retrofitstructure.api_service.codeapi;


import vanskarner.android.retrofitstructure.App;
import vanskarner.android.retrofitstructure.R;

public class CodeApi {
    //Go adding according to the codes according to your api.
    private static final int OK = 1;
    private static final int SESSION_INVALID = 2;
    private static final int ERROR_UNKNOWN = 3;

    private String getString(int id) {
        return App.idToString(id);
    }

    public void checkCodeApi(int codigo, OnCodeApiListener listener) {
        switch (codigo) {
            case OK:
                listener.onSuccess();
                break;
            case SESSION_INVALID:
                listener.onFail(getString(R.string.codeapi_session_invalid));
                break;
            case ERROR_UNKNOWN:
                listener.onFail(getString(R.string.codeapi_error_unknown));
                break;
            default:
                listener.onFail(getString(R.string.codeapi_error_unknown));
                break;
        }
    }
}
