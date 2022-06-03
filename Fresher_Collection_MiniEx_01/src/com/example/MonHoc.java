package com.example;

import java.util.Objects;

public class MonHoc implements Comparable<MonHoc>{
    private String ten;
    private int tcLT;
    private int tcTH;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public void setTcLT(int tcLT) {
        this.tcLT = tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    public void setTcTH(int tcTH) {
        this.tcTH = tcTH;
    }

    public MonHoc(String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHoc monHoc = (MonHoc) o;
        return tcLT == monHoc.tcLT && tcTH == monHoc.tcTH && Objects.equals(ten, monHoc.ten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tcLT, tcTH);
    }

    @Override
    public int compareTo(MonHoc that) {
        if(this.ten.compareTo(that.ten) > 0)
            return 1;
        else if(this.ten.compareTo(that.ten) < 0)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                '}';
    }

    public void printMonHoc() {
        System.out.println(this.toString());
    }

    public static boolean tcLTgreaterThan2(MonHoc monHoc) {
        return monHoc.getTcLT() > 2 ? true : false;
    }
}
