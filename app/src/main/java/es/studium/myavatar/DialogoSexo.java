package es.studium.myavatar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoSexo extends DialogFragment
{
    // Creamos los objetos de las Clases de los diálogos
    DialogoEspecie dialogoEspecie;
    OnDialogoListener mListener;
    String generoElegido;
    // Views
    RadioGroup rg_sexo;
    RadioButton rb_hombre;
    RadioButton rb_mujer;
    private Avatar avatar;
    public DialogoSexo(Avatar avatar)
    {
        this.avatar = avatar;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Creamos los objetos de las Clases de los diálogos
        OnDialogoListener mListenerSexo;

        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_sexo, null);
        rb_hombre = myView.findViewById(R.id.rb_hombre);
        rb_mujer = myView.findViewById(R.id.rb_mujer);
        builder.setView(myView)
                .setTitle("Elige un sexo")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                        // Capturar la elección del género

                        if(rb_hombre.isChecked())
                        {
                            generoElegido = "hombre";
                        }
                        else
                        {
                            generoElegido = "mujer";
                        }
                        // mListener.onDataSetNombre(String.valueOf(generoElegido.shortValue()));

                        avatar.setSexo(generoElegido);
                        dialogoEspecie = new DialogoEspecie(avatar);
                        dialogoEspecie.setCancelable(false);
                        dialogoEspecie.show(getFragmentManager(), "ESPECIE");
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
