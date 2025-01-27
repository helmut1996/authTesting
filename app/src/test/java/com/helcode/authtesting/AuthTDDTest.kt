package com.helcode.authtesting

import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Test

class AuthTDDTest {

@Test
fun   login_completeFrom_existUser_returnsSuccessEvent(){
    val isAuthenticated= userAuthenticationTDD("josubrenes0@gmail.com", "1234")
    assertEquals(AuthEvent.USER_EXIST, isAuthenticated)
}

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josnes0@gmail.com", "1234")
        assertEquals(AuthEvent.NOT_USER_EXIST, isAuthenticated)
    }

@Test
fun login_emptyEmail_returnsFailEvent(){
    val isAuthenticated= userAuthenticationTDD("", "1234")
    assertEquals(AuthEvent.EMAIL_EMPTY, isAuthenticated)
}
    @Test
    fun  login_emptyPassword_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josubrenes0@gmail.com", "")
        assertEquals(AuthEvent.PASSWORD_EMPTY, isAuthenticated)
    }
    @Test
    fun login_emptyForm_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("", "")
        assertEquals(AuthEvent.FORM_EMPTY, isAuthenticated)
    }
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josubrenes0@gmail", "1234")
        assertEquals(AuthEvent.INVALID_EMAIL, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josubrenes0@gmail.com", "1234hel")
        assertEquals(AuthEvent.INVALID_PASSWORD, isAuthenticated)
    }

    @Test
    fun login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josubrenes0@gmailcom", "1234hel")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }
    @Test(expected = AuthException::class)
    fun login_nullEmail_returnsException(){
        val isAuthenticated= userAuthenticationTDD(null, "1234hel")
        assertEquals(AuthEvent.INVALID_USER, isAuthenticated)
    }

    @Test
    fun login_nullPassword_returnsException(){
        Assert.assertThrows(AuthException:: class.java){
            print(userAuthenticationTDD("josubrenes0@gmail.com",null))
        }
    }
 @Test
 fun  login_nullForm_returnsException(){
    try {
        val ressult = userAuthenticationTDD(null,null)
        assertEquals(AuthEvent.NULL_FORM,ressult)
    }catch (e:Exception){
        (e as? AuthException)?.let {
            assertEquals(AuthEvent.NULL_FORM, it.authEvent)
        }
    }
 }
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){
        val isAuthenticated= userAuthenticationTDD("josubrenes0@gmailcom", "123")
        assertEquals(AuthEvent.LENGTH_PASSWORD, isAuthenticated)
    }



}