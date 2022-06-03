package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Comparable<Diem>, Serializable {
    private MonHoc mon;
    private int diem;

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diem diem1 = (Diem) o;
        return diem == diem1.diem && Objects.equals(mon, diem1.mon);
    }

    @Override
    public int compareTo(Diem that) {
        if(this.diem > that.diem)
            return 1;
        else if(this.diem < that.diem)
            return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mon, diem);
    }

    @Override
    public Diem clone() {
        Diem diem = new Diem(this.mon, this.diem);
        return diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }

    public static int getDiemTong(Diem diem) {
        return diem.getDiem() * (diem.getMon().getTcLT() + diem.getMon().getTcTH());
    }

    public static int getSoTC(Diem diem) {
        return diem.getMon().getTcLT() + diem.getMon().getTcTH();
    }
}
