package com.example.lib_base.network.exceptions;

/**
 * 用户信息不完整
 */
@Deprecated
public class IncompleteInformationException extends Exception {

    private final String token;

    public IncompleteInformationException(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
