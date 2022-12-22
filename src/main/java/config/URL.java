package config;

import lombok.Data;

@Data
public class URL {

    public static final String MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    public static final String REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT_PASSWORD_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String USER_ACCOUNT_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String USER_FEED_PAGE = "https://stellarburgers.nomoreparties.site/feed";
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    public static final String AUTH = "auth";
    public static final String AUTH_REGISTER = AUTH + "/register";
    public static final String AUTH_LOGIN = AUTH + "/login";
    public static final String AUTH_USER = AUTH + "/user";

}