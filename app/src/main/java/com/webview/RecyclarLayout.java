package com.webview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class RecyclarLayout extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclar_layout);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclarLayout.this));
        recyclerView.addItemDecoration(new MyDecoration());

        recyclerView.setAdapter(new RecycAdapter(RecyclarLayout.this, new RecycAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclarLayout.this,"click"+pos,Toast.LENGTH_SHORT).show();
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
