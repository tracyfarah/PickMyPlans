package tracy.androidprojects.project2;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AllPlacesFragment extends Fragment {

    public AllPlacesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_all_places, container, false);
        Button btn1 = view.findViewById(R.id.button1);
        Button btn2 = view.findViewById(R.id.button2);
        Button btn3 = view.findViewById(R.id.button3);
        Button btn4 = view.findViewById(R.id.button4);
        Button btn5 = view.findViewById(R.id.button5);
        Button btn6 = view.findViewById(R.id.button6);
        Button btn7 = view.findViewById(R.id.button7);
        Button btn8 = view.findViewById(R.id.button8);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String table_name = "";
                if (v.getId() == R.id.button1)
                    table_name = "BEACH";
                else if (v.getId() == R.id.button2)
                    table_name = "BIKING";
                else if (v.getId() == R.id.button3)
                    table_name = "PARTY";
                else if (v.getId() == R.id.button4)
                    table_name = "HIKING";
                else if (v.getId() == R.id.button5)
                    table_name = "PICNIC";
                else if (v.getId() == R.id.button6)
                    table_name = "SKI";
                else if (v.getId() == R.id.button7)
                    table_name = "SUNSET";
                else if (v.getId() == R.id.button8)
                    table_name = "WATERFALL";
                 PlacesFragment placesFragment = new PlacesFragment();
                placesFragment.setTable_name(table_name);
                placesFragment.setQuestionActivity(false);
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.frame_container, placesFragment);
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);

        return view;
    }


}