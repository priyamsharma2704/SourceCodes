package com.example.priyam.getsetgo;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class technology extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_technology);
        List<String> list = Arrays.asList(getResources().getStringArray(R.array.technology_news)); // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.id_listView, list));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i;
        switch(position){
            case 0 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.extremetech.com/computing/218650-adobe-upgrades-photoshop-premiere-pro-adds-stunning-fuse-cc-3d-character-creation-tool"));
                startActivity(i);
                break;
            case 1 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.com/news/technology-35004635"));
                startActivity(i);
                break;
            case 2 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.com/news/technology-35000011"));
                startActivity(i);
                break;
            case 3 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.com/news/technology-34943089"));
                startActivity(i);
                break;
            case 4 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.com/news/technology-26487218"));
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_technology, menu);
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
