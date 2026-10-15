package com.example.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMetrics {
    private static final String SENTENCES   = "[^.!?\\s][^.!?]*(?:[.!?]+|$)";
    private static final String WORDS       = "\\S+";
    private static final String PUNCTUATION = "\\p{Punct}";
    private static final String NUMBERS     = "\\d+";
//    chatgptd this

    public int countSENTENCES(String text) {
        String trim = text.trim();

        if (trim.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(SENTENCES).matcher(trim);

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;

    }

    public int countPUNCTUATION(String text){
        int count = 0;

        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);

            if (character == ' ' || character == ',' || character == '.') {
                count++;
            }
        }

        return count;
    }

    public int countNUMBERS(String text){
        Matcher matcher = Pattern.compile(NUMBERS).matcher(text);

        int count = 0;

        while(matcher.find()) {
            count ++;
        }

        return count;
    }

    public int countWORDS(String text){
        String trim = text.trim();
        if (trim.isEmpty()){
            return 0;
        }
        return trim.split(WORDS).length;
    }

}
