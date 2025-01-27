package com.helcode.authtesting

class AuthException(val authEvent: AuthEvent, msg:String? = null): Exception(msg)