package com.morsecode;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseDecoderTest extends TestCase {

    public void testEncode() {
        //BCBCBD BCBCAD ACBCACBD ACBCACBD BD BCBCBD BCBCBE
        String success =  "BCBCBDBCBCADACBCACBDACBCACBDBDBCBCBDBCBCBE";
        String sos = "BCBCBDACACADBCBCBE";
        //BCAD ACBCBCBD ACBCACBD ACBCBD BD BCBCACBD ACACBD BCBCBCBD //A->H
        //BCBD BCACACAD ACBCAD BCACBCBD ACADACBD ACACAD BCACACBD ACACBCAD E   // I->Q
        //BCACBD BCBCBD AD E // R->T
        //BCBCAD BCBCBCAD BCACAD ACBCBCAD ACBCACAD ACACBCBD E// U->Z
        String alphabet =  "BCADACBCBCBDACBCACBDACBCBDBDBCBCACBDACACBDBCBCBCBDBCBDBCACACADACBCADBCACBCBDACADACBDACACADBCACACBDACACBCADBCACBDBCBCBDADBCBCADBCBCBCADBCACADACBCBCADACBCACADACACBCBD";
        assertEquals("success", MorseDecoder.decode(test_on_time(alphabet)));
    }



    private List<Integer> test_on_time(String morseState) {

        List<Integer> msg = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < morseState.length(); i++)
        {
            char c = morseState.charAt(i);
            int scale = 5;
            int code = 0;
            switch(c) {
                case 'A':
                    code = 2*scale-(scale/3) + (int)(Math.random() * 2*(scale/3));
                    break;
                case 'B':
                    code = 1*scale-(scale/3) + (int)(Math.random() * 2*(scale/3));

                    break;
                case 'C':
                    code = -1*scale-(scale/3) + (int)(Math.random() * 2*(scale/3));
                    break;
                case 'D':
                    code = -2*scale-(scale/3) + (int)(Math.random() * 2*(scale/3));
                    break;
                case 'E':
                    code = -3*scale-(scale/3) + (int)(Math.random() * 2*(scale/3));
                    break;

            }
            msg.add(code);
        }
        for(int i = 0; i < msg.size(); i++){
            if (msg.get(i) > 0 ){
                output.add(1);
            } else {
                output.add(-1);
            }
            for(int j = 0; j < Math.abs(msg.get(i))-1; j++){
                output.add(0);
            }
        }


        System.out.println(output.size());
        return output;
    }

}