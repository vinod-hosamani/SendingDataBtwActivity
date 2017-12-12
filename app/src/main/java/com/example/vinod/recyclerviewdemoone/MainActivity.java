package com.example.vinod.recyclerviewdemoone;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemRecycler.onItemClick {
    RecyclerView recyclerView;
    ArrayList<Model> a;
    String [] t1={"one" ,"two","three","four" ,"five"};
    String [] t2={"six" ,"seven","eight","nine" ,"ten"};
    int[] img={R.drawable.ic_assignment_returned_black_24dp,R.drawable.ic_assignment_returned_black_24dp,
            R.drawable.ic_assignment_returned_black_24dp,R.drawable.ic_assignment_returned_black_24dp
            ,R.drawable.ic_assignment_returned_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView()
    {
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Model> androidVersions = prepareData();
        ItemRecycler adapter = new ItemRecycler(androidVersions,this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> prepareData()
    {
        ArrayList<Model> android_version = new ArrayList<>();
        for(int i=0;i<t1.length;i++){

            Model androidVersion = new Model();

           androidVersion.setImages(img[i]);
           androidVersion.setText1(t1[i]);
           androidVersion.setText2(t2[i]);

            android_version.add(androidVersion);
        }
        return android_version;
    }


    @Override
    public void onClick(View v, int position)
    {
      if(position==0)
      {
          Intent intent = new Intent(this, FirstClassActivity.class);
          startActivity(intent);
          finish();
      }
      if(position==1)
      {
          Intent intent = new Intent(this, SecondClassActivity.class);
          startActivity(intent);
          finish();
      }

    }
}
