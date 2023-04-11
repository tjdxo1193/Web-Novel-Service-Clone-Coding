package webnovelservice.global.util;

public record CursorRequest<R>(Long key, int size, R r) {
    public static final Long NONE_KEY = -1L;

    public Boolean hasKey() {
        return key != null && !key.equals(NONE_KEY);
    }

    public CursorRequest next(Long key) {
        return new CursorRequest(key, size, r);
    }
}
