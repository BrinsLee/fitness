package com.brins.fitness;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import tyrantgit.explosionfield.ExplosionField;

public class Launcher extends AppCompatActivity {

    private SharedPreferences sp_info ;
    private SharedPreferences.Editor edit;
    //private ExplosionField mExplosionField;
    /*private RelativeLayout layout;
    ImageView imageView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp_info = getSharedPreferences("data", MODE_PRIVATE);
        /*ImageView lanuch=new ImageView(this);
        lanuch.setBackgroundResource(R.color.background);*/
        setContentView(R.layout.activity_launcher);
        //ButterKnife.bind(this);
        /*layout=findViewById(R.id.root);
        imageView=findViewById(R.id.image_launch);
        mExplosionField = ExplosionField.attach2Window(this);
        addListener(imageView);*/



        Timer show_time=new Timer();
        show_time.schedule(new TimerTask(){

            @Override
            public void run() {
                // TODO Auto-generated method stub

                //boolean isFirst = sp.getBoolean("isFirst", true);


                if (sp_info.getBoolean("first",true)&&sp_info.getInt("islogin",0)==0) {
                    edit = sp_info.edit();
                    edit.putBoolean("first", false);
                    edit.commit();
                    startActivity(new Intent(Launcher.this, Login.class));
                    finish();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {

                    startActivity(new Intent(Launcher.this, MainActivity.class));
                    finish();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }

            }



        }, 3500);


    }


    /*private void addListener(final View root) {

            //root.setClickable(true);

                    mExplosionField.explode(root);

                    //v.setOnClickListener(null);

                    //v.performClick();






    }*/
}
