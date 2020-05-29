package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText et_correo,et_password;
    private Button btn_ingresar,btn_registrar;
    private String correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ingresar = (Button) findViewById(R.id.btn_ingreso);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        et_correo = (EditText) findViewById(R.id.txt_logCorreo);
        et_password = (EditText) findViewById(R.id.txt_logPassword);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth = FirebaseAuth.getInstance();

                correo = et_correo.getText().toString();
                password = et_password.getText().toString();

                verificarIngreso(correo, password);
            }
        });
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarRegistro();
            }
        });
    }

    private void verificarIngreso(String correo, String password) {
        mAuth.signInWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                if(task.isSuccessful()){
                    Toast.makeText(login.this, "Ingreso exitoso",Toast.LENGTH_SHORT).show();
                    String id = mAuth.getUid().toString();
                    iniciarPerfilChaza(id);
                }else{
                    Toast.makeText(login.this, "Ingreso fallido, verifique que el usuario o contraseña estén bien digitados",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarPerfilChaza(String id) {
        Intent intent = new Intent(login.this, Perfilchaza.class);
        intent.putExtra("ID",id);
        intent.putExtra("estado",false);
        startActivity(intent);
    }
    public void iniciarRegistro(){
        Intent intent1 = new Intent(this, Registro.class);
        startActivity(intent1);
    }
}
