package tracy.androidprojects.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity implements QuestionFragment.QuestionInterface {
    private int question = 0;
    private final Category[] array = {new Category("HIKING"),
            new Category("SKI"),
            new Category("SUNSET"),
            new Category("PICNIC"),
            new Category("BEACH"),
            new Category("PARTY"),
            new Category("WATERFALL"),
            new Category("BIKING")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Find a Place");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        QuestionFragment questionFragment = new QuestionFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, questionFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void nextQuestion() {
        question++;
        if (question > 4) {
            String table_name = calculateResult();
            resetValues();
            ResultFragment resultFragment = new ResultFragment();
            resultFragment.setTable_name(table_name);
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.replace(R.id.fragment_container, resultFragment);
            ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft2.addToBackStack(null);
            ft2.commit();

        } else {
            QuestionFragment questionFragment = new QuestionFragment();
            questionFragment.setQuestion_number(question);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, questionFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }

    @Override
    public void changeValue(int i, int v) {
        int j = array[i].getValue();
        array[i].setValue(j + v);
    }

    public String calculateResult(){
        ArrayList<Integer> a = new ArrayList<>();
        int max = array[0].getValue();
        for(int i=1; i<array.length; i++) { //find place(s) with the largest value
            if (array[i].getValue() > max) {
                max = array[i].getValue();
            }
        }
        for(int i=0; i<array.length; i++){ //add all places with same score to an array list
            if(array[i].getValue()==max)
                a.add(i);
        }
        if(a.size()==1) { //if only one place has highest value, return it
            return array[a.get(0)].getName();
        }else{ //if many places have the same value return a random one of these
            Random rand = new Random(a.size());
            int r = rand.nextInt(a.size());
            return array[a.get(r)].getName();
        }
    }

    public void resetValues(){
        for(int i=0; i<array.length; i++){
            array[i].setValue(0);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}