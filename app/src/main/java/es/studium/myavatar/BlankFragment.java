package es.studium.myavatar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment
{
    TextView nombreElegido;
    MainActivity mainActivity;
    String muestraNombre;
    Avatar avatar;
    public BlankFragment(Avatar avatar)
    {
        this.avatar = avatar;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_NOMBRE = "nombre";
    private static final String ARG_SEXO = "sexo";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOMBRE, param1);
        args.putString(ARG_SEXO, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_NOMBRE);
            mParam2 = getArguments().getString(ARG_SEXO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        nombreElegido = (TextView) view.findViewById(R.id.edit_nombre_elegido);
        String a = avatar.getNombre();
        Toast.makeText(this, a, Toast.LENGTH_LONG).show();

        avatar.setNombre(nombre.getText().toString());
        nombreElegido.getText().toString(avatar.)

    //    nombreElegido.getText(avatar.getNombre());
      //  avatar.setSexo(generoElegido);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {


/*

        //Bundle datosNombre = getArguments();
        Bundle datosNombre = new Bundle();
        String nombre = datosNombre.getString("nombre");
        nombreElegido.setText(nombre);
*/

        /*
        Bundle datosNombre = getArguments();
        if(datosNombre == null)
        {
            // No hay datos, manejar excepción
            Log.d("PasandoDatos", "Error");
            return;
        }
        // recuperamos los datos
        String nombre = datosNombre.getString("nombre");
        Log.d("Datos", "El nombre: " + nombre);

         */
    }
}