package com.example.wordcounter;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TextMetricsUnitTest {


    @Test
    public void getWordsCountReturnsCorrectCount(){
        assertEquals(4,new TextMetrics().countWORDS("Word word word word"));
    }

    public void getWordsCountReturnsZeroForEmptyText(){
        assertEquals(4,new TextMetrics().countWORDS(""));
    }


    @Test
    public void getSentencesReturnsCorrectCount(){
        assertEquals(2,new TextMetrics().countSENTENCES("Abc. abc."));
    }

    @Test
    public void getNumbersReturnsCorrectCount(){
        assertEquals(3, new TextMetrics().countNUMBERS("12, 123 ab112"));
    }

    @Test
    public void getPunctuationReturnsCorrectCount(){
        assertEquals(3, new TextMetrics().countPUNCTUATION("Sentence. Big sentence!!"));
    }
}
