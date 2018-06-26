package com.example.mohitjindal.dukaan;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PastOrders extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    EditText inputSearch;
    MyAdapter adapter,mAdapter;
    ArrayList<Model> models = new ArrayList<Model>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter = new MyAdapter(this, generateData());
        listView = (ListView) findViewById(R.id.pastOrdersList);
        inputSearch = findViewById(R.id.search_pastOrders);
        listView.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                PastOrders.this.adapter.getFilter().filter(cs);
                int textlength = cs.length();
                ArrayList<Model> tempArrayList = new ArrayList<Model>();
                for(Model c: models){
                    if (textlength <= c.getTitle().length()) {
                        if (c.getTitle().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                mAdapter = new MyAdapter(getApplicationContext(), tempArrayList);
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

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

        if (id == R.id.addProduct) {
            // Handle the camera action
            Intent intent;
            intent = new Intent(getApplicationContext(), AddProduct.class);
            startActivity(intent);
        } else if (id == R.id.deleteProduct) {
            Intent intent;
            intent = new Intent(getApplicationContext(), DeleteProduct.class);
            startActivity(intent);
        } else if (id == R.id.updateProduct) {
            Intent intent;
            intent = new Intent(getApplicationContext(), AddProduct.class);
            startActivity(intent);
        } else if (id == R.id.pastOrders) {
            Intent intent;
            intent = new Intent(getApplicationContext(), PastOrders.class);
            startActivity(intent);
        } else if (id == R.id.myProfile) {
            Intent intent;
            intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            Intent intent;
            intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    private ArrayList<Model> generateData(){

        models.add(new Model(R.drawable.masalanoodles,"Menu Item 1",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 2",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 3",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 1",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 2",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 3",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 1",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 2",R.drawable.if_ic_delete_48px_352303));
        models.add(new Model(R.drawable.masalanoodles,"Menu Item 3",R.drawable.if_ic_delete_48px_352303));

        return models;
    }
}
