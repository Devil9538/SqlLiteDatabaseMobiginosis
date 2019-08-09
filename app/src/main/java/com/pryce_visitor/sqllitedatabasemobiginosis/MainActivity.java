package com.pryce_visitor.sqllitedatabasemobiginosis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import com.pryce_visitor.sqllitedatabasemobiginosis.database.DatabaseHelper;
import com.pryce_visitor.sqllitedatabasemobiginosis.note.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn_save, btn_read;
   DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_save = findViewById(R.id.btn_save);
        btn_read = findViewById(R.id.btn_read);
        editText = findViewById(R.id.edtInput);

        db= new DatabaseHelper(getApplicationContext());

        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_save:
                callSaveData();
                break;

            case R.id.btn_read:
                callReadData();
                break;
        }

    }

    private void callReadData() {

        List<Note> data = db.readData();

        for (int i=0;i<data.size();i++)
        {
            Log.d("Id : ",String.valueOf(data.get(i).getId()));
            Log.d("Name : ",data.get(i).getData());
            Log.d("TimeStamp : ",data.get(i).getTimestamp());
        }

    }

    private void callSaveData() {

        // Note note=new Note();

        db.saveData(editText.getText().toString());
    }
}
