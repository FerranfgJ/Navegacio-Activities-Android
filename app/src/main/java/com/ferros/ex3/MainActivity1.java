package com.ferros.ex3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);


        TextView txtCorreu = findViewById(R.id.correu);
        TextView txtBenvingut = findViewById(R.id.benvingut);
        Button logout = findViewById(R.id.logout);


        Bundle bundle = getIntent().getExtras();
        String nom = "";
        String correu = "";
        if (bundle != null){
             nom = bundle.getString("NOM");
             correu = bundle.getString("CORREU");
        }

        txtBenvingut.setText("Benvingut/da, "+nom+"!");
        txtCorreu.setText("Correu: "+correu+"\n");

        logout.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
            startActivity(intent);
            finish();
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
        return arroba.matcher(correuRaw).matches();


    }


    private void devolverResultado(String resposta){
        Intent intent = new Intent();
        intent.putExtra("RESPOSTA", resposta);

        setResult(RESULT_OK, intent);
        finish();
    }



}