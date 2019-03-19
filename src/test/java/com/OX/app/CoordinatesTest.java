package com.OX.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Bartosz Kupajski
 */
@Test
public class CoordinatesTest {

    @Test
    public void createCoordinates(){
        Coordinates coordinates = new Coordinates(3,3);

        assert coordinates.x==3:"Wrong coordinates implementation";
        assert coordinates.y==3:"Wrong coordinates implementation";
    }

}
