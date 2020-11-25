package com.itlize.EnumsPractice;

public enum  DuongXinyuEnum {
    Duong,
    Xinyu;

    public String getCatchPhrase() {
        if(this.equals(Duong))
            return "Hey, my name is Duong!";
        else
            return "Hey, my name is Xinyu!";
    }

    public boolean isDuong() {
        if(this.equals(Duong))
            return true;
        else
            return false;
    }

    public boolean isXinyu() {
        if(this.equals(Xinyu))
            return true;
        else
            return false;
    }
}

class Duong
{
    public static String name() {
        return "Duong";
    }
}

class Xinyu
{
    public static String name() {
        return "Xinyu";
    }

}