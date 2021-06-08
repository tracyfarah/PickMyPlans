package tracy.androidprojects.project2;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class PlacesFragment extends Fragment implements CaptionedImagesAdapter.OnPlaceListener {
    private String table_name = "";
    private boolean questionActivity = true;

    public void setQuestionActivity(boolean questionActivity) {
        this.questionActivity = questionActivity;
    }

    public PlacesFragment() {
        // Required empty public constructor
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (questionActivity)
            ((QuestionActivity) getActivity()).setActionBarTitle(table_name);
        else {
            ((ViewAllActivity) getActivity()).setActionBarTitle(table_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null){
            table_name = savedInstanceState.getString("table");
            questionActivity = savedInstanceState.getBoolean("activity");
        }

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_places, container, false);

        try {
            PlacesSQLiteOpenHelper quizSQLiteOpenHelper = new PlacesSQLiteOpenHelper(getContext());
            SQLiteDatabase db = quizSQLiteOpenHelper.getReadableDatabase();
            int count = (int) DatabaseUtils.queryNumEntries(db, String.valueOf(table_name));
            String[] placesNames = new String[count];
            String[] placesDescriptions = new String[count];
            int[] placesImages = new int[count];
            for (int i = 0; i < count; i++) {
                Cursor cursor = db.query(String.valueOf(table_name),
                        new String[]{"NAME", "LOCATION", "IMAGE_RESOURCE_ID"},
                        "_id = ?", new String[]{Integer.toString(i + 1)},
                        null, null, null);
                if (cursor.moveToFirst()) {
                    placesNames[i] = cursor.getString(0);
                    placesDescriptions[i] = "Location: " + cursor.getString(1);
                    placesImages[i] = cursor.getInt(2);
                }
            }
            CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(placesNames, placesDescriptions, placesImages, this);
            recyclerView.setAdapter(captionedImagesAdapter);
            db.close();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Database is not available", Toast.LENGTH_SHORT).show();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }

    @Override
    public void onPlaceClick(int position) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setPosition(position);
        detailFragment.setTable_name(table_name);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (questionActivity) {
            ft.replace(R.id.fragment_container, detailFragment);
        } else {
            ft.replace(R.id.frame_container, detailFragment);
        }
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("table", table_name);
        outState.putBoolean("activity", questionActivity);
    }
}