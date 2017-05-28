package fullscreen.com.myfullsceen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static fullscreen.com.myfullsceen.R.id.textView;

public class Confirmacao_Activity extends AppCompatActivity {
private TextView tvConfirmacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao_);

        tvConfirmacao = (TextView) findViewById(R.id.tvConfirmacao);
        if (getIntent() != null){
            String nome = getIntent().getStringExtra("nome");
            String idade = getIntent().getStringExtra("Idade");
            String time = getIntent().getStringExtra("time");
            tvConfirmacao.setText(getString(R.string.confirmacaocadastro,nome,time)
            );
        }
    }
}
