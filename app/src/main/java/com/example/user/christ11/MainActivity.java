package com.example.user.christ11;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.tv);

        dbHelper = new MyDBHelper(this,"iii",null,1);
        db = dbHelper.getReadableDatabase();
    }
    public void insert(View v){
        // INSERT INTO cust (cname,birthday,tel) VALUES ('Brad','1999-09-08','123');
        ContentValues data = new ContentValues();
        data.put("cname","Cindy");
        data.put("birthday","1994-11-13");
        data.put("tel","666");
        db.insert("cust",null,data);
        query(null);
        Toast.makeText(this,"新增完成",Toast.LENGTH_SHORT).show();
    }
    public void delete (View v){
        // DELETE FROM cust WHERE id = 3 AND cname = 'Brad'
        db.delete("cust","id = ? AND cname = ?", new String[]{"3","Christ"});
        query(null);
        Toast.makeText(this,"刪除完成",Toast.LENGTH_SHORT).show();
    }
    public void update(View v){
        ContentValues data = new ContentValues();
        data.put("cname","Peter");
        data.put("birthday","1993-12-24");
        data.put("tel","888");
        db.update("cust",data,"id = ?", new String[]{"4"});
        query(null);
    }
    public void query(View V){
        textView.setText("");
        // SELECT * FROM cust ORDER BY cname DESC
        // db.execSQL("SELECT * FROM cust");
        Cursor cursor = db.query("cust",null,"id >?",new String[]{"2"},
                null,null,"cname DESC, birthday DESC");

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String cname = cursor.getString(cursor.getColumnIndex("cname"));
            String birthday = cursor.getString(cursor.getColumnIndex("birthday"));
            String tel = cursor.getString(cursor.getColumnIndex("tel"));
            textView.append(id + ":" + cname + ":" + birthday +":" +tel+"\n");
            Log.v("brad","OK");
        }
    }
}
