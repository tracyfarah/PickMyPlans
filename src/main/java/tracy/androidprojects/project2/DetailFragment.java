package tracy.androidprojects.project2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment {
    private int position;
    private int imageId;
    private String nameText, descriptionText;
    private String table_name;

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public DetailFragment() {
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
            table_name = savedInstanceState.getString("table");
            position = savedInstanceState.getInt("position");
        }

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView imageView = view.findViewById(R.id.detail_image);
        TextView textViewName = view.findViewById(R.id.detail_text_view);
        TextView textViewDesc = view.findViewById(R.id.detail_desc_text_view);
        Button buttonFav = view.findViewById(R.id.favorites_button);
        Button buttonRating = view.findViewById(R.id.rating_button);
        RatingBar ratingBar = view.findViewById(R.id.rating_bar);
        Button buttonSubmit = view.findViewById(R.id.submit_rating_button);

        try {
            PlacesSQLiteOpenHelper quizSQLiteOpenHelper = new PlacesSQLiteOpenHelper(getContext());
            SQLiteDatabase db = quizSQLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query(String.valueOf(table_name),
                    new String[]{"NAME", "LOCATION", "IMAGE_RESOURCE_ID"},
                    "_id = ?", new String[]{Integer.toString(position + 1)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                nameText = cursor.getString(0);
                textViewName.setText(nameText);
                descriptionText = "Location : " + cursor.getString(1) ;
                textViewDesc.setText(descriptionText);
                imageId = cursor.getInt(2);
                imageView.setImageResource(imageId);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Database is not available", Toast.LENGTH_SHORT).show();
        }

        buttonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                PlacesSQLiteOpenHelper quizSQLiteOpenHelper = new PlacesSQLiteOpenHelper(getContext());
                SQLiteDatabase db = quizSQLiteOpenHelper.getReadableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("NAME", String.valueOf(nameText));
                contentValues.put("LOCATION", String.valueOf(descriptionText));
                contentValues.put("IMAGE_RESOURCE_ID", imageId);
                db.insert("FAVORITES", null, contentValues);
                Toast.makeText(getContext(), "Added to Favorites!", Toast.LENGTH_SHORT).show();
                buttonFav.setText(R.string.added_fav_btn);
                buttonFav.setOnClickListener(null);
                buttonFav.setClickable(false);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Database not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        try {
            PlacesSQLiteOpenHelper quizSQLiteOpenHelper = new PlacesSQLiteOpenHelper(getContext());
            SQLiteDatabase db = quizSQLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("FAVORITES",
                    null,
                    "NAME = ?",
                    new String[]{String.valueOf(nameText)},
                    null, null, null);
            if(cursor.getCount()>0){
                buttonFav.setText(R.string.added_fav_btn);
                buttonFav.setOnClickListener(null);
                buttonFav.setClickable(false);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Database not available", Toast.LENGTH_SHORT).show();
        }

        buttonRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar.setVisibility(View.VISIBLE);
                buttonSubmit.setVisibility(View.VISIBLE);
                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = String.valueOf(ratingBar.getRating());
                        Toast.makeText(getContext(), "You rated this place " + s + " stars", Toast.LENGTH_SHORT).show();
                        ratingBar.setVisibility(View.INVISIBLE);
                        buttonSubmit.setVisibility(View.INVISIBLE);
                        buttonRating.setText(R.string.change_rating_btn);
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("table", table_name);
        outState.putInt("position", position);
    }
}