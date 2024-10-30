
package main;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author Omphemetse Prince
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testSetUserRegister() {
    }

    @Test
    public void testSetPassWordRegister() {
    }

    @Test
    public void testSetFirstName() {
    }

    @Test
    public void testSetLastName() {
    }

    @Test
    public void testSetUserLogin() {
    }

    @Test
    public void testSetUserPassword() {
    }

    @Test
    public void testGetUserRegister() {
    }

    @Test
    public void testGetPassWordRegister() {
    }

    @Test
    public void testGetFirstName() {
    }

    @Test
    public void testGetLastName() {
    }

    @Test
    public void testGetUserName() {
    }

    @Test
    public void testGetPasswordLogin() {
    }

    @Test
    public void testCheckUsernameTrue() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        assertTrue(login.checkUsername());
        System.out.println("Usename correctly formated: " + login.checkUsername());
    }

    @Test
    public void testCheckUsernameFalse() {
        Login login = new Login();
        login.setUserRegister("kyle!!!!!!!");
        assertFalse(login.checkUsername());
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 chracters in length: " + login.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        Login login = new Login();
        login.setPassWordRegister("Ch&&sec@ke99");
        assertTrue(login.checkPasswordComplexity());
        System.out.println("Password successfully captured: " + login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        Login login = new Login();
        login.setPassWordRegister("password");
        assertFalse(login.checkPasswordComplexity());
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character: " + login.checkPasswordComplexity());
    }

    @Test
    public void testLoginUserUsernameFail() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Ch&&sec@ke99");
        login.setUserLogin("kyl");
        login.setPassWordRegister("Ch&&sec@ke99");
        assertFalse(login.loginUser());
        System.out.println("Username or password incorrect, please try again: " + login.loginUser());
    }

    @Test
    public void testLoginUserPasswordFail() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Ch&&sec@ke99");
        login.setUserLogin("kay_1");
        login.setPassWordRegister("password");
        assertFalse(login.loginUser());
        System.out.println("Username or password incorrect, please try again: " + login.loginUser());
    }

    @Test
    public void testLoginUserTrue() {
        Login login = new Login();
        login.setUserRegister("kay_1");
        login.setUserPassword("Ch&&sec@ke99");
        login.setUserLogin("kay_1");
        login.setPassWordRegister("Ch&&sec@ke99");
        assertTrue(login.loginUser());
        System.out.println("Login successfull: " + login.loginUser());
    }
}
