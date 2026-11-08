package com.ferros.ex3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView txtName = findViewById(R.id.tvName);
        TextView txtCorreu = findViewById(R.id.tvCorreu);
        TextView txtCont1 = findViewById(R.id.tvContrasenya);
        TextView txtCont2 = findViewById(R.id.tvRepContrasenya);

        EditText etName = findViewById(R.id.etName);
        EditText etCorreu = findViewById(R.id.etCorreu);
        EditText etCont1 = findViewById(R.id.etContrasenya);
        EditText etCont2 = findViewById(R.id.etRepContrasenya);

        Button registrarse = findViewById(R.id.btnProba);


        registrarse.setOnClickListener(v->{


            if (String.valueOf(etName.getText()).matches("Domador de mo.os") ){
                etName.setError("ISMAEL???");

            }

            if (!validarCorreu()){
                etCorreu.setError("Format del correu es incorrecte");
            }

            if (!String.valueOf(etCont1.getText()).equals(String.valueOf(etCont2.getText()))){
                etCont2.setError("Les contrasenyes no coincideixen");
            }

            if (!(String.valueOf(etName.getText()).matches("Domador de mo.os") || !validarCorreu() ||  !String.valueOf(etCont1.getText()).equals(String.valueOf(etCont2.getText())))){
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);

                Bundle bundle = new Bundle();


                intent.putExtra("NOM", etName.getText().toString());
                bundle.putString("CORREU", etCorreu.getText().toString());

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }





        });







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public boolean validarCorreu(){
        EditText etCorreu = findViewById(R.id.etCorreu);

        String correuRaw = String.valueOf(etCorreu.getText());
        Pattern arroba = Pattern.compile("^(.+)@(\\S+)$");
        Pattern punt = Pattern.compile("^(.+)\\.(\\S+)$");
        return arroba.matcher(correuRaw).matches() && punt.matcher(correuRaw).matches()  ;


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dato){
        super.onActivityResult(requestCode, resultCode, dato);
        if(requestCode == 1){
            TextView txtRetorno = findViewById(R.id.correu);

            if(resultCode == RESULT_OK && dato != null){
                Bundle bundle = dato.getExtras();

                if(bundle != null){
                    String respuesta = bundle.getString("RESPOSTA");
                    txtRetorno.setText(respuesta);

                }else{
                    txtRetorno.setText("OPERACIO CANCELADA");
                }
            }
        }
    }
}