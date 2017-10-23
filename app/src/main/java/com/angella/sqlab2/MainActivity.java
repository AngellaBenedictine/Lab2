package com.angella.sqlab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert:", "Inserting..");
        db.addUnit(new Unit("Ethics", "active"));
        db.addUnit(new Unit("Mobile_Application_Development", "active"));
        db.addUnit(new Unit("Operations_research", "active"));
        db.addUnit(new Unit("Artificial_Intelligence", "active"));

        Log.d("Reading:", "Reading all units...");
        List<Unit> unit = db.getAllUnit();

        for (Unit cn : unit) {
            String log = "Id:" + cn.getID() + ",Name:" + cn.getName() + " ,info: " + cn.get_info();
            Log.d("Name:", log);
        }
        Log.d("Insert:", "Inserting..");
        db.addLecturer(new Lecturer("C.Momanyi"));
        db.addLecturer(new Lecturer("A,khajira"));
        db.addLecturer(new Lecturer("C.Ouma"));
        db.addLecturer(new Lecturer("W.Muchiri"));

        Log.d("Reading:", "Reading all Lecturers...");
        List<Lecturer> lecturer = db.getAllLecturer();

        for (Lecturer cn : lecturer) {
            String log = "Id:" + cn.getLecId() + ",Name:" + cn.getLecName();
            Log.d("Name:", log);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
