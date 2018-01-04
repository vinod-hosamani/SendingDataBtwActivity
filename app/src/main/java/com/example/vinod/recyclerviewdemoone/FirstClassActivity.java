package com.example.vinod.recyclerviewdemoone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vinod on 12/12/17.
 */

public class FirstClassActivity extends AppCompatActivity {
    TextView fn;
    TextView ln;
    List<Model> modelList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    private void initView() {

        fn=(TextView)findViewById(R.id.firstName);
        ln=(TextView)findViewById(R.id.lastName);

       Model data=getIntent().getExtras().getParcelable("data");
       fn.setText(data.firstName);
       ln.setText(data.lastName);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
