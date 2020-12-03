package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment
{
    OnDialogoListener mListener;
    RadioButton elfo;
    RadioButton enano;
    RadioButton hobbit;
    RadioButton humano;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_especie, null);
        elfo = MyView.findViewById(R.id.rb_elfo);
        enano = MyView.findViewById(R.id.rb_enano);
        hobbit = MyView.findViewById(R.id.rb_hobbit);
        humano = MyView.findViewById(R.id.rb_humano);
        builder.setView(MyView)
                .setTitle("Ahora una especie")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Capturar la elección de la especie
                        if(elfo.isChecked())
                        {
                            mListener.onDataSetEspecie("elfo");
                            mListener.abrirDialogoProfesion();
                            dialog.dismiss();
                        }
                        else if(enano.isChecked())
                        {
                            mListener.onDataSetEspecie("enano");
                            mListener.abrirDialogoProfesion();
                            dialog.dismiss();
                        }
                        else if(hobbit.isChecked())
                        {
                            mListener.onDataSetEspecie("hobbit");
                            mListener.abrirDialogoProfesion();
                            dialog.dismiss();
                        }
                        else{
                            mListener.onDataSetEspecie("humano");
                            mListener.abrirDialogoProfesion();
                        }
                        // Cerrar el diálogo
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

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // Verificamos que la actividad principal ha implementado el interfaz
        try
        {
            // Instanciamos OnDialogoAceptarListener para poder enviar eventos a la clase principal
            mListener = (OnDialogoListener) context;
        }
        catch (ClassCastException e)
        {
            // La actividad no implementa el interfaz
            throw new ClassCastException(context.toString() + " debe implementar OnDialogoListener");
        }
    }
}