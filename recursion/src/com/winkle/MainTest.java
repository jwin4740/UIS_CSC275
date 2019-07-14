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


}

