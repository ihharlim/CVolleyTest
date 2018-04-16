package com.example.win.cvolleytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {

    Intent itn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        if (mi.getItemId() == R.id.menu2) {
            itn = new Intent(this, MainActivity.class);
            startActivity(itn);
        }
        return super.onOptionsItemSelected(mi);
    }
}
