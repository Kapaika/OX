package com.OX.app;

import java.util.Scanner;

/**
 * @author Bartosz Kupajski
 */
class TieChecker {

    boolean check(Sign[][] tabX0) {
        for (Sign[] tabSigns : tabX0) {
            for (Sign sign : tabSigns) {
                if (sign == Sign.N) {
                    return false;
                }
            }
        }
        return true;
    }

}
