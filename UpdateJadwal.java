package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateJadwal extends AppCompatActivity {

    protected Cursor cursor;
    Databasehelper dbcenter;
    Button btn1,btn2;
    EditText et1,et2,et3,et4,et5,et6,et7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_jadwal);

        dbcenter = new Databasehelper(this);
        et1 = (EditText)findViewById(R.id.et_no);
        et2 = (EditText)findViewById(R.id.et_nama);
        et3 = (EditText)findViewById(R.id.et_kelas);
        et4 = (EditText)findViewById(R.id.et_hari);
        et5 = (EditText)findViewById(R.id.et_jam);
        et6 = (EditText)findViewById(R.id.et_ruangan);
        et7 = (EditText)findViewById(R.id.et_dosen);
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tbjadwal WHERE no = '" +
                 getIntent().getStringExtra("no") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
            et3.setText(cursor.getString(2).toString());
            et4.setText(cursor.getString(3).toString());
            et5.setText(cursor.getString(4).toString());
            et6.setText(cursor.getString(5).toString());
            et7.setText(cursor.getString(6).toString());
        }
        btn1 = (Button)findViewById(R.id.btn_save);
        btn2 = (Button)findViewById(R.id.btn_back3);
        // buat event onclick pada button save
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("UPDATE tbjadwal SET no = '" +
                        et2.getText().toString() + "', nama='" +
                        et3.getText().toString() + "', kelas='" +
                        et4.getText().toString() + "', hari='" +
                        et5.getText().toString() + "', jam='" +
                        et6.getText().toString() + "', ruangan='" +
                        et7.getText().toString() + "' where dosen='" +
                        et1.getText().toString() +"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                MainActivity.ma.Refreshlist();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                finish();
            }
        });
    }
}
