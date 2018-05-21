package com.qdm.mq.exception;

/**
 * @author qiudm
 * @date 2018/5/11 19:08
 * @desc
 */
public class MqException extends RuntimeException {
    private static final long serialVersionUID = 816405217864151378L;

    public MqException(String message) {
        super(message);
    }

    public MqException(Throwable e) {
        super(e);
    }

    public MqException(String message, Throwable cause) {
        super(message, cause);
    }
}
