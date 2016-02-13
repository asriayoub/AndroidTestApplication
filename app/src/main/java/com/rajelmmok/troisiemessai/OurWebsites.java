package com.rajelmmok.troisiemessai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class OurWebsites extends Activity {
    List<Website> ourWebsites = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_websites);

        initializeListOfWebsite();
        populateListView();
        onClickItem();
    }

    public void initializeListOfWebsite(){
        ourWebsites.add(new Website("gymglish", "www.gymglish.com", R.drawable.icon, "Description of the website.."));
        ourWebsites.add(new Website("frantastique", "www.frantastique.com", R.drawable.icon, "Description of the website.."));
        ourWebsites.add(new Website("vatefaireconjuguer", "www.vatefaireconjuguer.com", R.drawable.icon, "Description of the website.."));
        ourWebsites.add(new Website("richmorning", "www.richmorning.com", R.drawable.icon, "Description of the website.."));
    }

    public void populateListView(){
        ArrayAdapter<Website> adapter = new MyListAdapter();
        ListView listview = (ListView) findViewById(R.id.lvWebsites);
        listview.setAdapter(adapter);
    }

    private void onClickItem() {
        ListView list = (ListView) findViewById(R.id.lvWebsites);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Website clickedWebsite = ourWebsites.get(position);
                Intent intent = new Intent(OurWebsites.this, SelectedWebsite.class);
                intent.putExtra("domain", clickedWebsite.getDomain());
                startActivity(intent);
            }
        });
    }
    //My implemented Adapter List Class
    private class MyListAdapter extends ArrayAdapter<Website>{

        public MyListAdapter() {
            super(OurWebsites.this, R.layout.item_view, ourWebsites);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View itemView= convertView;

            if(itemView==null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            //find the Item
            Website current = ourWebsites.get(position);

            //fill it with information
            ImageView ivIcon=(ImageView)itemView.findViewById(R.id.ivIcon);
            ivIcon.setImageResource(current.getIcon());

            TextView tvName=(TextView) itemView.findViewById(R.id.tvName);
            tvName.setText(current.getName());

            TextView tvDescription=(TextView) itemView.findViewById(R.id.tvDescription);
            tvDescription.setText(current.getDescription());

            return itemView;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startActivity(new Intent(this, MainActivity.class));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_our_websites, menu);
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
