package com.winkle;

import org.junit.Test;


import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void bin2Dec() {
        assertEquals(0, Main.bin2Dec("0"));
        assertEquals(2, Main.bin2Dec("10"));

        assertEquals(15, Main.bin2Dec("1111"));

    }

    @Test
    public void hex2Dec() {
        assertEquals(837, Main.hex2Dec("345"));
        assertEquals(0, Main.hex2Dec("0"));
        assertEquals(1029211, Main.hex2Dec("fb45b"));
        assertEquals(205739, Main.hex2Dec("323ab"));


    }

    @Test
    public void dec2Hex() {
        assertEquals("345", Main.dec2Hex(837));
        assertEquals("0", Main.dec2Hex(0));
        assertEquals("fb45b", Main.dec2Hex(1029211));

    }


}

