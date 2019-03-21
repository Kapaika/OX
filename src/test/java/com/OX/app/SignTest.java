package com.OX.app;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class SignTest {

    public void testSignEquality(){
        Sign sign = Sign.O;
        Sign sign1 = Sign.O;
        Assert.assertEquals(sign,sign1);
    }

    public void testSignNoEquality(){
        Sign sign = Sign.O;
        Sign sign1 = Sign.X;
        Assert.assertNotEquals(sign,sign1);
    }
}
