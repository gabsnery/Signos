package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView lista;

    private String[] signos = {"Áries", "Leão", "Sagitário",
         "Touro", "Virgem", "Capricórnio","Gêmeos", "Libra", "Aquário", "Câncer", "Escorpião", "Peixes"};
    private String[] perfis = {"Douglas", "Lucas", "Roseli",
            "André", "Virgem", "Capricórnio","GianLuca", "Libra", "Mãe", "Gabriel", "Escorpião", "Gabriela"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                signos);
        
        lista.setAdapter(adaptador);
    }
}
