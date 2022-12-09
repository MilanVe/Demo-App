package com.morsecode;

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
        for (int i = stream.size()-1; i >=0; i--){ // all elements but the last
            if (stream.get(i) == 0) {
                zeroCount++;
            } else {
                on_time.add(0,zeroCount*stream.get(i));
                zeroCount = 1;
            }
        }


        //order by repetition

        Map<String, Integer> borders = getBorders(on_time);
        List<String> state = new ArrayList<>();
        for (int i = 0; i <on_time.size(); i++){
            if (on_time.get(i) < borders.get("stateAToBBorder")*2
                    && on_time.get(i) >  borders.get("stateAToBBorder") ) {
                //state A
                state.add("A");
            } else if (on_time.get(i) <=  borders.get("stateAToBBorder") && on_time.get(i) > 0 ){
                //state B
                state.add("B");
            } else if (on_time.get(i) <= 0 && on_time.get(i) > borders.get("stateCToDBorder") ){
                //state C
                state.add("C");
            } else if (on_time.get(i) <= borders.get("stateCToDBorder") && on_time.get(i) > borders.get("stateDToEBorder") ){
                //state D
                state.add("D");
            } else if (on_time.get(i) <= borders.get("stateDToEBorder") && on_time.get(i) > 2*borders.get("stateDToEBorder") ){
                //state E
                state.add("E");
            } else {
                state.add("E");
                //state fault
            }
        }


        String text = "";
        List<String> letter = new ArrayList<>();
        int i = 0; //start reading at beginning
        for (i = 0; i < state.size(); i++){

           if  (state.get(i) == "E" ){
               text +=" ";
           } else {
               letter.clear();
               while (i < state.size() && state.get(i) != "E" && state.get(i) != "D"){  //for each word
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
           }
        }

        return text;
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
        //Shaving off 5% on each end, (1/20)
        List<Integer> negativeValues = copy.subList(0, cutIndex);
        List<Integer> positiveValues = copy.subList(cutIndex, copy.size());
        borderMap.put("stateAToBBorder", getBorder(positiveValues));

        int border1 = getBorder(negativeValues);
        int border2 = getSecondBorder(negativeValues);
        if (border1 > border2) {
            borderMap.put("stateCToDBorder", getBorder(negativeValues));
            borderMap.put("stateDToEBorder", getSecondBorder(negativeValues));
        } else {
            borderMap.put("stateCToDBorder", getSecondBorder(negativeValues));
            borderMap.put("stateDToEBorder", getBorder(negativeValues));
        }



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
