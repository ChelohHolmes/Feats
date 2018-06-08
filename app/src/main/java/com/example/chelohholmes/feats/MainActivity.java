package com.example.chelohholmes.feats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.chelohholmes.feats.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public EditText numero;
    public TextView resultado;
    public Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (EditText) findViewById(R.id.Number);
        resultado = (TextView) findViewById(R.id.Resultado);
        boton = (Button) findViewById(R.id.Button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest peticion = new JsonObjectRequest
                        (
                                Request.Method.GET,
                                "http://192.168.84.33:8080/xampp/htdocs/Hamana.php?algo="+ numero.getText().toString(),
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        try {
                                            int factorial = response.getInt("Factorial");
                                            resultado.setText("" + factorial);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                , new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(MainActivity.this);
                x.add(peticion);
            }
        });
    }
}