package com.example.vinod.recyclerviewdemoone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chauthai.overscroll.RecyclerViewBouncy;

import java.util.ArrayList;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ItemRecycler.onItemClick, ItemRecycler.onLongClickItem {
    RecyclerViewBouncy recyclerView;
    ArrayList<Model> dataLogList;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {

        recyclerView = (RecyclerViewBouncy) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Model> androidVersions = prepareData();
        ItemRecycler adapter = new ItemRecycler(androidVersions, this, this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> prepareData() {
        //data declaration

       /* String [] t1={"vinod" ,"sachin","virendra","suresh" ,"hardik"};
        String [] t2={"hosamani" ,"tendulkar","sehwag","raina" ,"pandya"};
        *//*int[] img={R.drawable.ic_assignment_returned_black_24dp,R.drawable.ic_assignment_returned_black_24dp,
                R.drawable.ic_assignment_returned_black_24dp,R.drawable.ic_assignment_returned_black_24dp
                ,R.drawable.ic_assignment_returned_black_24dp
        }*//*;

        ArrayList<Model> modelArrayList = new ArrayList<>();
        for(int i=0;i<t1.length;i++)
        {

            Model model = new Model();
          //  model.images=img[i];
            model.firstName =t1[i];
            model.lastName =t2[i];
            modelArrayList.add(model);
        }
        return modelArrayList;*/


        //you can also declare like below

       dataLogList =new ArrayList<>();
        Model list;

        list=new Model();
        list.firstName="Vinod";
        list.lastName="hosamani";
        dataLogList.add(list);

        list=new Model();
        list.firstName="hardik";
        list.lastName="pandya";
        dataLogList.add(list);

        list=new Model();
        list.firstName="suresh";
        list.lastName="raina";
        dataLogList.add(list);

        list=new Model();
        list.firstName="sachin";
        list.lastName="tedulkar";
        dataLogList.add(list);

        return dataLogList;



        //another way of declaration(from server)

       /* String mockTransactionList = "[\n" +
                "\t{\n" +
                "\t\t\"firstName\": \"vinod\",\n" +
                "\t\t\"lastName\": \"hosamani\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"firstName\": \"hardik\",\n" +
                "\t\t\"lastName\": \"pandya\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"firstName\": \"virendra\",\n" +
                "\t\t\"lastName\": \"sehwag\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"firstName\": \"sachin\",\n" +
                "\t\t\"lastName\": \"tendulkar\"\n" +
                "\t}\n" +
                "]";

        Type type = new TypeToken<ArrayList<Model>>() {
        }.getType();

        return new Gson().fromJson(mockTransactionList, type);*/


    }


    @Override
    public void onClick(View v, int position)
    {
        Intent intent=new Intent(this,FirstClassActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("data", dataLogList.get(position));
        Log.d(TAG, "MyClass.getView() — get item number " + dataLogList +"pos   "+position);
        intent.putExtras(bundle);

        startActivity(intent);

    }


    @Override
    public void onLongClick(View v, int position) {
        Toast.makeText(this, "hi you clicked" + position + "", Toast.LENGTH_LONG).show();
    }
}
