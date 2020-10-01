package com.example.semana1desafio;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.stream.Stream;

public class Reserves extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservers);
        loadReserved();
    }

    public void reserve1(View view) {
        LinearLayout layout = findViewById(R.id.lreserve1);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve1);

       btn.setEnabled(false);
    }
    public void reserve2(View view) {
        LinearLayout layout = findViewById(R.id.lreserve2);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve2);

        btn.setEnabled(false);
    }
    public void reserve3(View view) {
        LinearLayout layout = findViewById(R.id.lreserve3);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve3);

        btn.setEnabled(false);
    }
    public void reserve4(View view) {
        LinearLayout layout = findViewById(R.id.lreserve4);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve4);

        btn.setEnabled(false);
    }
    public void reserve5(View view) {
        LinearLayout layout = findViewById(R.id.lreserve5);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve5);

        btn.setEnabled(false);
    } public void reserve6(View view) {
        LinearLayout layout = findViewById(R.id.lreserve6);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve6);

        btn.setEnabled(false);
    } public void reserve7(View view) {
        LinearLayout layout = findViewById(R.id.lreserve7);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve7);

        btn.setEnabled(false);
    } public void reserve8(View view) {
        Button btn=findViewById(R.id.reserve8);

        LinearLayout layout = findViewById(R.id.lreserve8);
        layout.setBackgroundColor(Color.RED);


        btn.setEnabled(false);
    }
    public void reserve9(View view) {
        LinearLayout layout = findViewById(R.id.lreserve9);
        layout.setBackgroundColor(Color.RED);
        Button btn=findViewById(R.id.reserve9);

        btn.setEnabled(false);
    }

    public void reserveAll(View view) {

        boolean isAllDesksReserved = false;
        for (int i = 1; i < 10; i++) {
            int btnResID = getResources().getIdentifier("reserve"+i , "id", getPackageName());
            Button btn=findViewById(btnResID);
            isAllDesksReserved = !btn.isEnabled();
        }
        if(isAllDesksReserved){
            Toast.makeText( getBaseContext(),  "Operação inválida. Todas as mesas já possuem reserva" ,
                    Toast.LENGTH_LONG).show();
        }else{
            for (int i = 1; i < 10; i++) {
                int layoutResID = getResources().getIdentifier("lreserve"+i , "id", getPackageName());
                LinearLayout layout = findViewById(layoutResID);
                layout.setBackgroundColor(Color.RED);
                int btnResID = getResources().getIdentifier("reserve"+i , "id", getPackageName());
                Button btn=findViewById(btnResID);

                btn.setEnabled(false);
            }
        }
    }


    public void loadReserved(){
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        String result = sharedPreferences.getString("desks", "");
        if(result.isEmpty()){
           return;
        }

        result = result.substring(1);
        String [] stringTokens;
        stringTokens = result.split(",");
        int [] intArr = Stream.of(stringTokens)
                .mapToInt(strToken -> Integer.parseInt(strToken))
                .toArray();
        if(intArr.length == 0){
            return;
        }
        for (int i: intArr) {
            int layoutResID = getResources().getIdentifier("lreserve"+i , "id", getPackageName());
            LinearLayout layout = findViewById(layoutResID);
            layout.setBackgroundColor(Color.RED);
            int btnResID = getResources().getIdentifier("reserve"+i , "id", getPackageName());
            Button btn=findViewById(btnResID);

            btn.setEnabled(false);
        }
    }

    public void saveOp(View view) {

        String reservedDesks = "";
        for (int i = 1; i < 10; i++) {
            int btnResID = getResources().getIdentifier("reserve"+i , "id", getPackageName());
            Button btn=findViewById(btnResID);

            if(!btn.isEnabled()){
                reservedDesks =  reservedDesks.concat(",").concat(Integer.toString(i));
            }
        }


        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("desks", reservedDesks);
        editor.apply();
        Toast.makeText( getBaseContext(), "Informacoes salvas com sucesso!" ,
                Toast.LENGTH_LONG).show();

    }

    public void freeDesk(View view) {
        EditText userEditText=findViewById(R.id.deskNumber);
        String deskNumber = userEditText.getText().toString();
        int resID = getResources().getIdentifier("reserve"+deskNumber , "id", getPackageName());
        Button btn=findViewById(resID);

      if(btn.isEnabled()){
          Toast.makeText( getBaseContext(),  String.format("Mesa não reservada. A mesa %s  encontra-se habilitada para reserva", deskNumber) ,
                  Toast.LENGTH_LONG).show();
      }else{

        btn.setEnabled(true);

        int l_resID = getResources().getIdentifier("lreserve"+deskNumber , "id", getPackageName());
        LinearLayout layout= findViewById(l_resID);
          int myColor = getResources().getColor(R.color.colorButton);

        layout.setBackgroundColor(myColor);
      }
    }
}
