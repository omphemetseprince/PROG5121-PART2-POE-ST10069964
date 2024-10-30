package main;

/**
 *
 * @author Omphemetse Prince
 */

public class Login {

    String userRegister;
    String passWordRegister;
    String nameRegister;
    String lastNameRegister;
    String userLogin;
    String passwordLogin;
    Boolean correctUsername;

//set methods
    public void setUserRegister(String userName) {
        userRegister = userName;
    }

    public void setPassWordRegister(String passWord) {
        passWordRegister = passWord;
    }

    public void setFirstName(String firstName) {
        nameRegister = firstName;
    }

    public void setLastName(String lastName) {
        lastNameRegister = lastName;
    }

    public void setUserLogin(String Username) {
        userLogin = Username;
    }

    public void setUserPassword(String Password) {
        passwordLogin = Password;
    }
//get methods

    public String getUserRegister() {
        return userRegister;
    }

    public String getPassWordRegister() {
        return passWordRegister;
    }

    public String getFirstName() {
        return nameRegister;
    }

    public String getLastName() {
        return lastNameRegister;
    }

    public String getUserName() {
        return userLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }
//Test username

    public boolean checkUsername() {
    boolean correctUsernameLength = userRegister.length() <= 5;
    boolean containsUnderscore = userRegister.contains("_");
    
    return correctUsernameLength && containsUnderscore;
}

//test password length

    /*
(?=.*[0-9]) a digit must occur at least once
(?=.*[A-Z]) an upper case letter must occur at least once
(?=.*[@#$%^&+=]) a special character must occur at least once
.{8,} minimum 8 letters
Sourced from https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
     */

// ? means query
    public boolean checkPasswordComplexity() {
        boolean passwordformat;

        String pattern = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}";

        passwordformat = passWordRegister.matches(pattern) && passWordRegister.length() >= 8;

        return passwordformat;
    }

    public String registerUser() {

        boolean pass = checkPasswordComplexity();
        boolean user = checkUsername();

        if (pass && user) {
            String message = "Registration complete";
            return message;
        } else if (checkPasswordComplexity() == false) {
            String message = "Password requirements are incorrect";
            return message;
        } else {
            // returnMessage = "Username requirements are incorrect";
            String message = "Username requirements are incorrect";
            return message;
        }
    }
//Testing if selected username and password is matching up with the entered one

  public Boolean loginUser() {
    return userLogin.equals(userRegister) && passwordLogin.equals(passWordRegister);
}


    public String returnLoginStatus() {
        if (loginUser()) {
            return "You have been succesfully logged in";
        } else {
            return "Login has failed.";
        }
    }
    
}

