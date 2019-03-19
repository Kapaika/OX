package com.OX.app;

import java.util.Random;

/**
 * @author Bartosz Kupajski
 */
class Player implements StateChangeInterface {

    Sign sign;
    private String name;

    Player(String name) {
        this.name = name;
    }

    void setSign(Sign sign) {
        this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }

    @Override
    public void setState() {
        Random random = new Random();
        sign = Sign.values()[random.nextInt(2)];
    }

    @Override
    public void changeState() {
        if(this.sign == Sign.X){
            this.sign=Sign.O;
        }else if(this.sign == Sign.O){
            this.sign =Sign.X;
        }
    }

}
