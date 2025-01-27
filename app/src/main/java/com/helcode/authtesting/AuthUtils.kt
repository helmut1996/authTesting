package com.helcode.authtesting



fun userAuthentication(email: String, password: String): Boolean {
    if (email == "josubrenes0@gmail.com" && password == "1234"){
        return true
    }
    return false
}
fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email!!.isEmpty() && password!!.isEmpty()){
        return AuthEvent.FORM_EMPTY
    }else  if (email!!.isEmpty()){
        return AuthEvent.EMAIL_EMPTY
    }else if (password!!.isEmpty()){
        return AuthEvent.PASSWORD_EMPTY
    }else if (email.isNotEmpty() && !isEmailValid(email)){
        return AuthEvent.INVALID_EMAIL
    }



    if (email == "josubrenes0@gmail.com" && password == "1234"){
        return AuthEvent.USER_EXIST
    }
    return AuthEvent.NOT_USER_EXIST
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}