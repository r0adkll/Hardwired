package com.r0adkll.hardwired.data.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
public class ComputerTest {

    @Test
    public void testGetBaseUri() throws Exception {
        Computer test1 = new Computer.Builder()
                .ip("0.0.0.0")
                .port(8085)
                .build();

        assertEquals(test1.getBaseUri(), "http://0.0.0.0:8085");
    }

}