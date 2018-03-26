package cz.uhk.fim.brahavl1.fragmentsmallapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailSectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_section);

        //todo tady nam příšlo z put extra z activity main parametr daneho buttonu, takže víme jakej intent bychom měli zobrazit
        int section = getIntent().getIntExtra("section", 0);

        switch (section) { //v section je kod danyho tlačítka
            case R.id.btnExams:
                ExamsFragment examsFragment = new ExamsFragment(); //vytvoří fragment v layoutech - jakoby inicializace
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, examsFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                break;

            case R.id.btnTeachers:
                TeachersFragment teachersFragment = new TeachersFragment(); //vytvoří fragment v layoutech - jakoby inicializace
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, teachersFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                break;

            case R.id.btnSettings:
                SettingsFragment settingsFragment = new SettingsFragment(); //vytvoří fragment v layoutech - jakoby inicializace
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, settingsFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                break;

            case R.id.btnSubjectKIKM:
            case R.id.btnSubjectKIT:
            case R.id.btnSubjectKAL:

                //todo abych mel fragments s predmetama
                SubjectsFragment subjectsFragment = new SubjectsFragment(); //vytvoří fragment v layoutech - jakoby inicializace

                //posílá to údaje do fragmentu, může jich být kolik chce, putInt, putString - co je libo
                Bundle bundle = new Bundle();
                bundle.putInt("type", section);
                subjectsFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, subjectsFragment).commit(); //přidá do fragment layoutu v main activitě v layoutech
                break;


        }
    }
}
