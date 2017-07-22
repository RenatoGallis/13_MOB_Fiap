package com.example.renatogallis.fixcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.renatogallis.fixcard.Banco.DataBase_Usuarios;
import com.example.renatogallis.fixcard.Banco.Scripts_Table_Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {



 Scripts_Table_Usuarios consult;
    EditText edtNme;
    EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            edtNme = (EditText)  findViewById(R.id.tilNome);
            edtNme = (EditText)  findViewById(R.id.tilSenha);


    }

    public  void login(){
        consult.getUsuari_Cadastradi_App();
// comparar os valores edtNome e edtSenha com o usuario.getNome e usuario.getSenha para a validação
        //e instanciar um intent para outra tela que seria a de cadastro
    }


}
