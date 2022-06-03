package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void testEquals() {
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("CTDL",3,1),8);

        assertTrue(diem1.equals(diem3));
    }

    @Test
    void compareTo() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testClone() {
        Diem diem = new Diem(new MonHoc("OOP",3,1),8);
//        assertEquals(1, "OOP",);
    }


    @Test
    void testCompareTo() {
    }

    @Test
    void testHashCode1() {
    }

    @Test
    void testClone1() {
    }

    @Test
    void getMon() {
    }

    @Test
    void setMon() {
    }

    @Test
    void getDiem() {
    }

    @Test
    void setDiem() {
    }

    @Test
    void testWithCollection() {
        List<Diem> danhSachDiem = new ArrayList<>();
        Diem diem1 = new Diem(new MonHoc("CTDL",3,1),8);
        Diem diem2 = new Diem(new MonHoc("OOP",2,1),7);
        Diem diem3 = new Diem(new MonHoc("Anh Văn",2,1),8);
        danhSachDiem.add(diem1);
        danhSachDiem.add(diem2);
        danhSachDiem.add(diem3);

        Collections.sort(danhSachDiem);
        System.out.println(danhSachDiem);

        Collections.sort(danhSachDiem, (o1,o2) ->
        {
            if(o1.getDiem() > o2.getDiem())
                return 1;
            else if(o1.getDiem() < o2.getDiem()) {
                return -1;
            } else {
                if(o1.getMon().getTen().compareTo(o2.getMon().getTen()) > 0)
                    return 1;
                else if(o1.getMon().getTen().compareTo(o2.getMon().getTen()) < 0)
                    return -1;
                return 0;
            }
        });
        System.out.println(danhSachDiem);
    }
}