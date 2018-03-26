package cz.uhk.fim.brahavl1.fragmentsmallapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings_fragmet, container, false);

        final EditText editTextLogin = view.findViewById(R.id.editTextLogin);
        final EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonSave = view.findViewById(R.id.btnSave);


        //todo shared prefferences
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);



        editTextLogin.setText(sharedPreferences.getString("login", ""));
        editTextPassword.setText(sharedPreferences.getString("password", ""));

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();

                //tohle bude ukladat někam data
                //todo tohle celý podtím uloží heslo a login do trvalý paměti uložený v telefonu dokud třeba nesmažeme apku
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("login", login);
                editor.putString("password", password);
                editor.commit();
                //podsud

                Toast.makeText(getContext(),login + ":" + password,Toast.LENGTH_SHORT);
            }
        });


        return view;
    }

}
