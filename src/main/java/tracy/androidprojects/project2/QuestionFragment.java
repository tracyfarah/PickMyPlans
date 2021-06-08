package tracy.androidprojects.project2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuestionFragment extends Fragment {
    private int question_number = 0;
    int num;
    String[] people = {"How many people?", "1 Person", "Couple", "Friend Group", "Family"};
    String[] age = {"What age group?", "Kids", "Teenagers", "Young Adult", "Adults"};
    String[] seasons = {"Which season?", "Winter", "Fall", "Spring", "Summer"};
    String[] budget = {"What is your budget?", "Minimal", "A little", "Normal", "No Budget"};
    String[] mood = {"What is your mood?", "Relax and Chill", "Adventure", "Casual", "Have Fun"};
    private QuestionInterface questionInterface;

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }

    String[][] arrays = {people, age, seasons, mood, budget};
    int[][] imageID = {{R.drawable.person, R.drawable.couple, R.drawable.friends, R.drawable.family},
            {R.drawable.kids, R.drawable.teens, R.drawable.youngadult, R.drawable.adults},
            {R.drawable.winter, R.drawable.fall, R.drawable.spring, R.drawable.summer},
            {R.drawable.relax, R.drawable.adventure, R.drawable.casual, R.drawable.party_btn},
            {R.drawable.money1, R.drawable.money2, R.drawable.money3, R.drawable.money4}};


    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null){
            question_number = savedInstanceState.getInt("quest_num");
        }
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.questionInterface = (QuestionInterface) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        num = question_number;
        View view = getView();
        TextView textView = view.findViewById(R.id.title_text_view);
        Button btn1 = view.findViewById(R.id.top_left_button);
        Button btn2 = view.findViewById(R.id.top_right_button);
        Button btn3 = view.findViewById(R.id.bottom_left_button);
        Button btn4 = view.findViewById(R.id.bottom_right_button);
        String[] question_array = arrays[num];
        Drawable topDrawable1 = getResources().getDrawable(imageID[num][0]);
        Drawable topDrawable2 = getResources().getDrawable(imageID[num][1]);
        Drawable topDrawable3 = getResources().getDrawable(imageID[num][2]);
        Drawable topDrawable4 = getResources().getDrawable(imageID[num][3]);
        textView.setText(question_array[0]);
        btn1.setText(question_array[1]);
        btn2.setText(question_array[2]);
        btn3.setText(question_array[3]);
        btn4.setText(question_array[4]);
        btn1.setCompoundDrawablesWithIntrinsicBounds(null, topDrawable1, null, null);
        btn2.setCompoundDrawablesWithIntrinsicBounds(null, topDrawable2, null, null);
        btn3.setCompoundDrawablesWithIntrinsicBounds(null, topDrawable3, null, null);
        btn4.setCompoundDrawablesWithIntrinsicBounds(null, topDrawable4, null, null);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              switch (question_number) {
                    case 0:
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 1:
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 2:
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3, -1);
                        questionInterface.changeValue(4, -2);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6, -1);
                        break;
                    case 3:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        break;
                    case 4:
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                }
                questionInterface.nextQuestion();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (question_number) {
                    case 0:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 1:
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 2:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 3:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 4:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        break;
                }
                questionInterface.nextQuestion();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch (question_number) {
                    case 0:
                        for (int i = 0; i < 8; i++)
                            questionInterface.changeValue(i,1);
                        break;
                    case 1:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 2:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1, -1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 3:
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(6,1);
                        break;
                    case 4:
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(7,1);
                        break;
                }
                questionInterface.nextQuestion();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (question_number) {
                    case 0:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 1:
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        break;
                    case 2:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1, -1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 3:
                        questionInterface.changeValue(0,1);
                        questionInterface.changeValue(1,1);
                        questionInterface.changeValue(2,1);
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                    case 4:
                        questionInterface.changeValue(3,1);
                        questionInterface.changeValue(4,1);
                        questionInterface.changeValue(5,1);
                        questionInterface.changeValue(6,1);
                        questionInterface.changeValue(7,1);
                        break;
                }
                questionInterface.nextQuestion();
            }
        });
    }
    interface QuestionInterface {
        void nextQuestion();
        void changeValue(int i, int v);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("quest_num", num);
    }
}