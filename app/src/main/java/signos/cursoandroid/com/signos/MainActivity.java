package signos.cursoandroid.com.signos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView lista;
    private AlertDialog.Builder dialog;

    public String[] signos = {"Áries", "Leão", "Sagitário",
         "Touro", "Virgem", "Capricórnio","Gêmeos", "Libra", "Aquário", "Câncer", "Escorpião", "Peixes"};
    public String[] perfis = {"Douglas", "Lucas", "Roseli",
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
                final String perfil = perfis[position].toString();
                final String signo = signos[position].toString();

                //Criando Dialog
                dialog = new AlertDialog.Builder(MainActivity.this);

                dialog.setTitle("Titulo"); //Titulo da caixa de dialogo

                dialog.setCancelable(false);

                dialog.setMessage("Você tem certeza?");//Mensagem que vai aparecer na caixa de dialogo

                dialog.setIcon(android.R.drawable.ic_dialog_email);
                
                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"OK!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,ActivitySigno.class);
                        intent.putExtra("signo",signo);
                        intent.putExtra("perfil",perfil);

                        startActivity(intent);
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }
}
