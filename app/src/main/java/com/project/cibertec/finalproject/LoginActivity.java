package com.project.cibertec.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtLoginUsuario;
    private EditText edtLoginPassword;
    private Button btnLoginIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        edtLoginUsuario = (EditText) findViewById(R.id.edtLoginUsuario);
        edtLoginPassword = (EditText) findViewById(R.id.edtLoginPassword);
        btnLoginIngresar = (Button) findViewById(R.id.btnLoginIngresar);

        btnLoginIngresar.setOnClickListener(btnLoginIngresarOnClick);

        if (!PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).getBoolean("ingreso", false)) {
            PreferenceManager.getDefaultSharedPreferences(LoginActivity.this)
                    .edit()
                    .putString("usuario", "Admin")
                    .putString("clave", "1234")
                    .putString("nombre", "Ernesto Rodriguez Carrasco")
                    .putBoolean("ingreso", false).commit();
        } else
            Ingresar();

    }

    View.OnClickListener btnLoginIngresarOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(validarCampos()){

                final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                pd.setIndeterminate(true);
                pd.setCancelable(false);
                pd.setMessage("Validando, espere por favor...");
                pd.show();

                Thread timerThread = new Thread(){
                    public void run(){
                        try{
                            sleep(3000);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }finally{
                            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                            if (!edtLoginUsuario.getText().toString().trim().equals(sp.getString("usuario", ""))
                                    || !edtLoginPassword.getText().toString().trim().equals(sp.getString("clave", ""))) {

                                setMessage("Usuario y/o password incorrectos");
                                pd.dismiss();
                                return;
                            }

                            sp.edit().putBoolean("ingreso", true).commit();
                            setMessage("Correcto");
                            pd.dismiss();
                            Ingresar();

                        }
                    }
                };
                timerThread.start();



            }


        }
    };


    private boolean validarCampos() {
        boolean res = true;

        if(TextUtils.isEmpty(edtLoginUsuario.getText().toString().trim())){
            edtLoginUsuario.setError("Ingrese su usuario");
            res = false;
        }else if(TextUtils.isEmpty(edtLoginPassword.getText())){
            edtLoginPassword.setError("Ingrese su password");
            res = false;
        }else if(edtLoginPassword.getText().length()<4){
            edtLoginPassword.setError("El password debe ser de 4 dígitos");
            res = false;
        }

        return res;
    }


    private void Ingresar() {
        Intent intent = new Intent(LoginActivity.this, ClientesListaActivity.class);
        startActivity(intent);
        finish();
    }


    private void setMessage(final String message){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
