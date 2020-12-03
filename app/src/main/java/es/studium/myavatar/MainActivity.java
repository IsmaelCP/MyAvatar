package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDialogoListener
{
    // Creamos los objetos de las Clases de los diálogos
    DialogoNombre dialogoNombre;
    DialogoSexo dialogoSexo;
    DialogoEspecie dialogoEspecie;
    DialogoProfesion dialogoProfesion;
    // Views
    Button btnAvatar;
    TextView txtNombre;
    String sexoElegido;
    ImageView imgAvatar;
    ImageView imgProfesion;
    Button btnCerrar;
    // Random
    Random random = new Random();
    TextView txtVida;
    TextView txtMagia;
    TextView txtFuerza;
    TextView txtVelocidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializamos las Views
        btnAvatar = findViewById(R.id.btnAvatar);
        txtNombre = findViewById(R.id.txt_nombre_elegido);
        imgAvatar = findViewById(R.id.img_avatar);
        imgProfesion = findViewById(R.id.img_profesion);
        txtVida =  findViewById(R.id.txt_vida);
        txtMagia = findViewById(R.id.txt_magia);
        txtFuerza = findViewById(R.id.txt_fuerza);
        txtVelocidad = findViewById(R.id.txt_velocidad);
        btnCerrar = findViewById(R.id.btn_cerrar);
        // Le añadimos el Listener correspondiente
        btnAvatar.setOnClickListener(this);
        btnCerrar.setOnClickListener(this);

        // Poner el icono en el action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View v)
    {
        // Botón para crear el avatar
        if(v.getId()==(R.id.btnAvatar))
        {
            dialogoNombre = new DialogoNombre();
            dialogoNombre.setCancelable(false);
            dialogoNombre.show(getSupportFragmentManager(), "Nombre");
        }

        // Botón para cerrar la app
        if(v.getId()==(R.id.btn_cerrar))
        {
            finish();
        }
    }

    @Override
    public void abrirDialogoSexo()
    {
        dialogoSexo = new DialogoSexo();
        dialogoSexo.setCancelable(false);
        dialogoSexo.show(getSupportFragmentManager(), "Sexo");
    }

    @Override
    public void abrirDialogoEspecie()
    {
        dialogoEspecie = new DialogoEspecie();
        dialogoEspecie.setCancelable(false);
        dialogoEspecie.show(getSupportFragmentManager(), "Especie");
    }

    @Override
    public void abrirDialogoProfesion()
    {
        dialogoProfesion = new DialogoProfesion();
        dialogoProfesion.setCancelable(false);
        dialogoProfesion.show(getSupportFragmentManager(), "Profesión");
    }

    @Override
    public void onDataSetNombre(String nombre)
    {
        txtNombre.setText(nombre);
    }

    @Override
    public void onDataSetSexo(String sexo)
    {
        sexoElegido = sexo;
    }

    @Override
    public void onDataSetEspecie(String especie)
    {
        if(sexoElegido.equals("H"))
        {
            if(especie.equals("elfo"))
            {
                imgAvatar.setImageResource(R.drawable.elfo);
            }
            else if(especie.equals("enano"))
            {
                imgAvatar.setImageResource(R.drawable.enano);
            }
            else if(especie.equals("hobbit"))
            {
                imgAvatar.setImageResource(R.drawable.hobbit_hombre);
            }else
            {
                imgAvatar.setImageResource(R.drawable.hombre);
            }
        }
        if(sexoElegido.equals("M"))
        {
            if(especie.equals("elfo"))
            {
                imgAvatar.setImageResource(R.drawable.elfa);
            }
            else if(especie.equals("enano"))
            {
                imgAvatar.setImageResource(R.drawable.enana);
            }
            else if(especie.equals("hobbit"))
            {
                imgAvatar.setImageResource(R.drawable.hobbit_mujer);
            }else
            {
                imgAvatar.setImageResource(R.drawable.mujer);
            }
        }
    }

    @Override
    public void onDataSetProfesion(String profesion)
    {
        if(profesion.equals("arquero"))
        {
            imgProfesion.setImageResource(R.drawable.arco);
        }
        else if(profesion.equals("guerrero"))
        {
            imgProfesion.setImageResource(R.drawable.guerrero);
        }
        else if(profesion.equals("mago"))
        {
            imgProfesion.setImageResource(R.drawable.mago);
        }
        else if(profesion.equals("herrero"))
        {
            imgProfesion.setImageResource(R.drawable.herrero);
        }
        else
        {
            imgProfesion.setImageResource(R.drawable.minero);
        }
    }

    @Override
    public void random()
    {
        int vida = random.nextInt(101);
        txtVida.setText("Vida: "+vida);
        int magia = random.nextInt(11);
        txtMagia.setText("Magia: "+magia);
        int fuerza = random.nextInt(21);
        txtFuerza.setText("Fuerza: "+fuerza);
        int velocidad = random.nextInt(6);
        txtVelocidad.setText("Velocidad: "+velocidad);
    }
}