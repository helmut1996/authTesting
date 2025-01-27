package com.helcode.authtesting

import kotlin.contracts.Returns


fun userAuthentication(email: String, password: String): Boolean {

    if (email == "josubrenes0@gmail.com" && password == "1234") {
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {




    if (email == null && password == null){
        throw AuthException(AuthEvent.NULL_FORM)
    }else if (email == null) {
        throw AuthException(AuthEvent.NULL_EMAIL, "EL CORREO NO PUEDE IR NULO")
    }else if (password == null){
        throw AuthException(AuthEvent.NULL_PASSWORD)
    }

    val passwordNumeric = password.toIntOrNull()

     if (email.isEmpty() && password.isEmpty()) {
        return AuthEvent.FORM_EMPTY
    } else if (email.isEmpty()) {
        return AuthEvent.EMAIL_EMPTY
    } else if (password.isEmpty()) {
        return AuthEvent.PASSWORD_EMPTY
    }else if(password.length != 4){
      return AuthEvent.LENGTH_PASSWORD
     } else if (!isEmailValid(email) && passwordNumeric == null) {
        return AuthEvent.INVALID_USER
    } else if (email.isNotEmpty() && !isEmailValid(email)) {
        return AuthEvent.INVALID_EMAIL
    } else if (password.isNotEmpty() && passwordNumeric == null) {
        return AuthEvent.INVALID_PASSWORD
    }


    if (email == "josubrenes0@gmail.com" && password == "1234") {
        return AuthEvent.USER_EXIST
    } else {
        return AuthEvent.NOT_USER_EXIST
    }
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}