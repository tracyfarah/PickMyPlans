package tracy.androidprojects.project2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultFragment extends Fragment {
    private String table_name;

    public ResultFragment() {
        // Required empty public constructor
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
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
            table_name = savedInstanceState.getString("table");
        }

        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView textViewTitle = view.findViewById(R.id.title_text_view);
        TextView textView = view.findViewById(R.id.result_text_view);
        ImageView imageView = view.findViewById(R.id.result_image_view);
        switch(table_name){
            case "HIKING":
                imageView.setImageResource(R.drawable.hiking);
                textView.setText(table_name);
                break;
            case "SKI":
                imageView.setImageResource(R.drawable.ski);
                textView.setText("SKIING");
                break;
            case "SUNSET":
                textViewTitle.setText("You should...");
                imageView.setImageResource(R.drawable.sunset);
                textView.setText("Watch the Sunset");
                break;
            case "PICNIC":
                textViewTitle.setText("You should...");
                imageView.setImageResource(R.drawable.picnic);
                textView.setText("Have a Picnic");
                break;
            case "BEACH":
                imageView.setImageResource(R.drawable.beach);
                textView.setText("To the Beach");
                break;
            case "PARTY":
                imageView.setImageResource(R.drawable.party);
                textView.setText(table_name);
                break;
            case "WATERFALL":
                imageView.setImageResource(R.drawable.waterfall);
                textView.setText("To a Waterfall");
                break;
            case "BIKING":
                imageView.setImageResource(R.drawable.biking);
                textView.setText(table_name);
                break;
        }
        Button button = view.findViewById(R.id.show_places_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacesFragment placesFragment = new PlacesFragment();
                placesFragment.setTable_name(table_name);
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.fragment_container, placesFragment);
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("table", table_name);
    }
}