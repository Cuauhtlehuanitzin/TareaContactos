package mx.unam.tareacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    //Variables globales privadas
    private TextView tvNombre;
    private TextView tvNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Recepción de parámetros que se enviaron desde la primera pantalla
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");                 //Obtiene nombre
        String nacimiento = parametros.getString("nacimiento");         //Obtiene fecha de nacimiento
        String telefono = parametros.getString("telefono");             //Obtiene Telefono
        String email = parametros.getString("email");                   //Obtiene Email
        String descripcion = parametros.getString("descripcion");       //Obtiene descripcion

        tvNombre = (TextView) findViewById(R.id.tvNombre);              //Obj Textview a variable TextView
        tvNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);                                   //Asigna el nombre obtenido, al TextView
        tvNacimiento.setText("Fecha de nacimiento: "+nacimiento);
        tvTelefono.setText("Teléfono: "+telefono);                  //Asigna el telefono obtenido, al TextView
        tvEmail.setText("Email: "+email);                           //Asigna el email obtenido, al TextView
        tvDescripcion.setText("Descripción: "+descripcion);

        Button btnEditar = (Button)findViewById(R.id.btn_editar_datos);
        assert btnEditar != null;
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }




}
