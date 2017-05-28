package fullscreen.com.myfullsceen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity_FullScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3500;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__full_screen);
//Executando o método que iniciará nossa animação
        carregar();
    }
    private void carregar() {
        Animation anim = AnimationUtils.loadAnimation(this,
                R.anim.animacao_splash);
        anim.reset();
//Pegando o nosso objeto criado no layout
        ImageView iv = (ImageView) findViewById(R.id.splash);
        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
// Após o tempo definido irá executar a próxima

                Intent intent = new Intent(MainActivity_FullScreen.this,
                        Menu_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                MainActivity_FullScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
