package com.example.hyejin.mokgongso_stack;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import me.itangqi.waveloadingview.WaveLoadingView;

/**
 * Created by Mirim on 2018-05-29.
 */

public class HamburgerActivity extends AppCompatActivity {
    Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    WaveLoadingView waveLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburger);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

       // waveLoadingView = (WaveLoadingView)findViewById(R.id.waveLoadingView);
       // waveLoadingView.setProgressValue(60);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        NavigationView view = (NavigationView) findViewById(R.id.navigation_view_main);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                //mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger_header, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.close_btn) {
            finish();
            overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_in_right);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
