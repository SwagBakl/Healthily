package api;

public enum StatusCodeEnum {
    RESPONSE_OK(200),
    RESPONSE_FORBIDDEN(403);

    private final int code;
    StatusCodeEnum(Integer code) {
        this.code = code;
    }

    public int getStatusCode() {
        return code;
    }
}
