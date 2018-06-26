package com.example.mohitjindal.dukaan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemsList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText productSearch;
    ProductListAdapter adapter,mAdapter;
    ArrayList<ProductItem> productItems = new ArrayList<ProductItem>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new ProductListAdapter(this, generateData());
        listView = (ListView) findViewById(R.id.listView1);
        productSearch = findViewById(R.id.productSearch);
        listView.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        productSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                ItemsList.this.adapter.getFilter().filter(cs);
                int textlength = cs.length();
                ArrayList<ProductItem> tempArrayList = new ArrayList<ProductItem>();
                for(ProductItem c: productItems){
                    if (textlength <= c.getTitle().length()) {
                        if (c.getTitle().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                mAdapter = new ProductListAdapter(getApplicationContext(), tempArrayList);
                listView.setAdapter(mAdapter);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.items_list, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<ProductItem> generateData(){

        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));
        productItems.add(new ProductItem(R.drawable.masalanoodles,"Maggi Masala Noodles","Soupy Noodle s made from wheat","2"));


        return productItems;
    }
}
