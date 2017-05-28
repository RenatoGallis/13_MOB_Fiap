package fullscreen.com.myfullsceen;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class Menu_Activity extends AppCompatActivity {

    private TextInputLayout tilNome;
    private TextInputLayout tilIdade;
    private Spinner spTimes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);

        tilNome = (TextInputLayout) findViewById(R.id.tilNome);
        tilIdade = (TextInputLayout) findViewById(R.id.tilIdade);
        spTimes = (Spinner) findViewById(R.id.spTimes);
    }

    public void cadastrar(View v){
        Intent intencaoConfirmar = new Intent(this,Confirmacao_Activity.class);
        intencaoConfirmar.putExtra("nome",tilNome.getEditText().getText().toString());
        intencaoConfirmar.putExtra("Idade",tilIdade.getEditText().getText().toString());
        intencaoConfirmar.putExtra("time",spTimes.getSelectedItem().toString());

        startActivity(intencaoConfirmar);
    }
}
