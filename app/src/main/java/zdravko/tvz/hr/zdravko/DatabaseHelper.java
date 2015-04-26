package zdravko.tvz.hr.zdravko;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Filip on 24.4.2015..
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static String DATABASE_NAME="Zdravko";
    private static int DATABASE_VERSION=1;
    private SQLiteDatabase mDataBase;
    //-------------------------TODO RIJEŠITI POZIV PREMA ourInstance, tj context
    private static Context context;
    private static DatabaseHelper ourInstance = new DatabaseHelper(context);

    public static DatabaseHelper getInstance() {
        return ourInstance;
    }


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }
}
