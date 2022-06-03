package com.example;

import java.util.*;
import java.util.function.Predicate;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }

    public SinhVien(String mssv, String ten, Set<Diem> monDaHoc) {
        this.mssv = mssv;
        this.ten = ten;
        this.monDaHoc = monDaHoc;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
//        double res = 0;
//        int count = 0;
//        for(Diem diem : monDaHoc) {
//            res += diem.getDiem() *
//                    (diem.getMon().getTcTH() + diem.getMon().getTcLT());
//            count += diem.getMon().getTcTH() + diem.getMon().getTcLT();
//        }

//        double res = monDaHoc.stream().mapToDouble(Diem::getDiemTong).sum();
        double res = monDaHoc.stream().mapToDouble(diem ->
                diem.getDiem() * (diem.getMon().getTcTH() + diem.getMon().getTcLT())).sum();
        int count = monDaHoc.stream().mapToInt(Diem::getSoTC).sum();
        return (double)res/count;
    }


    //TODO Cau 2
    public StringBuilder bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        StringBuilder str = new StringBuilder("");
        str.append("MSSV: " + mssv + "\n");
        str.append("Ten: " + ten + "\n");
        str.append("Danh Sach Diem \n");
        str.append("STT  Ten Mon             Diem       So Tin Chi \n");
        int count = 0;
        for(Diem diem : monDaHoc) {
            str.append(count++ + " " + diem.getMon().getTen()
                    + " " + diem.getDiem() + " " + (diem.getMon().getTcLT()
                    + diem.getMon().getTcTH() + "\n"
            ));
        }
        str.append("Diem Trung Binh " + tinhDiemTrungBinh() + "\n");
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(mssv, sinhVien.mssv) && Objects.equals(ten, sinhVien.ten) && Objects.equals(monDaHoc, sinhVien.monDaHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, ten, monDaHoc);
    }

    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        //...
        double diemTb = tinhDiemTrungBinh();
        if(diemTb >= 8) return "GIOI";
        else if(diemTb >= 7) return "KHA";
        else if(diemTb >= 6) return "TB-KHA";
        else if(diemTb >= 5) return "TB";
        return "YEU";
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                ", monDaHoc=" + monDaHoc +
                '}';
    }

    public  List<Diem> getDiemByCondition(Predicate<Diem> predicate) {
        List<Diem> dsDiem = new ArrayList<>();
        for(Diem diem : monDaHoc) {
            if(predicate.test(diem)) {
                dsDiem.add(diem);
            }
        }
        return dsDiem;
    }

    public static boolean dauPredicate(Diem diem) {
        return diem.getDiem() > 5 ? true : false;
    }

    public static boolean rotPredicate(Diem diem) {
        return diem.getDiem() < 5 ? true : false;
    }

    public boolean isGraduate() {
        return this.monDaHoc.stream()
                .allMatch(SinhVien::dauPredicate) ? true : false;
    }
}
