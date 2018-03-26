package cz.uhk.fim.brahavl1.fragmentsmallapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements View.OnClickListener {


    private OnMenuItemSelectedInterface onMenuItemSelectedInterface; //do tohodle přijde aktivita splnujici danou metodu (v našem případě chceme mainactivity)


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    //vratí view na základě inflateru
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container);

        //potřebuje implemetnovat View.OnClickListener kdyžtak alt plus enter když se dá this a ono to nabídne
        view.findViewById(R.id.btnExams).setOnClickListener(this);
        view.findViewById(R.id.btnSettings).setOnClickListener(this);
        view.findViewById(R.id.btnTeachers).setOnClickListener(this);

        view.findViewById(R.id.btnSubjectKIKM).setOnClickListener(this);
        view.findViewById(R.id.btnSubjectKIT).setOnClickListener(this);
        view.findViewById(R.id.btnSubjectKAL).setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
  /*      switch (v.getId()){
            case R.id.btnExams:

                break;

            case R.id.btnSettings:

                break;

            case R.id.btnTeachers:

                break;

            case R.id.btnSubjects:

                break;



        }*/
        //todo jak to poslat do main activity - odpoveď je udělat interface - umožní komunikvovat mezi fragmentem a aktivitiou
        onMenuItemSelectedInterface.onMenuItemSelected(v); //tohle pošlu do toho rozho rozhraní a tím že to mainActivita implementuje, tak se to tam pošle, jakoby bychom to v ní zavolali


    }

    public void setOnMenuItemSelectedInterface(OnMenuItemSelectedInterface onMenuItemSelectedInterface) {
        this.onMenuItemSelectedInterface = onMenuItemSelectedInterface;
    }

    public interface OnMenuItemSelectedInterface {
        void onMenuItemSelected (View view);
    }
}
