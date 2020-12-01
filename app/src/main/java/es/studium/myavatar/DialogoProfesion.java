package es.studium.myavatar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

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
    // Creamos los objetos de las Clases de los diálogos
    OnDialogoListener mListener;
    MainActivity mainActivity;
    // Variable para recoger la especie elegida
    String profesionClicada = "";
    String profesionElegida;
    FragmentManager fm;
    Fragment fragment;
    FragmentTransaction ft;
    private Avatar avatar;
    public DialogoProfesion(Avatar avatar)
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
        builder.setView(inflater.inflate(R.layout.dialogo_profesion, null));

        final String[] profesion = getResources().getStringArray(R.array.profesion);

        // Obtener el Fragment
        fm = getActivity().getSupportFragmentManager();

        builder.setTitle("Para terminar, escoge una profesión")
                // Añadir la lista de especies
                .setSingleChoiceItems(profesion, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        profesionClicada = profesion[i];
                    }
                })
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {

                        // Capturar la elección de la profesión
                        String arquero = "Arquero";
                        String guerrero = "Guerrero";
                        String mago = "Mago";
                        String herrero = "Herrero";
                        String minero = "Minero";
                        // Capturar la elección del género
                        if(profesion[1] == arquero)
                        {
                            profesionElegida = arquero;
                        }
                        else if (profesion[1] == guerrero)
                        {
                            profesionElegida = guerrero;
                        }
                        else if (profesion[1] == mago)
                        {
                            profesionElegida = mago;
                        }
                        else if (profesion[1] == herrero)
                        {
                            profesionElegida = herrero;
                        }

                        avatar.setProfesion(profesionElegida);
                        fragment = fm.findFragmentByTag("fragment");
                        if(null == fragment)
                        {
                            //BlankFragment blankFragment = new BlankFragment();
                            Bundle bundle = new Bundle();
                            // Datos a enviar
                            //bundle.putString("nombre", "Pepe");

                            //bundle.putString(mainActivity.onDataSetNombre().toString());
                            // Preparar el fragmento
                            Fragment fragmento = new BlankFragment();
                            // Argumentos
                            fragmento.setArguments(bundle);
                            fm = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                           fragmentTransaction.replace(R.id.contenedorFragmento, fragmento);
                            fragmentTransaction.addToBackStack(null);
                            // Terminar transición
                            fragmentTransaction.commit();
                            /*
                            ft = fm.beginTransaction();
                            ft.replace(R.id.contenedorFragmento, blankFragment, "fragment");
                            ft.commit();
                            */
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
}