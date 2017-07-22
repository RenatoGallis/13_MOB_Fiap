package com.example.renatogallis.fixcard;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Renato Gallis on 09/07/2017.
 */

public interface UsuarioAPI {
    @GET("v2/58b9b1740f0000b614f09d2f")
    Call<Usuario> getDadosUsuarios();
}
