package com.winkle;

import org.junit.Test;


import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void hex2Dec() {
        assertEquals(837, Main.hex2Dec("345"));
        assertEquals(0, Main.hex2Dec("0"));

        assertEquals(1029211, Main.hex2Dec("FB45B"));

    }

//    @Test
//    public void dec2Hex() {
//        assertEquals("345", Main.dec2Hex(837));
//        assertEquals("0", Main.dec2Hex(0));
//
//        assertEquals("FB45B", Main.dec2Hex(1029211));
//
//    }


}

