package com.example.hyejin.mokgongso_stack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.itangqi.waveloadingview.WaveLoadingView;

/**
 * Created by Mirim on 2018-05-29.
 */

public class MainViewActivity extends AppCompatActivity {
    Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    WaveLoadingView waveLoadingView;
    TextView Achievement;
    ImageView logo_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainview);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        waveLoadingView = (WaveLoadingView)findViewById(R.id.waveLoadingView_main);
        Achievement = (TextView)findViewById(R.id.Achievement);

        waveLoadingView.setProgressValue(50);

        Achievement.setText(Achievement.getText() + " " + waveLoadingView.getProgressValue()+"%");

        logo_btn = (ImageView)findViewById(R.id.logo_btn);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);

        logo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainViewActivity.this, MainViewActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hamburger_menu, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                Intent intent = new Intent(MainViewActivity.this, HamburgerActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_left);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
