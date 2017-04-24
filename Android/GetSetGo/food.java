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

public class food extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_food);

        List<String> list = Arrays.asList(getResources().getStringArray(R.array.food_news)); // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.id_listView, list));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i;
        switch(position){
            case 0 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.food.com/recipe/crock-pot-chicken-with-black-beans-cream-cheese-8920"));
                startActivity(i);
                break;
            case 1 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thekitchn.com/things-are-looking-bad-for-bananas-226257"));
                startActivity(i);
                break;
            case 2 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.foodbeast.com/news/french-toast-taquitos/#ixiZQpCJgviBFqL8.99"));
                startActivity(i);
                break;
            case 3 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sciencedaily.com/releases/2015/11/151116181005.htm"));
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
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
