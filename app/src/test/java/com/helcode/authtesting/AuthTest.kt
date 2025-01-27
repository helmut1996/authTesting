package com.helcode.authtesting


import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class AuthTest {
    @Test
    fun login_complete_returnsTrue(){
        val isAutenthenticated = userAuthentication("josubrenes0@gmail.com","1234")
        assertTrue(isAutenthenticated)
    }

    @Test
    fun login_complete_returnsFalse(){
        val isAutenthenticated = userAuthentication("josubrenes0@gmail.com","123456")
        assertFalse(isAutenthenticated)
    }

    @Test
    fun login_emptyEmail_returnsTrue(){
        val isAutenthenticated = userAuthentication("","1234")
        assertFalse(isAutenthenticated)
    }
//    @Test
//    fun login_nullEmail_returnsTrue(){
//        val isAutenthenticated = userAuthenticationTDD(null,"1234")
//        assertFalse(isAutenthenticated)
//    }
//    @Test
//    fun login_nullPassword_returnsTrue(){
//        val isAutenthenticated = userAuthenticationTDD("josubrenes0@gmail.com",null)
//        assertFalse(isAutenthenticated)
//    }
}