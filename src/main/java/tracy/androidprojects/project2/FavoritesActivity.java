package tracy.androidprojects.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static tracy.androidprojects.project2.R.layout.activity_favorites;

public class FavoritesActivity extends AppCompatActivity  {
    String[] placesNames;
    String[] placesDescriptions;
    int[] placesImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_favorites);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Saved Places");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        RecyclerView recyclerView = findViewById(R.id.favorites_recycler_view);
        try {
            PlacesSQLiteOpenHelper quizSQLiteOpenHelper = new PlacesSQLiteOpenHelper(this);
            SQLiteDatabase db = quizSQLiteOpenHelper.getWritableDatabase();
            int count = (int) DatabaseUtils.queryNumEntries(db, "FAVORITES");
            if(count==0){
                Toast.makeText(this, "You don't have saved places.", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                placesNames = new String[count];
                placesDescriptions = new String[count];
                placesImages = new int[count];
                for (int i = 0; i < count; i++) {
                    TextView textView = new TextView(this);
                    TextView textViewDesc = new TextView(this);
                    ImageView imageView = new ImageView(this);
                    Cursor cursor = db.query("FAVORITES",
                            new String[]{"NAME", "LOCATION", "IMAGE_RESOURCE_ID"},
                            "_id = ?", new String[]{Integer.toString(i + 1)},
                            null, null, null);
                    if (cursor.moveToFirst()) {
                        placesNames[i] = cursor.getString(0);
                        placesDescriptions[i] = cursor.getString(1);
                        placesImages[i] = cursor.getInt(2);
                    }
                }
                CaptionedImagesAdapter captionedImagesAdapter = new CaptionedImagesAdapter(placesNames, placesDescriptions, placesImages, null);
                recyclerView.setAdapter(captionedImagesAdapter);
                db.close();
            }
        } catch (Exception e) {
            Toast.makeText(this, "You don't have saved places.", Toast.LENGTH_SHORT).show();
            finish();
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}