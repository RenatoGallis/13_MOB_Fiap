package com.example.renatogallis.fixcard;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FullScreanActivity extends AppCompatActivity {
   private final int SPLASH_DISPLAY_LENGTH = 5000;
    private UsuarioAPI usuarioAPI;
    private String nome,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screan);
        //loading();
        carregaDados();


    }

   private void  loading(){
       //Passa a configuração de como a animação vai ser executada
       Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
       animation.reset();

       ImageView imageView = (ImageView) findViewById(R.id.splash);
       if(imageView!=null){
           imageView.clearAnimation();
           imageView.startAnimation(animation);
       }
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(FullScreanActivity.this,
                       LoginActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
               startActivity(intent);
               FullScreanActivity.this.finish();
           }
       },SPLASH_DISPLAY_LENGTH);
   }



   private void carregaDados(){
       usuarioAPI = APIUtils.getUsuarioAPI();
       usuarioAPI.getDadosUsuarios().enqueue(new Callback<Usuario>() {
           @Override
           public void onResponse(Call<Usuario> call, Response<Usuario> response) {
            if(response.isSuccessful()){
                nome  =  response.body().getUsuario();
                senha =  response.body().getSenha();
            }

           }

           @Override
           public void onFailure(Call<Usuario> call, Throwable t) {

           }


       });

   }
}
