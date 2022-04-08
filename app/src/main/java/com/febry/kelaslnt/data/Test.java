package com.febry.kelaslnt.data;

public class Test {
    private String text1;
    private String text2;
    private Integer integer;

    public Test(){

    }

    public Test(String text1, String text2, Integer integer){
        this.text1 = text1;
        this.text2 = text2;
        this.integer = integer;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
