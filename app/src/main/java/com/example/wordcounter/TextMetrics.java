package com.example.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextMetrics {
    private static String Sentences = "\\."; // chatgptd this
    private static String words = "\\s+";
    private static String Punctuation = "[ ,. ]";
    private static String Numbers = "\\d+";

    public int countSentences(String text) {
        String trim = text.trim();

        if (trim.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(Sentences).matcher(trim);

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;

    }

    public int countPunctuation(String text){
        int count = 0;

        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);

            if (character == ' ' || character == ',' || character == '.') {
                count++;
            }
        }

        return count;
    }

    public int countNumbers(String text){
        Matcher matcher = Pattern.compile(Numbers).matcher(text);

        int count = 0;

        while(matcher.find()) {
            count ++;
        }

        return count;
    }

}
