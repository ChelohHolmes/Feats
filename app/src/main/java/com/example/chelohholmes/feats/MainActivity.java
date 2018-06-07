package com.example.chelohholmes.feats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public EditText numero;
    public TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (EditText) findViewById(R.id.Number);
        resultado = (TextView) findViewById(R.id.Resultado);
    }

    public void sacarFactorial (View v)
    {
        JsonObjectRequest peticion = new JsonObjectRequest
                (
                        Request.Method.GET,
                        "http://192.168.84.33:8080/xampp/htdocs/Hamana.php?algo=", numero.getText().toString(),
                        null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse (JSONObject response)
                            {
                                try{
                                    int factorial =
                                    //Resultado.setText("" + response.getInt("Factorial"));
                                }
                            }
                        }
                );
    }

}


