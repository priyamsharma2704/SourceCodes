package com.example.priyam.udguide;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Picture;
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

public class PhotoAlbum extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> album = Arrays.asList(getResources().getStringArray(R.array.album)); // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_photo_album, R.id.id_album, album)); // Putting it in the layout of picture album
    } //end of onCreate

    protected void onListItemClick(ListView l,View v,int position,long id){
        Intent intent;
        switch (position) {
            case 0: intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.campus)); // displaying the title of the image
                intent.putExtra(Pictures.ID_KEY,Integer.toString(R.drawable.campus));  // displaying the image
                startActivity(intent);
                break;
            case 1 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.library));
                intent.putExtra(Pictures.ID_KEY,Integer.toString(R.drawable.library));
                startActivity(intent);
                break;
            case 2 :intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.recplex));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.recplex));
                startActivity(intent);
                break;
            case 3 :  intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.arena));
                intent.putExtra(Pictures.ID_KEY,Integer.toString(R.drawable.udarena));
                startActivity(intent);
                break;
            case 4 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.ku));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.ku));
                startActivity(intent);
                break;
            case 5 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.marycrest));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.marycrest));
                startActivity(intent);
                break;
            case 6 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.vwk));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.vwk));
                startActivity(intent);
                break;
            case 7 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.football_field));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.football_field));
                startActivity(intent);
                break;
            case 8 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.ball_room));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.ball_room));
                startActivity(intent);
                break;
            case 9 : intent = new Intent(PhotoAlbum.this,Pictures.class);
                intent.putExtra(Pictures.LBL_KEY,getResources().getString(R.string.theater));
                intent.putExtra(Pictures.ID_KEY, Integer.toString(R.drawable.theater));
                startActivity(intent);
                break;


        }
    } // end of onListItemClick

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photo_album, menu);
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
