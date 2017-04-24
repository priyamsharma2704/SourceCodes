package com.example.priyam.udguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Pictures extends AppCompatActivity {

    public static final String ID_KEY = "RES_ID" , LBL_KEY = "LABEL"; // defining the id key  and label key to display the image and its title.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String res_label = extra.getString(LBL_KEY);  // getting the label key
            TextView Label = (TextView)findViewById(R.id.id_label); //
            Label.setText(res_label);  // printing the image label

            String Img_id = extra.getString(ID_KEY); // getting the image id
            int id = Integer.parseInt(Img_id);  // converting the id into int value
            ImageView disp = (ImageView)findViewById(R.id.id_pic);
            disp.setImageResource(id);  // displaying thr image
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pictures, menu);
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
