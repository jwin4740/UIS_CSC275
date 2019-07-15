package com.winkle;

import org.junit.Test;


import static org.junit.Assert.*;

public class winkleTask6Test {


    @Test
    public void bin2Dec() {
        assertEquals(0, winkleTask6.bin2Dec("0"));
        assertEquals(2, winkleTask6.bin2Dec("10"));

        assertEquals(15, winkleTask6.bin2Dec("1111"));

    }

    @Test
    public void hex2Dec() {
        assertEquals(837, winkleTask6.hex2Dec("345"));
        assertEquals(0, winkleTask6.hex2Dec("0"));
        assertEquals(1029211, winkleTask6.hex2Dec("fb45b"));
        assertEquals(205739, winkleTask6.hex2Dec("323ab"));


    }

    @Test
    public void dec2Hex() {
        assertEquals("345", winkleTask6.dec2Hex(837));
        assertEquals("0", winkleTask6.dec2Hex(0));
        assertEquals("fb45b", winkleTask6.dec2Hex(1029211));

    }


}

