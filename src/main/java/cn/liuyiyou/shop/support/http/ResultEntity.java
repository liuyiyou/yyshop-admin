package cn.liuyiyou.shop.support.http;


import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.Optional;

public class ResultEntity<T> {
    private final Object status;

    @Nullable
    private final T result;

    /**
     * Create a new {@code ResultEntity} with the given status status, and no result.
     *
     * @param status the status status
     */
    public ResultEntity(ResultStatus status) {
        this(null, status);
    }

    /**
     * Create a new {@code ResultEntity} with the given result and status.
     *
     * @param result the response result
     * @param status the status status
     */
    public ResultEntity(@Nullable T result, Object status) {
        this.result = result;
        Assert.notNull(status, "ResultStatus must not be null");
        this.status = status;

    }

    /**
     * Return the  status of the response.
     *
     * @return the  status as an ResultStatus enum entry
     */
    public String getErrmsg() {
        if (this.status instanceof ResultStatus) {
            return ((ResultStatus) this.status).getReasonPhrase();
        } else {
            return ResultStatus.valueOf((Integer) this.status).getReasonPhrase();
        }
    }


    /**
     * Return the HTTP status status of the response.
     *
     * @return the HTTP status as an int value
     * @since 1.0.0
     */
    public int getErrcode() {
        if (this.status instanceof ResultStatus) {
            return ((ResultStatus) this.status).value();
        } else {
            return (Integer) this.status;
        }
    }

    /**
     * Returns the result of this entity.
     */
    @Nullable
    public T getResult() {
        return this.result;
    }

    /**
     * Indicates whether this entity has a result.
     */
    public boolean hasResult() {
        return (this.result != null);
    }

    /**
     * Create a builder with the given status.
     *
     * @param status the response status
     * @return the created builder
     * @since 1.0.0
     */
    public static ResultBuilder status(ResultStatus status) {
        Assert.notNull(status, "ResultStatus must not be null");
        return new DefaultBuilder(status);
    }


    /**
     * Wrap the optional into a {@link ResultStatus} with an {@link ResultStatus#OK} status, or if it's empty, it
     * returns a {@link ResultEntity} with {@link ResultStatus#NOT_FOUND}.
     *
     * @param <X>           type of the response
     * @param maybeResponse response to return if present
     * @return response containing {@code maybeResponse} if present or {@link ResultStatus#NOT_FOUND}
     */
    public static <X> ResultEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
        return maybeResponse.map(response -> ResultEntity.ok(response))
            .orElse(ResultEntity.status(ResultStatus.NOT_FOUND).result(null));
    }


    /**
     * Create a builder with the given status.
     *
     * @param status the response status
     * @return the created builder
     * @since 1.0.0
     */
//    public static ResultBuilder status(int status) {
//        return new DefaultBuilder(status);
//    }


    /**
     * Create a builder with the status set to {@linkplain ResultStatus#OK OK}.
     *
     * @return the created builder
     * @since 1.0.0
     */
    public static ResultBuilder ok() {
        return status(ResultStatus.OK);
    }

    /**
     * A shortcut for creating a {@code ResultEntity} with the given body and
     * the status set to {@linkplain ResultStatus#OK OK}.
     *
     * @return the created {@code ResultEntity}
     * @since 1.0.0
     */
    public static <T> ResultEntity<T> ok(T result) {
        ResultBuilder builder = ok();
        return builder.result(result);
    }
    /**
     * A shortcut for creating a {@code ResultEntity} with the given body and
     * the status set to {@linkplain ResultStatus#OK OK}.
     *
     * @return the created {@code ResultEntity}
     * @since 1.0.0
     */
    public static ResultEntity<String> success() {

        return ok("SUCCESS");
    }

    /**
     * Defines a builder that adds a body to the response entity.
     *
     * @since 1.0.0
     */
    public interface ResultBuilder {

        /**
         * Set the body of the response entity and returns it.
         *
         * @param <T>    the type of the body
         * @param result the body of the response entity
         * @return the built response entity
         */
        <T> ResultEntity<T> result(@Nullable T result);

        <T> ResultEntity<T> build();


    }

    private static class DefaultBuilder implements ResultBuilder {

        private final Object status;


        public DefaultBuilder(Object status) {
            this.status = status;

        }


        @Override
        public <T> ResultEntity<T> build() {
            return result(null);
        }

        @Override
        public <T> ResultEntity<T> result(@Nullable T result) {
            return new ResultEntity<>(result, this.status);
        }

    }
}
