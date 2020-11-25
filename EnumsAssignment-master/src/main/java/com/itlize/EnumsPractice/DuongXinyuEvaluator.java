package com.itlize.EnumsPractice;

class DuongXinyuEvaluator
{
    private static String name;

    DuongXinyuEvaluator(String input)
    {
        name=input;
    }

    public boolean isDuong() {
        if(name=="Duong")
            return true;
        else
            return false;
    }

    public boolean isXinyu() {
        if(name=="Xinyu")
            return true;
        else
            return false;
    }
}