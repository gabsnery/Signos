package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String perfil = perfis[position].toString();
                String signo = signos[position].toString();

                Intent intent = new Intent(MainActivity.this,ActivitySigno.class);
                intent.putExtra("signo",signo);
                intent.putExtra("perfil",perfil);

                startActivity(intent);
            }
        });
    }
}
