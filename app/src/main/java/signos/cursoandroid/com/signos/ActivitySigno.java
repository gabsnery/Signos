package signos.cursoandroid.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySigno extends AppCompatActivity {
    private TextView textoSigno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo);

        textoSigno = (TextView) findViewById(R.id.textViewId);


        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String teste = extra.getString("perfil");
            textoSigno.setText(teste);

            Toast.makeText(getApplicationContext(),teste,Toast.LENGTH_SHORT).show();
        }

    }
}
