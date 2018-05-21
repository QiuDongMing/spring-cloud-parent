package com.qdm.mq.exception;

/**
 * @author qiudm
 * @date 2018/5/11 19:11
 * @desc
 */
public class MqConnectionException extends MqException {

    public MqConnectionException(String message) {
        super(message);
    }

    public MqConnectionException(Throwable e) {
        super(e);
    }

    public MqConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
