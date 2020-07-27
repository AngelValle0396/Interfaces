package com.example.interfaz_gmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TextView txtInfo;
    String ms="Redactar";
    Dialog dg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dg=new Dialog(this);
        FloatingActionButton fab = findViewById(R.id.float_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_INDEFINITE)
                 //       .setAction("Action", null).show();
            }
        });
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
         setSupportActionBar(toolbar);

         txtInfo=(TextView) findViewById(R.id.txtinfo);
         drawerLayout=  findViewById(R.id.draw_layout);
        NavigationView navigationView= (NavigationView)findViewById(R.id.navigation_draw);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.draw_open,  R.string.draw_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

    }

    public void onClick(View view) {

        dg.setContentView(R.layout.custompopup);
        /*TextView close=(TextView) findViewById(R.id.txt_closed);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dg.dismiss();
            }
        });*/
        dg.show();
    }




    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void close(View view){
        dg.dismiss();
    }
    public void message(View view){
        Toast.makeText(this.getApplicationContext(),"Ha presionado opción buscar",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String itemname= (String)menuItem.getTitle();
        if (menuItem.getItemId()!=R.id.item_a)
        txtInfo.setText(itemname);
        closeDrawer();
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.item_a:
                fragment = new principal_fragment();
                fragmentTransaction = true;
                break;
            case R.id.item_b:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.item_c:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();

                break;
            case R.id.itm_all:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_notf:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_bdsali:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_destacados:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_enviados:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_foros:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.itm_importantes:
                Toast.makeText(this.getApplicationContext(),"Ha presionado opción "+txtInfo.getText(),Toast.LENGTH_LONG).show();
                break;
        }
        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.draw_layout, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        closeDrawer();
            return true;
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    private void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer();
        }
        super.onBackPressed();
    }
}