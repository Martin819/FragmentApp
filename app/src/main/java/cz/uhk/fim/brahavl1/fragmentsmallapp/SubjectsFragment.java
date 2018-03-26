package cz.uhk.fim.brahavl1.fragmentsmallapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class SubjectsFragment extends Fragment {

    public SubjectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_subjects, container, false);

        TextView textViewSubjects = view.findViewById(R.id.textViewSubjects);


        switch(getArguments().getInt("type")){
            case R.id.btnSubjectKIKM:
                textViewSubjects.setText("ZMAT, ZMAT2, UMTE, APSTA");
            break;

            case R.id.btnSubjectKIT:
                textViewSubjects.setText("PSIT, ZT, UOMO");
            break;

            case R.id.btnSubjectKAL:
                textViewSubjects.setText("OA1, OA2, OA3, OA4");
            break;
        }

        return view;
    }

}
