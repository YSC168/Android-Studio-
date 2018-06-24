package com.webview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class Recycler extends AppCompatActivity {

    private RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recycler=findViewById(R.id.rv);
        recycler.setLayoutManager(new LinearLayoutManager(Recycler.this));
        recycler.addItemDecoration(new MyDecoration());
        recycler.setAdapter(new LinearAdapter(Recycler.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(Recycler.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));

    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.divider));
        }
    }
}
