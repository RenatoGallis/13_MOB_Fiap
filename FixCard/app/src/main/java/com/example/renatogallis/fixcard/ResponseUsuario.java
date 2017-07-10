package com.example.renatogallis.fixcard;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Renato Gallis on 09/07/2017.
 */

public class ResponseUsuario {
    @SerializedName("usuario")
    private List<Usuario> usuariosList;

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }
}
