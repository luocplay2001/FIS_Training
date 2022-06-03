package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void themDiem() {
    }

    @Test
    void tinhDiemTrungBinh() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(diem1);
        dsDiem.add(diem2);
        dsDiem.add(diem3);
        SinhVien sv = new SinhVien("ABC123","Nguyen Kien", dsDiem);

        double d = sv.tinhDiemTrungBinh();

        assertEquals(7.7,d,0.000000001);

    }

    @Test
    void bangDiem() {
    }

    @Test
    void xepLoai() {
    }

    @Test
    void testGetDiemByCondition() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),6);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),9);

        SinhVien sv = new SinhVien("123","Nguyen Van Kien");
        sv.themDiem(diem1);
        sv.themDiem(diem2);

        List<Diem> dsDiem = sv.getDiemByCondition(diem -> {
            return diem.getDiem() > 6 ? true : false;
        });

        System.out.println(dsDiem);

        dsDiem = sv.getDiemByCondition(SinhVien::dauPredicate);
        System.out.println(dsDiem);

        dsDiem = sv.getDiemByCondition(SinhVien::rotPredicate);
        System.out.println(dsDiem);
    }
}