package com.example.prueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText et_correo, et_password;
    private Button btn_registro;
    private String correo = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        et_correo = (EditText) findViewById(R.id.txt_regCorreo);
        et_password = (EditText) findViewById(R.id.txt_regPassword);
        btn_registro = (Button) findViewById(R.id.btn_registro);

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = et_correo.getText().toString();
                password = et_password.getText().toString();

                if (!correo.isEmpty() && !password.isEmpty()){

                    if(password.length() >= 6){
                        registrarUsuario();
                    }else{
                        Toast.makeText(Registro.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Registro.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void registrarUsuario() {
        mAuth.createUserWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull final Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    String id = mAuth.getUid().toString();
                    iniciarPerfilChaza(id);
                } else {
                    Toast.makeText(Registro.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarPerfilChaza(String id) {
        Intent intent = new Intent(Registro.this, Perfilchaza.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}
