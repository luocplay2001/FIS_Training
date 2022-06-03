package com.example;

import java.util.*;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public LopHoc(String ten, String giaoVien, List<SinhVien> dsLop) {
        this.ten = ten;
        this.giaoVien = giaoVien;
        this.dsLop = dsLop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public StringBuilder inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        //...

        StringBuilder str = new StringBuilder("");
        str.append("Danh Sach Diem Lop: " + ten + "\n");
        str.append("Giao Vien Chu Nhiem: " + giaoVien + "\n");
        str.append("STT      MSSV        Ten              Diem TB   XepLoai\n");
        int count = 1;
        for(SinhVien sv : dsLop) {
            str.append(count++ + " " + sv.getMssv() + " " +
                    sv.getTen() + " " + sv.tinhDiemTrungBinh() + " " + sv.xepLoai() +"\n");
        }
        return str;
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        List<SinhVien> listSinhVien = dsLop;

        Collections.sort(listSinhVien, Comparator.comparingDouble(SinhVien::tinhDiemTrungBinh));
//        Collections.sort(listSinhVien, ((o1, o2) -> {
//            if(o1.tinhDiemTrungBinh() > o2.tinhDiemTrungBinh())
//                return -1;
//            else if(o1.tinhDiemTrungBinh() < o2.tinhDiemTrungBinh())
//                return 1;
//            return 0;
//        }));
        listSinhVien = listSinhVien.subList(listSinhVien.size() - 10, listSinhVien.size()).stream().toList();
        return listSinhVien;
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        List<SinhVien> listSinhVien =
                dsLop.stream().filter(sinhVien -> {
                    return sinhVien.xepLoai().equals("YEU") ? true : false;
                }).toList();

        return listSinhVien;
    }
}
