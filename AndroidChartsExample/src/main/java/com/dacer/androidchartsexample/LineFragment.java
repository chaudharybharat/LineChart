package com.dacer.androidchartsexample;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import im.dacer.androidcharts.LineView;
import java.util.ArrayList;

/**
 * Created by Dacer on 11/15/13.
 */
public class LineFragment extends Fragment implements View.OnClickListener {
    int randomint = 31;

     LineView lineView;
     LineView lineViewFloat;
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_line, container, false);
         Button tv_lineViewFloatyear = (Button) rootView.findViewById(R.id.tv_year);
         Button tv_month = (Button) rootView.findViewById(R.id.tv_month);
         Button tv_week = (Button) rootView.findViewById(R.id.tv_week);
         Button tv_year = (Button) rootView.findViewById(R.id.tv_year);
        tv_year.setOnClickListener(this);
        tv_month.setOnClickListener(this);
        tv_week.setOnClickListener(this);
        lineView = (LineView) rootView.findViewById(R.id.line_view);
        lineViewFloat= (LineView) rootView.findViewById(R.id.line_view_float);

        initLineView(lineView);
        initLineView(lineViewFloat);
        Button lineButton = (Button) rootView.findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) {
                        randomSet();
            }
        });
        randomSet();
        return rootView;
    }

    private void initLineView(LineView lineView) {
        ArrayList<String> test = new ArrayList<String>();
        for (int i = 0; i < randomint; i++) {
            test.add(String.valueOf(i + 1));
        }
        lineView.setBottomTextList(test);
        lineView.setColorArray(new int[] {
                Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                Color.parseColor("#2196F3"), Color.parseColor("#009688")
        });
        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);
    }
    private void randomSet() {
        ArrayList<Integer> dataList = new ArrayList<>();
        float random = (float) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList.add((int) (Math.random() * random));
         /*   if(i>10){
            }else {
                dataList.add((int) 0);
            }*/
        }
        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
        dataLists.add(dataList);
       // dataLists.add(dataList2);
       // dataLists.add(dataList3);
        lineView.setDataList(dataLists);

        ArrayList<Float> dataListF = new ArrayList<>();
        float randomF = (float) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF.add((float) (Math.random() * randomF));
        }

        ArrayList<Float> dataListF2 = new ArrayList<>();
        randomF = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF2.add((float) (Math.random() * randomF));
        }

        ArrayList<Float> dataListF3 = new ArrayList<>();
        randomF = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF3.add((float) (Math.random() * randomF));
        }

        ArrayList<ArrayList<Float>> dataListFs = new ArrayList<>();
        dataListFs.add(dataListF);
        dataListFs.add(dataListF2);
        dataListFs.add(dataListF3);

        lineViewFloat.setFloatDataList(dataListFs);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_week:
                randomint=7;
                initLineView(lineView);
                randomSet();
                break;
            case R.id.tv_month:
                randomint=31;
                initLineView(lineView);
                randomSet();
                break;
            case R.id.tv_year:
                randomint=12;
                initLineView(lineView);
                randomSet();
                break;

        }
    }
}