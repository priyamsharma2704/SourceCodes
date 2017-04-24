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

public class trendingNews extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_trending_news);

        List<String> list = Arrays.asList(getResources().getStringArray(R.array.trending_news)); // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.id_listView, list));
    }


    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i;
        switch(position){
            case 0 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://news.yahoo.com/california-massacre-shooter-pledged-allegiance-isis-cnn-154413583.html"));
                startActivity(i);
                break;
            case 1 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=yViIi3gie2c"));
                startActivity(i);
                break;
            case 2 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sciencealert.com/a-new-start-up-wants-to-transfer-your-consciousness-to-an-artificial-body-so-you-can-live-forever"));
                startActivity(i);
                break;
            case 3 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.geekboy.co/programming/apple-makes-swift-open-source-for-developers/"));
                startActivity(i);
                break;
            case 4 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.peta.org.uk/blog/how-going-vegan-helps-stop-climate-change/?utm_campaign=03122015+-+Climate+Change+-+Post&utm_source=PETA+UK+Facebook&utm_medium=Promo"));
                startActivity(i);
                break;
            case 5 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.technologyreview.com/news/544081/for-cocaine-addicts-treatment-with-magnets-may-stop-craving/"));
                startActivity(i);
                break;
        }
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trending_news, menu);
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
