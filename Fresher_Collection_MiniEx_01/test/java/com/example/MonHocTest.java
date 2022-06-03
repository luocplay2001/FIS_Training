package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void testEquals() {
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("CTDL",3,1);

        assertTrue(monHoc1.equals(monHoc2));
        MonHoc monHoc3 = new MonHoc("Cấu trúc dữ liệu",3,1);
        assertFalse(monHoc1.equals(monHoc3));

    }

    @Test
    void getTen() {
        MonHoc monHoc = new MonHoc("CTDL",3,1);
        assertEquals("CTDL",monHoc.getTen());
        assertNotEquals("Cấu trúc dữ liệu",monHoc.getTen());
    }

    @Test
    void setTen() {
    }

    @Test
    void getTcLT() {
    }

    @Test
    void setTcLT() {
    }

    @Test
    void getTcTH() {
    }

    @Test
    void setTcTH() {
    }

    @Test
    void testEquals1() {
    }

    @Test
    void testWithCollection() {
        List<MonHoc> danhSachMonHoc = new ArrayList<>();

        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);

        danhSachMonHoc.add(monHoc1);
        danhSachMonHoc.add(monHoc2);
        MonHoc monHoc3 = new MonHoc("CTDL",3,1);
        assertEquals(0,danhSachMonHoc.indexOf(monHoc1));
        assertEquals(0,danhSachMonHoc.indexOf(monHoc3));

        Collections.sort(danhSachMonHoc);
        System.out.println(danhSachMonHoc);


        Collections.sort(danhSachMonHoc, (o1, o2) ->
        {
            if (o1.getTcLT() > o2.getTcLT())
                 return -1;
            else if (o1.getTcLT() < o2.getTcLT())
                  return 1;
            return 0;
        });
        System.out.println(danhSachMonHoc);
    }

    @Test
    void testWithSet() {
        Set<MonHoc> monHocSet = new HashSet<>();
        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);

        monHocSet.add(monHoc1);
        monHocSet.add(monHoc2);
        MonHoc monHoc3 = new MonHoc("CTDL",3,1);
        monHocSet.add(monHoc3);

        assertEquals(2, monHocSet.size());

    }

    @Test
    void testLambdaCollection() {
        List<MonHoc> danhSachMonHoc = createDanhSachMonHoc();
//        List<MonHoc> dsMonHoc = getMonHocs(danhSachMonHoc);
//        System.out.println(dsMonHoc);

        danhSachMonHoc.stream().map(new Function<MonHoc, Diem>() {
            @Override
            public Diem apply(MonHoc monHoc) {
                Diem diem = new Diem(monHoc, (int)(Math.random() * 10));
                return diem;
            }
        }).forEach(diem -> System.out.println(diem));

        danhSachMonHoc.stream().map(functionMap)
                .forEach(diem -> System.out.println(diem));
    }

    private final Function<MonHoc,Diem> functionMap = monHoc -> {
        Diem diem = new Diem(monHoc, (int)(Math.random() * 10));
        return diem;
    };

    List<MonHoc> getMonHocs(List<MonHoc> danhSachMonHoc) {
        List<MonHoc> dsMonHoc = danhSachMonHoc.stream().filter(monHoc -> {
            return monHoc.getTcLT() >= 3 ? true : false;
        }).filter(mh -> {
            return mh.getTcTH() > 1 ? true : false;
        }).toList();
        return dsMonHoc;
    }

    List<MonHoc> createDanhSachMonHoc() {
        List<MonHoc> danhSachMonHoc = new ArrayList<>();

        MonHoc monHoc1 = new MonHoc("CTDL",3,1);
        MonHoc monHoc2 = new MonHoc("OOP",2,1);
        MonHoc monHoc3 = new MonHoc("Java",3,2);
        danhSachMonHoc.add(monHoc1);
        danhSachMonHoc.add(monHoc2);
        danhSachMonHoc.add(monHoc3);

        return danhSachMonHoc;
    }
}