package com.example.semana1desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

            String user ="";
            String password ="";
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

    }



    public void sendMessage(View view) {


        Intent intent = new Intent(MainActivity.this, Reserves.class);


        EditText userEditText=findViewById(R.id.username);
        user = userEditText.getText().toString();
        EditText passwordEditText=findViewById(R.id.password);
        password =passwordEditText.getText().toString();
        String loginResult = "";
        boolean logged = false;
        final List<String> users = Arrays.asList("a","Administrador", "Adm", "Administrator", "Root");
        final List<String> passwords = Arrays.asList("a", "Administrador","Adm123", "Que3B1eng4ElT0r0", "pr0m1uscu0");

        if(user.length() == 0){
            Toast.makeText( getBaseContext(),  "Por favor preencha seu Usuario" ,
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(user.contains(" ")){
            Toast.makeText( getBaseContext(),  "O usuario nao pode conter caracteres em branco" ,
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(password.length() == 0){
            Toast.makeText( getBaseContext(),  "Por favor preencha sua senha" ,
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(password.contains(" ")){
            Toast.makeText( getBaseContext(),  "A senha nao pode conter caracteres em branco" ,
                    Toast.LENGTH_LONG).show();
            return;
        }


        for (int i = 0; i < 3; i++) {
            if(users.get(0).equals(user)){

                if(password.equals(passwords.get(i))){
                    System.out.println("foi");
                    loginResult = "logado com sucesso!";
                    logged = true;
                }
            }
        }
        if(!logged)
            loginResult = "Falha no login";
        if(logged)
            startActivity(intent);

//        if(users.get(1) == user){
//            if(password == passwords.get(0)){
//                loginResult = "logado com sucesso!";
//                logged = true;
//            }
//        }
//        if(users.get(2) == user){
//            if(password == passwords.get(0)){
//                loginResult = "logado com sucesso!";
//                logged = true;
//            }
//        }
//        if(users.get(3) == user){
//            if(password == passwords.get(0)){
//                loginResult = "logado com sucesso!";
//                logged = true;
//            }
//        }


        Toast.makeText( getBaseContext(),  loginResult ,
                Toast.LENGTH_LONG).show();
    }
}