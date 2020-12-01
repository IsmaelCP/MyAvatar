package es.studium.myavatar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment
{
    // Creamos los objetos de las Clases de los diálogos
    DialogoProfesion dialogoProfesion;
    OnDialogoListener mListenerEspecie;
    // Variable para recoger la especie elegida
    String especieClicada = "";
    String especieElegida;
    private Avatar avatar;
    public DialogoEspecie(Avatar avatar)
    {
        this.avatar = avatar;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        //builder.setView(inflater.inflate(R.layout.dialogo_especie, null));

        View myView = inflater.inflate(R.layout.dialogo_especie, null);

        final String[] especie = getResources().getStringArray(R.array.especie);

        builder.setView(myView)
                .setTitle("Ahora una especie")
                // Añadir la lista de especies
                .setSingleChoiceItems(especie, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        especieClicada = especie[i];
                    }
                })
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {

                        // Capturar la elección de la especie
                        String elfo = "Elfo";
                        String enano = "Enano";
                        String hobbit = "Hobbit";
                        String humano = "Humano";
                        // Capturar la elección del género
                        if(especie[1] == elfo)
                        {
                            avatar.setEspecie(elfo);
                        }
                        else if (especie[1] == enano)
                        {
                            especieElegida = enano;
                        }
                        else if (especie[1] == hobbit)
                        {
                            especieElegida = hobbit;
                        }
                        else if (especie[1] == humano)
                        {
                            especieElegida = humano;
                        }

                        avatar.setEspecie(especieElegida);
                        dialogoProfesion = new DialogoProfesion(avatar);
                        dialogoProfesion.setCancelable(false);
                        dialogoProfesion.show(getFragmentManager(), "Para terminar, escoge una profesión");
                        dialog.dismiss();
                    }
                })
                // Añadir el botón Cancelar
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });
        // Crear el objeto y devolverlo
        return builder.create();
    }
}