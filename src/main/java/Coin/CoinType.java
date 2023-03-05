package Coin;

import Coin.Coin;

public enum CoinType {
    ONEPENNY(1),
    TWOPENCE(2),
    FIVEPENCE(5),
    TENPENCE(10),
    TWENTYPENCE(20),
    FIFTYPENCE(50),
    ONEPOUND(100);

    private int value;

    CoinType (int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
