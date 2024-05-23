package com.example.week11_assignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
         mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);  // for general
        //    mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);  // for general, horizontal
        //  mLayoutManager = new GridLayoutManager(this,2);   //  Grid, (linear  cardview )
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter PaintTitle
        ArrayList<PaintTitle> myDataset = new ArrayList<PaintTitle>();

        // 아이템 추가
        myDataset.add(new PaintTitle(R.drawable.coke, "coke", "1,000", "콜라는 탄산음료로 청량감과 상쾌한 맛이 특징이며, 다양한 맛이 존재합니다. " +
                "설탕과 인공감미료 등이 많이 함유되어 있어 칼로리와 당 함량이 높고, 소화를 돕는 효과가 있지만 치아 건강에 좋지 않습니다. " +
                "카페인이 함유되어 있어 카페인에 민감한 사람은 주의해야 하며, 유통기한이 짧습니다."));
        myDataset.add(new PaintTitle(R.drawable.soda, "cider", "1,500","사이다는 탄산음료로 청량감과 상쾌한 맛이 특징이며," +
                " 레몬, 라임 등의 과일향이 첨가되어 상큼한 맛이 납니다. 설탕과 인공감미료 등이 많이 함유되어 있어 " +
                "칼로리와 당 함량이 높고, 소화를 돕는 효과가 있지만 치아 건강에 좋지 않습니다. 카페인이 함유되어 있지 않으며, " +
                "유통기한이 짧습니다."));
        myDataset.add(new PaintTitle(R.drawable.fanta, "fanta", "1,300", "환타는 탄산음료로 청량감과 상쾌한 맛이 특징이며, " +
                "오렌지, 포도, 사과 등 다양한 맛이 존재합니다. 설탕과 인공감미료 등이 많이 함유되어 있어 칼로리와 당 함량이 높고, " +
                "소화를 돕는 효과가 있지만 치아 건강에 좋지 않습니다. 카페인이 함유되어 있지 않으며, 유통기한이 짧습니다."));

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

}
