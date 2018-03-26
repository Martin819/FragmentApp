package cz.uhk.fim.brahavl1.fragmentsmallapp;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ListFragment.OnMenuItemSelectedInterface{

    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListFragment fragmentList =  (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentList);
        //propojím to nazpátek -řeknu co s
        fragmentList.setOnMenuItemSelectedInterface(this);

        //zeptám se, jestli je něco ve fragment conitaneru  - když není tak je to landscape
        if (findViewById(R.id.fragmentContainer) != null){
            isLandscape = true;
        }


    }

    public void onMenuItemSelected(View view) {
        //
        if (isLandscape) {
            switch (view.getId()) {
                case R.id.btnExams:
                    ExamsFragment examsFragment = new ExamsFragment(); //vytvoří fragment v layoutech - jakoby inicializace
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, examsFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                    break;

                case R.id.btnSettings:

                    break;

                case R.id.btnTeachers:
                    TeachersFragment teachersFragment = new TeachersFragment(); //vytvoří fragment v layoutech - jakoby inicializace
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, teachersFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                    break;

                case R.id.btnSubjectKIKM:
                case R.id.btnSubjectKIT:
                case R.id.btnSubjectKAL:

                    //todo abych mel fragments s predmetama
                    SubjectsFragment subjectsFragment = new SubjectsFragment(); //vytvoří fragment v layoutech - jakoby inicializace

                    //posílá to údaje do fragmentu, může jich být kolik chce, putInt, putString - co je libo
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", view.getId());
                    subjectsFragment.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, subjectsFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                    break;


            }
        }else{
            //todo portrait spustit aktivitu
            //pustí danou aktivitu
            Intent intent = new Intent(this, DetailSectionActivity.class); //chceme pustit detailní aktivitu
            intent.putExtra("section", view.getId()); // pošlu si do detail section actiivy id, abych věděl jakej fragmet po stiskntí máme zobrazit
            //todo jaky fragment budu zobrazovat
            startActivity(intent); // tady začne
        }
    }
}
