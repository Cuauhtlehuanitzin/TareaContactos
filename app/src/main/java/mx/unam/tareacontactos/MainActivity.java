package mx.unam.tareacontactos;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Context;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStart(){
        super.onStart();

        final EditText txtNombre = (EditText)findViewById(R.id.input_nombre);
        final EditText txtDate=(EditText)findViewById(R.id.txtdate);
        final EditText txtTelefono = (EditText)findViewById(R.id.input_telefono);
        final EditText txtEmail = (EditText)findViewById(R.id.input_email);
        final EditText txtDescripcion = (EditText)findViewById(R.id.input_descripcion);

        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean hasfocus) {
                if (hasfocus) {
                    DialagoCalendario dialog = new DialagoCalendario(view);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "Fecha de nacimiento: " + "DatePicker");

                }
            }

        });

        Button btnSiguiente = (Button)findViewById(R.id.btn_siguiente);

        assert btnSiguiente != null;
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DetalleContacto.class);
                i.putExtra("nombre", txtNombre.getText().toString());
                i.putExtra("nacimiento", txtDate.getText().toString());
                i.putExtra("telefono", txtTelefono.getText().toString());
                i.putExtra("email", txtEmail.getText().toString());
                i.putExtra("descripcion", txtDescripcion.getText().toString());

                startActivity(i);
            }
        });

    }

}
