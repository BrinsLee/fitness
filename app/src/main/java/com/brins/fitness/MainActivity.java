package com.brins.fitness;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigation)
    NavigationView navigationView;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.viewpaper)
    ViewPager viewPager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        final ActionBar ab=getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        if (navigationView != null)
        {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    item.setChecked(true);

                    return false;
                }
            });
        }
        initViewpaper();

    }



    private void initViewpaper() {

        /*tabLayout.addTab(TabLayout.newTab().setText("主页"));
        tabLayout.addTab(TabLayout.newTab().setText("目标"));*/
        final CharSequence r;
        String [] title=new String[] {"主页","目标"};
        List<Fragment> list=new ArrayList<>();
        list.add(new mFragment2());
        list.add(new mFwagment());
        ViewPaperAdapter viewPaperAdapter=new ViewPaperAdapter(getSupportFragmentManager());
        for ( int i=0;i<title.length;i++) {
            viewPaperAdapter.AddFragment(list.get(i),title[i]);
        }

        r = viewPaperAdapter.getPageTitle(0);
        viewPager.setAdapter(viewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(r);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.add_target:
                //打开添加目标页面
                break;
            case R.id.info:
                //打开身体信息页面
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
