package com.util;

import android.util.Log;

import com.morsecode.MorseDecoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AnalyticQueue extends LinkedList<Float> {

    private int limit;
    private boolean isLimited = false;

    public AnalyticQueue(int limit) {

        this.limit = limit;
        this.isLimited = true;
    }

    public AnalyticQueue() {
        this.isLimited = false;
    }

    @Override
    public boolean add(Float o) {
        boolean added = super.add(o);
        while (isLimited && added && size() > limit) {
            super.remove();
        }
        return added;
    }

    public void analyze() {
        Float[] differences = new Float[size()];
        List<Integer> edges = new ArrayList<>(size());
        float avg = 0;
        //find average hue difference
        for (int i = 0; i<size() - 1; i++){
            differences[i] = get(i) - get(i +1);
            avg+= Math.abs(get(i) - get(i +1));
        }
        avg/= size();
        //detect rising and falling hue edges
        for (int i = 0; i<size() - 1; i++){
            if(Math.abs(differences[i]) > avg) {
                if (differences[i] < 0) {
                    edges.add(i, -1);
                } else {
                    edges.add(i, 1);
                }
            } else {
                edges.add(i, 0);
            }
        }


        //differentiate short and long.
        Log.d("edges ",", " + this );
        //Log.d("edges ",", " + edges );
        //Log.d("avg", " " + avg);
        Log.i("Text", " " + MorseDecoder.decode(edges));
    }

}