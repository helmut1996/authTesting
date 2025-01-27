package com.helcode.authtesting

enum class AuthEvent {
    //success
    USER_EXIST,

    //fail
    NOT_USER_EXIST,
    EMAIL_EMPTY,
    FORM_EMPTY,
    PASSWORD_EMPTY,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    LENGTH_PASSWORD,
    //Exception
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM
}