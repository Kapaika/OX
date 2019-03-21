package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class LanguageTest {

    @Test
    public void testLanguageChange(){

        //Default language is Polish
        Language language = Language.getInstance();
        String wonPl = language.getString("won");
        language.changeLangugae();
        String wonEn = language.getString("won");

        Assert.assertNotEquals(wonEn,wonPl);
    }

    @Test
    public void testLanguageChangeTwice(){

        //Default language is Polish
        Language language = Language.getInstance();
        String wonPl = language.getString("won");
        language.changeLangugae();
        language.changeLangugae();
        String wonSecondPL = language.getString("won");

        Assert.assertEquals(wonSecondPL,wonPl);
    }
}
