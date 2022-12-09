package com.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseDecoder {
    private static Map<String, String> morseMap;

    public static Map<String, String> getMorseMap(){
        if (morseMap == null) {
            //TODO Finish feeling this bad boy up
            morseMap = new HashMap<>();
            morseMap.put("BCA", "a");
            morseMap.put("ACBCBCB", "b");
            morseMap.put("ACBCACB", "c");
            morseMap.put("ACBCB", "b");
            morseMap.put("B", "e");
            morseMap.put("BCBCACB", "f");
            morseMap.put("ACACB", "g");
            morseMap.put("BCBCBCB", "h");
            morseMap.put("BCB", "i");
            morseMap.put("BCACACA", "j");
            morseMap.put("ACBCA", "k");
            morseMap.put("BCACBCB", "l");
            morseMap.put("ACA", "m");
            morseMap.put("ACB", "n");
            morseMap.put("ACACA", "o");
            morseMap.put("BCACACB", "p");
            morseMap.put("ACACBCA", "q");
            morseMap.put("BCACB", "r");
            morseMap.put("BCBCB", "s");
            morseMap.put("A", "t");
            morseMap.put("BCBCA", "u");
            morseMap.put("BCBCBCA", "v");
            morseMap.put("BCACA", "w");
            morseMap.put("ACBCBCA", "x");
            morseMap.put("ACBCACA", "y");
            morseMap.put("ACACBCB", "z");
        }
        return morseMap;

    }

    public static String decode(List<Integer> stream) {
        //TODO Implement everything

        //detect on time
        List<Integer> on_time = new ArrayList<>();
        int zeroCount = 1;
        // remove first zero's
        int j = 0;
        if(stream.size()<3){
            return "0";
        }
        while (stream.get(j) == 0 && j<stream.size()-1) j++;
        Log.d("Ignore","," + j );
        //<- check
        while (j<stream.size()-1){
            zeroCount =0;
            if(stream.get(j) == 1){
                while ( j<stream.size()-1 && stream.get(j)!=-1){
                    j++;
                    zeroCount++;
                }
                on_time.add( zeroCount);
            } else {
                while (j<stream.size()-1 && stream.get(j)!=1){
                    j++;
                    zeroCount++;
                }
                on_time.add( zeroCount *-1);
            }
        }

        Log.d("on_time ",", " + on_time );


        //order by repetition
        Map<String, Integer> borders = getBorders(on_time);
        List<String> state = new ArrayList<>();

        int stateAToBBorder = borders.get("stateAToBBorder");
        int stateCToDBorder = borders.get("stateCToDBorder");
        int stateDToEBorder = borders.get("stateDToEBorder");
        Log.d("stateAToBBorder",", " + stateAToBBorder );
        Log.d("stateCToDBorder",", " + stateCToDBorder );
        Log.d("stateDToEBorder",", " + stateDToEBorder );
        for (int i = 0; i <on_time.size(); i++){
            if (on_time.get(i) >  stateAToBBorder ) {
                //state A
                state.add("A");
            } else if (on_time.get(i) <=  stateAToBBorder && on_time.get(i) > 0 ){
                //state B
                state.add("B");
            } else if (on_time.get(i) <= 0 && on_time.get(i) > stateCToDBorder ){
                //state C
                state.add("C");
            } else if (on_time.get(i) <= stateCToDBorder && on_time.get(i) > stateDToEBorder ){
                //state D
                state.add("D");
            } else {
                state.add("E");
                //state fault
            }
        }

        if ("CD".contains(state.get(state.size()-1))) {
            state.set(state.size()-1, "E");
        }


        Log.d("state ",", " + state );

        String text = "";
        List<String> letter = new ArrayList<>();
        int i = 0; //start reading at beginning
        for (i = 0; i < state.size()-1; i++){

            letter.clear();
            while (i < state.size()-1 && state.get(i) != "E" && state.get(i) != "D"){  //for each word
                letter.add(state.get(i));
                i++;
            }
            String S_letter = String.join("", letter);
            //TODO Changed to Map because switch/case only works with num or chars, not Strings and you just need to translate the value
            if(getMorseMap().containsKey(S_letter)){
                text += morseMap.get(S_letter);
            } else {
                text += "?";
            }
            if  (state.get(i) == "E" ) {
                text += " ";
            }
            Log.d("size", state.size()+"");
        }
        Log.d("text", text+"");
        return text.toString();
    }

    private static Map<String, Integer> getBorders(List<Integer> list) {
        Map<String, Integer> borderMap = new HashMap<>();
        List<Integer> copy = new ArrayList<>(list.size());
        copy.addAll(list);
        Collections.sort(copy);
        int cutIndex = 0;
        while (cutIndex < copy.size() && copy.get(cutIndex) < 0) {
            cutIndex++;
        }


        List<Integer> negativeValues = copy.subList(0, cutIndex);
        List<Integer> positiveValues = copy.subList(cutIndex, copy.size());
        //Shaving off 5% on each end, (1/20)
        Collections.sort(positiveValues);
        Collections.sort(negativeValues);
        positiveValues = positiveValues.subList(0, (int) (positiveValues.size()*0.95));
        negativeValues = negativeValues.subList( (int) (negativeValues.size()*0.05),negativeValues.size());



        borderMap.put("stateAToBBorder", getBorder(positiveValues));

        int border1 = getBorder(negativeValues);
        int border2 = getSecondBorder(negativeValues);
        /**
         if (border1 > border2) {
         borderMap.put("stateCToDBorder", getBorder(negativeValues));
         borderMap.put("stateDToEBorder", getSecondBorder(negativeValues));
         } else {
         borderMap.put("stateCToDBorder", getSecondBorder(negativeValues));
         borderMap.put("stateDToEBorder", getBorder(negativeValues));
         }
         **/
        //swap if order is wrong
        if (border1 < border2) {
            int borderTemp = border1;
            border1 = border2;  //DtoE
            border2 = borderTemp; //DtoE
        }
        //detect presence of multiple words
        //if CtoD is to close to DtoE (relative to C) then there is only one word, DtoE = 2x CtoD

        if(border1 - border2 > 0.5* border1) {

            // -2 therefor low frame rate have less need for critical accuracy.
            border2 = 2* border1 -2;
        }
        //store found values
        borderMap.put("stateCToDBorder", border1);
        borderMap.put("stateDToEBorder", border2);



        return borderMap;
    }
    private static Integer getBorder(List<Integer> list){
        int maxGap = 0;
        int border1 = 0;
        int border2 = 0;
        for (int i = 0; i < list.size() -1; i++) {
            int gap = list.get(i+1) - list.get(i);
            if (gap > maxGap) {
                maxGap = gap;
                border1 = list.get(i);
                border2 = list.get(i + 1);
            }
        }
        return (border1 + border2)/2;

    }

    private static Integer getSecondBorder(List<Integer> list){
        int secondMaxGap = 0;
        int maxGap = 0;
        int maxBorder1 = 0;
        int maxBorder2 = 0;
        int border1 = 0;
        int border2 = 0;
        for (int i = 0; i < list.size() -1; i++) {
            int gap = list.get(i +1) - list.get(i);
            if (gap > maxGap) {
                secondMaxGap = maxGap;
                maxGap = gap;
                border1 = maxBorder1;
                maxBorder1 = list.get(i);
                border2 = maxBorder2;
                maxBorder2 = list.get(i + 1);
            } else if (gap == maxGap) {
                secondMaxGap = gap;
                border1 = list.get(i);
                border2 = list.get(i + 1);
            } else if (gap > secondMaxGap) {
                secondMaxGap = gap;
                border1 = list.get(i);
                border2 = list.get(i + 1);

            }
        }
        return (border1+border2)/2;
    }

}
