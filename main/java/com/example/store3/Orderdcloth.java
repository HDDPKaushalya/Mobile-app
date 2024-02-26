package com.example.store3;

public class Orderdcloth {
    String colored;
    String sized;
    int totalprice;

    public Orderdcloth(String colored,String sized,int totalprice) {
        this.colored = colored;
        this.sized = sized;
        this.totalprice = totalprice;

    }
    public String getColored(){
        return colored;
    }
    public String getSized(){
        return sized;
    }
    public int getTotalprice(){
        return  totalprice;
    }





}
