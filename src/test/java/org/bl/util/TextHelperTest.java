package org.bl.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextHelperTest {

    private TextHelper textHelper;

    @Before
    public void setUp() {

        textHelper = new TextHelper();
    }

    @Test
    public void parseText1() throws Exception {
        String text = "abd, abfjk, fg";
        int result = textHelper.parseText(text, 2);
        assertEquals(4, result);

    }

    @Test
    public void parseText2() throws Exception {
        String text = ", , ";
        int result = textHelper.parseText(text, 2);
        assertEquals(0, result);

    }

    @Test
    public void parseText3() throws Exception {
        String text = null;
        int result = textHelper.parseText(text, 2);
        assertEquals(0, result);

    }

    @Test
    public void parseText4() throws Exception {
        String text = "abd, abfjk, fg";
        int result = textHelper.parseText(text, -1);
        assertEquals(0, result);

    }

    @Test
    public void parseText5() throws Exception {
        String text = "Die Gefährten erzählt zunächst " +
                "die Vorgeschichte des sogenannten Einen Rings, der von dem Dunklen Herrscher Sauron geschmied" +
                "et wurde. Der Ring besitzt magische Kräfte und verleiht Sauron" +
                " große Macht. Trotzdem gelang es den freien Völkern Mittelerdes, Sauron zu bezwingen. " +
                "Isildur nahm den Einen Ring an sich, wurde aber durch einen Überfall von Orks getötet." +
                " Zweitausend Jahre später, als der Ring schon fast in Vergessenheit geraten war, fand ihn Smeagol," +
                " ein Halbling, der durch den Ring zur Kreatur Gollum wurde. Der Ring verfluchte das Leben der " +
                "Kreatur fünfhundert Jahre lang, bis er sich auf die Suche nach einem neuen Träger machte und so " +
                "dem Hobbit Bilbo Beutlin in die Hände fiel. Die eigentliche Handlung beginnt nun – 60 Jahre später" +
                " – im Auenland.";
        int result = textHelper.parseText(text, 3);
        assertEquals(6, result);
    }

    @After
    public void tearDown() {

        textHelper = null;
    }

}