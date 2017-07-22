package com.example.renatogallis.fixcard.Banco;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.renatogallis.fixcard.LoginActivity;


public class DataBase_Usuarios extends SQLiteOpenHelper {


    public DataBase_Usuarios(Context context) {
        super(context, "Usuarios", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase query) {
    query.execSQL(Scripts_Table_Usuarios.getCreateTableUsuarios());
    }

    @Override
    public void onUpgrade(SQLiteDatabase query, int i, int i1) {
        query.execSQL("DROP TABLE IF EXISTS Usuarios");
        onCreate(query);

    }

    public static boolean getDadosTabela(SQLiteDatabase db, String table){

    return DatabaseUtils.queryNumEntries(db,table)==0;

    }




}
