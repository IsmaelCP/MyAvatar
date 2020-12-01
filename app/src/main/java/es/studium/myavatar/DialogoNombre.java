package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment
{
    DialogoSexo dialogoSexo;
    OnDialogoListener mListener;
    EditText nombre;
    String nombreElegido;
    Avatar avatar;

    public DialogoNombre(Avatar avatar)
    {
        this.avatar = avatar;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myView = inflater.inflate(R.layout.dialogo_nombre, null);
        nombre = myView.findViewById(R.id.editNombre);
        builder.setView(myView)
                .setTitle("Vamos a ponerle nombre")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // Capturar los datos introducidos en el editText nombre
                        try
                        {
                            avatar.setNombre(nombre.getText().toString());
                                /*
                                mListener.onDataSetNombre(nombre.getText().toString());
                                //BlankFragment blankFragment = new BlankFragment();
                                Bundle bundle = new Bundle();
                                // Datos a enviar
                                //avatar.setNombre(nombre.getText().toString());
                                bundle.putString("nombre", nombre.getText().toString());
                                */

                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        /*
                        //BlankFragment blankFragment = new BlankFragment();
                        Bundle bundle = new Bundle();
                        // Datos a enviar
                        bundle.putString("nombre", "Pepe");
                        */
                        avatar.setNombre(nombreElegido);
                        dialogoSexo = new DialogoSexo(avatar);
                        dialogoSexo.setCancelable(false);
                        dialogoSexo.show(getFragmentManager(), "SEXO");
                        dialog.dismiss();
                        mListener.onDialogoAceptarListenerNombre();
                    }
                })
                // Añadir el botón Cancelar
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                        mListener.onDialogoCancelarListener();
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
