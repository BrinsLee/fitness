package com.brins.fitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.race604.drawable.wave.WaveDrawable;

import static java.security.AccessController.getContext;
import static org.litepal.LitePalApplication.getContext;

public class mFragment2 extends Fragment {

    private ImageView imageView2;
    private WaveDrawable chromeWave;
    private TextView tv;
    final int INIT=4000;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_group,container,false);
        imageView2 =  view.findViewById(R.id.iv);
        tv=view.findViewById(R.id.text_count);
        tv.setText(String.format("%s步",INIT));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chromeWave = new WaveDrawable(getContext(), R.drawable.pink);
        imageView2.setImageDrawable(chromeWave);
        chromeWave.setWaveAmplitude(30);
        //chromeWave.setWaveLength(30);
        chromeWave.setWaveSpeed(20);
        chromeWave.setWaveLength(500);
        chromeWave.setLevel(INIT);

    }

    public mFragment2() {

    }
}
