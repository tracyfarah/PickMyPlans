package tracy.androidprojects.project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlacesSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_project2";
    private static final int DB_VERSION = 1;

    public PlacesSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE FAVORITES(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        db.execSQL("CREATE TABLE HIKING(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db,"HIKING","Horsh Ehden Nature Reserve", "Ehden, North Lebanon", R.drawable.ehden);
        insertPlace(db, "HIKING","Mseilha Walkway", "Batroun, Lebanon", R.drawable.mseilha);
        insertPlace(db, "HIKING","Tannourine Cedars Reserve", "Tannourine, North Lebanon", R.drawable.tannourine);
        insertPlace(db, "HIKING","Qannoubine Valley", "Bsharri, North Lebanon", R.drawable.qannoubine);
        insertPlace(db, "HIKING","Baskinta Literary Trail", "Baskinta, Mount Lebanon", R.drawable.baskinta);
        db.execSQL("CREATE TABLE SUNSET(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "SUNSET", "The Broad", "Byblos, Mount Lebanon", R.drawable.thebroad);
        insertPlace(db, "SUNSET", "The Terrace", "Harissa, Jounieh Highway", R.drawable.terrace);
        insertPlace(db, "SUNSET", "Bolero", "Batroun, North Lebanon", R.drawable.bolero);
        insertPlace(db, "SUNSET", "The Bevview", "Qanat Bakish, Mount Lebanon", R.drawable.bevview);
        insertPlace(db, "SUNSET", "Odin Mzaar", "Kfardebian, Mount Lebanon", R.drawable.odin);
        db.execSQL("CREATE TABLE SKI(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "SKI", "Cedars Ski Resort", "Bsharri, North Lebanon", R.drawable.cedars);
        insertPlace(db, "SKI", "Mzaar Ski Resort", "Kfardebian, Mount Lebanon", R.drawable.mzaar);
        insertPlace(db, "SKI", "Zaarour Club", "Zaarour, Mount Lebanon", R.drawable.zaarour);
        insertPlace(db, "SKI", "Qanat Bakish", "Faqra, Mount Lebanon", R.drawable.bakish);
        insertPlace(db, "SKI", "Laqlouq Ski Resort", "Byblos, Mount Lebanon", R.drawable.laqlouq);
        db.execSQL("CREATE TABLE PICNIC(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "PICNIC", "Swings", "Mar Moussa, Mount Lebanon", R.drawable.swings);
        insertPlace(db, "PICNIC", "Arsoun Village", "Baabda, Mount Lebanon", R.drawable.arsoun);
        insertPlace(db, "PICNIC", "Pine Yards", "Mar Moussa, Mount Lebanon", R.drawable.pineyards);
        insertPlace(db, "PICNIC", "Tannourine Picnic Park", "Tannourine, North Lebanon", R.drawable.tannourine);
        insertPlace(db, "PICNIC", "HillHout Village", "Khenchara, Mount Lebanon", R.drawable.hillhout);
        db.execSQL("CREATE TABLE BEACH(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "BEACH", "Nowhere Beach", "Chekka, North Lebanon", R.drawable.nowhere);
        insertPlace(db, "BEACH", "Loco Beach Resort", "Batroun, North Lebanon", R.drawable.loco);
        insertPlace(db, "BEACH", "Taht El Rih", "Anfeh, North Lebanon", R.drawable.anfeh);
        insertPlace(db, "BEACH", "Jungle Beach", "Amchit, Mount Lebanon", R.drawable.junglebeach);
        insertPlace(db, "BEACH", "Ayla Beach", "Byblos, Mount Lebanon", R.drawable.ayla);
        db.execSQL("CREATE TABLE PARTY(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "PARTY", "Quadrangle", "Baabda, Mount Lebanon", R.drawable.quadrangle);
        insertPlace(db, "PARTY", "O1NE", "Beirut Waterfront, Beirut, Lebanon", R.drawable.oine);
        insertPlace(db, "PARTY", "Grand Factory", "Beirut, Lebanon", R.drawable.factory);
        insertPlace(db, "PARTY", "AHM", "Beirut Waterfront, Lebanon", R.drawable.ahm);
        insertPlace(db, "PARTY", "The Gärten", "Beirut, Lebanon", R.drawable.garten);
        db.execSQL("CREATE TABLE WATERFALL(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "WATERFALL", "Kfarhelda Waterfall", "Batroun, North Lebanon", R.drawable.kfarhelda);
        insertPlace(db, "WATERFALL", "Balouu Balaa", "Tannourine, North Lebanon", R.drawable.balouubalaa);
        insertPlace(db, "WATERFALL", "Afqa Waterfall", "Qartaba, Mount Lebanon", R.drawable.afqa);
        insertPlace(db, "WATERFALL", "Yahchouch Waterfall", "Keserwan, Mount Lebanon", R.drawable.yahchouch);
        insertPlace(db, "WATERFALL", "Baakline Waterfall", "Chouf, Mount Lebanon", R.drawable.baakline);
        db.execSQL("CREATE TABLE BIKING(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "LOCATION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER)");
        insertPlace(db, "BIKING", "Beirut by Bike", "Beirut Waterfront, Lebanon", R.drawable.bbb);
        insertPlace(db, "BIKING", "Batroun Bike Rental", "Batroun, North Lebanon", R.drawable.batrounbike);
        insertPlace(db, "BIKING", "Marina Club", "Dbayeh, Mount Lebanon", R.drawable.marina);
        insertPlace(db, "BIKING", "Zaytouna Bay", "Beirut, Lebanon", R.drawable.zaytouna);
        insertPlace(db, "BIKING", "Byblos By Bike", "Jbeil Old Souk, Byblos, Mount Lebanon", R.drawable.byblosbike);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertPlace(SQLiteDatabase db, String table, String name, String location, int imageId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("LOCATION", location);
        contentValues.put("IMAGE_RESOURCE_ID", imageId);
        db.insert(table, null, contentValues);
    }
}


