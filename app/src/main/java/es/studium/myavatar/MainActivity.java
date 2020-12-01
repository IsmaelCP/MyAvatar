package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDialogoListener
{
    // Creamos los objetos de las Clases de los diálogos
    DialogoNombre dialogoNombre;
    DialogoSexo dialogoSexo;
    DialogoEspecie dialogoEspecie;
    DialogoProfesion dialogoProfesion;
    // Views
    Button btnAvatar;
    String nombreElegido;
    Integer sexoElegido;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Asociamos el botón Avatar con el de la vista
        btnAvatar = findViewById(R.id.btnAvatar);
        // Le añadimos el Listener correspondiente
        btnAvatar.setOnClickListener(this);
       // nombre.findViewById(R.id.edit_nombre_elegido);

        // Poner el icono en el action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==(R.id.btnAvatar))
        {
            Avatar avatar = new Avatar();
            dialogoNombre = new DialogoNombre(avatar);
            dialogoNombre.setCancelable(false);
            dialogoNombre.show(getSupportFragmentManager(), "Nombre");
        }
    }

    @Override
    public void onDialogoAceptarListenerNombre()
    {
        Toast.makeText(this, "Se ha guardado...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogoCancelarListener()
    {
        Toast.makeText(this, "Se ha cancelado...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSetNombre(String nombre)
    {
        nombreElegido = nombre;
        Toast.makeText(this, "Ha llegado "+nombreElegido+".", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDataSetSexo(Integer sexo)
    {
        sexoElegido = sexo;
    }
}