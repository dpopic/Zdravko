package zdravko.tvz.hr.zdravko;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Filip on 24.4.2015..
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private String TAG ="DatabaseHelperClass";
    private static String DATABASE_NAME="Zdravko";
    private static int DATABASE_VERSION=1;
    private SQLiteDatabase mDataBase;
    //-------------------------TODO RIJEŠITI POZIV PREMA ourInstance, tj context (singletone)
    /*private static Context context;
    private static DatabaseHelper ourInstance = new DatabaseHelper(context);

    public static DatabaseHelper getInstance() {
        return ourInstance;
    }
    */

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }
    SQLiteDatabase db = getReadableDatabase();
    SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


    public Cursor getHospitalNames(){
        Log.d(TAG, "Čitanje iz tablice Bolnice");
        qb.setTables("Bolnice");
        String sql = "SELECT Naziv FROM Bolnice;";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        return c;
    }
    public Cursor getHospitalCities(){
        Log.d(TAG, "Čitanje iz tablice Bolnice");
        qb.setTables("Bolnice");
        String sql = "SELECT Mjesto FROM Bolnice;";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        return c;
    }

}
