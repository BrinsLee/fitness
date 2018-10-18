package com.brins.fitness;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class mFwagment extends android.support.v4.app.Fragment {

    private Tip mytip;
    private List<Tip> myList=new ArrayList<>();
    String  [] tip=new String[]{"哦哦哦哦哦哦哦","2","3","4","5"};
    int [] tipImage={R.drawable.tip1,R.drawable.tip2,R.drawable.tip3,R.drawable.tip4,R.drawable.tip5};
    TextView textView;
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment,container,false);
        recyclerView=view.findViewById(R.id.recycle);
        return view;

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitList();
        AdapterRecycler adpter =new AdapterRecycler(myList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adpter);
        //linearLayoutManager.addView(new LinearLayout(getContext()));



    }

    private void InitList() {

        for (int i=0;i<tip.length;i++)
        {
            myList.add(new Tip(tip[i],tipImage[i]));
        }
    }
}
