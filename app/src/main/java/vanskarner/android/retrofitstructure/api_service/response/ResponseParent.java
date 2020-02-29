package vanskarner.android.retrofitstructure.api_service.response;

public class ResponseParent {
    private int codeStatus;
    private String message;

    public int getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseParent{" +
                "codeStatus=" + codeStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
