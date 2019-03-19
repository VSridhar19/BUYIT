import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Sridhar on 18-04-2018.
 */

public class DatabaseAdmin extends SQLiteOpenHelper {
    public DatabaseAdmin(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String name,String price,byte[] images){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO ITEM VALUES(NULL,? ,? ,?)";
        SQLiteStatement statement =database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,price);
       statement.bindBlob(3, images);
        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
