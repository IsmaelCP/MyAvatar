package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
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
    OnDialogoListener mListener;
    RadioButton hombre;
    RadioButton mujer;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_sexo, null);
        hombre = MyView.findViewById(R.id.rb_hombre);
        mujer = MyView.findViewById(R.id.rb_mujer);
        builder.setView(MyView)
                .setTitle("Elige un sexo")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Capturar la elección del sexo
                        if (hombre.isChecked()) {
                            mListener.onDataSetSexo("H");
                            mListener.abrirDialogoEspecie();
                        }
                        else {
                            mListener.onDataSetSexo("M");
                            mListener.abrirDialogoEspecie();
                        }
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
