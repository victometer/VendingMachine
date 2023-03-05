package Coin;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Coin {

    private CoinType coinType;

    public Coin(CoinType coinType){
        this.coinType = coinType;
    }

    public CoinType getCoinType() {
        return coinType;
    }
    public int getCoinValue(){
        return coinType.getValue();
    }

    public String toString(){
        return coinType.name();
    }
}
