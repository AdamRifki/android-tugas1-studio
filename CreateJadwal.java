package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateJadwal extends AppCompatActivity {

    protected Cursor cursor;
    Databasehelper dbcenter;
    Button btn1,btn2;
    EditText et1,et2,et3,et4,et5,et6,et7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_jadwal);

        dbcenter = new Databasehelper(this);
        et1 = (EditText)findViewById(R.id.et_no);
        et2 = (EditText)findViewById(R.id.et_nama);
        et3 = (EditText)findViewById(R.id.et_kelas);
        et4 = (EditText)findViewById(R.id.et_hari);
        et5 = (EditText)findViewById(R.id.et_jam);
        et6 = (EditText)findViewById(R.id.et_ruangan);
        et7 = (EditText)findViewById(R.id.et_dosen);
        btn1 = (Button)findViewById(R.id.btn_add);
        btn2 = (Button)findViewById(R.id.btn_back);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("INSERT INTO tbjadwal(no, namamk, kelas, hari, jam, ruangan, namadosen) VALUES('" +
                            et1.getText().toString() + "','" +
                            et2.getText().toString() + "','" +
                            et3.getText().toString() + "','" +
                            et4.getText().toString() + "','" +
                            et5.getText().toString() + "','" +
                            et6.getText().toString() + "','" +
                            et7.getText().toString() + "');");
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
