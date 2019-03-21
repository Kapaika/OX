package com.OX.app;

import java.util.Random;

/**
 * @author Bartosz Kupajski
 */
class Player{

    Sign sign;
    String name;
    int score;

    Player(String name) {
        this.name = name;
    }

    void setSign(Sign sign) {
        this.sign = sign;
    }

    boolean isWinner(){
        return this.score >= 6;
    }

    public Sign getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
