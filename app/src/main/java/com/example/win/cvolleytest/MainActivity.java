package com.example.win.cvolleytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button butt1;
    EditText et1;
    Context ctx;
    Intent itn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = getApplicationContext();

        et1 = (EditText) findViewById(R.id.et1);
        butt1 = (Button) findViewById(R.id.butt1);

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CVolleyTest(ctx).write(et1.getText().toString());
            }
        });
    }

    //create the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        if (mi.getItemId() == R.id.menu1) {
            itn = new Intent(this, Main2Activity.class);
            startActivity(itn);
        }
        return super.onOptionsItemSelected(mi);
    }
}
