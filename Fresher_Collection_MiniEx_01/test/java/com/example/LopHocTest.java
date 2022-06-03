package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void them() {
    }

    @Test
    void inDiem() {
    }

    @Test
    void top10() {
    }

    @Test
    void sinhVienYeu() {
    }

    @Test
    void testThem() {
    }

    @Test
    void testInDiem() {
    }

    @Test
    void testTop10() {

        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(diem1);
        dsDiem.add(diem2);
        dsDiem.add(diem3);
        SinhVien sv = new SinhVien("ABC123","Nguyen Kien", dsDiem);

        Diem diem4 = new Diem(new MonHoc("CTDL",3,1),9);
        Diem diem5 = new Diem(new MonHoc("OOP",2,1),3);
        Diem diem6 = new Diem(new MonHoc("Anh Văn",2,1),2);
        Set<Diem> dsDiem1 = new HashSet<>();
        dsDiem1.add(diem4);
        dsDiem1.add(diem5);
        dsDiem1.add(diem6);
        SinhVien sv1 = new SinhVien("ABC124","Nguyen Thao", dsDiem1);

        List<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        LopHoc lopHoc = new LopHoc("A1","Nam",listSinhVien);

        List<SinhVien> sinhViens = lopHoc.top10();
        assertEquals(10,sinhViens.size());
    }

    @Test
    void testSinhVienYeu() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(diem1);
        dsDiem.add(diem2);
        dsDiem.add(diem3);
        SinhVien sv = new SinhVien("ABC123","Nguyen Kien", dsDiem);

        Diem diem4 = new Diem(new MonHoc("CTDL",3,1),2);
        Diem diem5 = new Diem(new MonHoc("OOP",2,1),3);
        Diem diem6 = new Diem(new MonHoc("Anh Văn",2,1),2);
        Set<Diem> dsDiem1 = new HashSet<>();
        dsDiem1.add(diem4);
        dsDiem1.add(diem5);
        dsDiem1.add(diem6);
        SinhVien sv1 = new SinhVien("ABC124","Nguyen Thao", dsDiem1);

        List<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        listSinhVien.add(sv1);
        LopHoc lopHoc = new LopHoc("A1","Nam",listSinhVien);

        List<SinhVien> sinhViens = lopHoc.sinhVienYeu();
        assertEquals(8,sinhViens.size());
    }
}