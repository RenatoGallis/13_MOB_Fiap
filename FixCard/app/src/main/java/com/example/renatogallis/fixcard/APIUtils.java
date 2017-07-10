package com.example.renatogallis.fixcard;


public class APIUtils {
    public static final String URL = "http://www.mocky.io";

    public static UsuarioAPI getUsuarioAPI(){
        return RetrofitClient.getClient(URL).create(UsuarioAPI.class);
    }
}
