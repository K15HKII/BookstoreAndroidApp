package k15hkii.se114.bookstore.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class CRUDStatusResponse {

    @Expose
    @SerializedName("message")
    @Getter
    private String message;

    @Expose
    @SerializedName("status_code")
    @Getter
    private int status;

    public boolean isSuccess() {
        return status == 200;
    }

    public boolean isError() {
        return status != 200;
    }

    public boolean isNotFound() {
        return status == 404;
    }

    public boolean isUnauthorized() {
        return status == 401;
    }

    public boolean isForbidden() {
        return status == 403;
    }

    public boolean isInternalServerError() {
        return status == 500;
    }

    public boolean isBadRequest() {
        return status == 400;
    }

    public boolean isNotImplemented() {
        return status == 501;
    }

    public boolean isServiceUnavailable() {
        return status == 503;
    }

    public boolean isUnknown() {
        return status == 0;
    }

    public boolean isUnknownError() {
        return status == -1;
    }

    public boolean isNetworkError() {
        return status == -2;
    }

    public boolean isTimeoutError() {
        return status == -3;
    }

    public boolean isServerError() {
        return status == -4;
    }

    public boolean isClientError() {
        return status == -5;
    }

}
