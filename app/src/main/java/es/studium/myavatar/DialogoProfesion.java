package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DialogoProfesion extends DialogFragment
{
    OnDialogoListener mListener;
    RadioButton arquero;
    RadioButton guerrero;
    RadioButton mago;
    RadioButton herrero;
    RadioButton minero;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_profesion, null);
        arquero = MyView.findViewById(R.id.rb_arquero);
        guerrero = MyView.findViewById(R.id.rb_guerrero);
        mago = MyView.findViewById(R.id.rb_mago);
        herrero = MyView.findViewById(R.id.rb_herrero);
        minero = MyView.findViewById(R.id.rb_minero);
        builder.setView(MyView)
                .setTitle("Para terminar escoge una profesión")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        // Capturar la elección de la profesión
                        if(arquero.isChecked())
                        {
                            mListener.onDataSetProfesion("arquero");
                            mListener.random();
                            dialog.dismiss();
                        }
                        else if (guerrero.isChecked())
                        {
                            mListener.onDataSetProfesion("guerrero");
                            mListener.random();
                            dialog.dismiss();
                        }
                        else if (mago.isChecked())
                        {
                            mListener.onDataSetProfesion("mago");
                            mListener.random();
                            dialog.dismiss();
                        }
                        else if (herrero.isChecked())
                        {
                            mListener.onDataSetProfesion("herrero");
                            mListener.random();
                            dialog.dismiss();
                        }
                        else{
                            mListener.onDataSetProfesion("minero");
                            mListener.random();
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