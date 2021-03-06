package com.example.renatogallis.fixcard.Model;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.renatogallis.fixcard.dao.Scripts_Table_Livros;
import com.example.renatogallis.fixcard.R;
import com.example.renatogallis.fixcard.Utills.Utilitarios;
import java.io.ByteArrayOutputStream;
import static android.media.MediaRecorder.VideoSource.CAMERA;

public class AddBookActivity extends AppCompatActivity {
    private ImageView image;
    private EditText titulo, autor;
    private TextView texto_tire_a_foto;
    private byte[] img = null;
    private Scripts_Table_Livros books = new Scripts_Table_Livros(this);
    private Utilitarios util = new Utilitarios();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        image = (ImageView) findViewById(R.id.imagem_hq);
        titulo = (EditText) findViewById(R.id.titulo);
        //selo = (Text) findViewById(R.id.editora);
        autor = (EditText) findViewById(R.id.autor);
        //Log.d("COUNT DA TABLE", String.valueOf(DatabaseUtils.queryNumEntries(books.returnConection(), books.TABLE_LIVRO)));
        texto_tire_a_foto = (TextView) findViewById(R.id.tv_tireAFoto);

    }

    public void foto(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, CAMERA);
    }

    //pegar o resultado da foto:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitMap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitMap);
            texto_tire_a_foto.setText("");
            //convertendo a image em um array de Bytes para colocar no banco
            ByteArrayOutputStream saida = new ByteArrayOutputStream();
            imageBitMap.compress(Bitmap.CompressFormat.PNG, 100, saida);
            img = saida.toByteArray();
        }

    }

    public void onBackPressed() {
        super.onBackPressed();
    }


    public void Salvar(View view) {


        if (titulo.getText().toString().equals("") || autor.getText().toString().equals("") || img == null) {
            Snackbar.make(view, R.string.Menssagem_Erro_Add_Livro, Snackbar.LENGTH_LONG).show();
        } else {
            Livro livro = new Livro();
            livro.setTitulo(titulo.getText().toString());
            livro.setAutor(autor.getText().toString());
            books.adicionar_livro(livro, img);


//colocar tratamento de salvar somente uma vez com o mesmo nome.

            Snackbar.make(view, R.string.Menssagem_Sucesso_Add_Livro, Snackbar.LENGTH_LONG).show();
            image.setImageBitmap(null);
            titulo.setText("");
            autor.setText("");
            texto_tire_a_foto.setText(R.string.tv_tire_AFoto);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putByteArray("FOTO_AICIONAR", img);
        savedInstanceState.putString("TITULO_ADICIONAR", titulo.getText().toString());
        savedInstanceState.putString("AUTOR_ADICIONAR", autor.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        img = savedInstanceState.getByteArray("FOTO_AICIONAR");
        titulo.setText(savedInstanceState.getString("TITULO_ADICIONAR"));
        autor.setText(savedInstanceState.getString("AUTOR_ADICIONAR"));
        image.setImageBitmap(util.byteTobitmap(img));
    }
}


