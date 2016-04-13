package appsp.app.andrevera.com.appsharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvBienvenida;
    Button btnMostrar,btnGuardar;
    EditText etDato;
    Context contexto = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Contexto y archivo de SharedPreference MODE_PRIVATE SIGNIFICA QUE SOLO MODIFICARÉ EL ARCHIVO DESDE
        //ESTA APP HAY OTRA VARIABLE QUE SE USA PARA MODIFICAR EL ARCHIVO TAMBIÉN DESDE OTRA APP DEL TELÉFONO
//        Context contexto = this;
        SharedPreferences sp = getSharedPreferences("ArchivitooSP",contexto.MODE_PRIVATE);
        //elementos
        etDato = (EditText)findViewById(R.id.etDato);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        //asignando el evento
        btnMostrar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
/*
* Esto puede servir para guardar datos en memoria sin el uso de base de datos
* tener cuidado que las variables perduran aun cerrando la app o apagando el celular (esto no estoy seguro,
* con el emulador apagandolo aun los datos siguen guardados)
* */

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                SharedPreferences sharpref = getPreferences(contexto.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("varMiDato", etDato.getText().toString());//puede ser putString int Boolean....
                editor.commit();
                break;
            case R.id.btnMostrar:
                SharedPreferences sharpref2 = getPreferences(contexto.MODE_PRIVATE);//puede ser getString int Boolean...
                String valor = sharpref2.getString("varMiDato","No se encontro dato");// VARIABLE Y MENSAJE EN CASO NO SE ENCUENTRE NADA
                Toast.makeText(getApplicationContext(),"Dato Guardado: "+valor,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
