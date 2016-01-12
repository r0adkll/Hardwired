package com.r0adkll.hardwired;

import com.r0adkll.hardwired.data.model.Component;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ComponentUnitTest {
    @Test
    public void componentType_bitwiseTest() throws Exception {
        int flags = Component.HDD | Component.SSD;

        boolean test1 = (flags & Component.HDD) == Component.HDD;
        boolean test2 = (flags & Component.SSD) == Component.SSD;
        boolean test3 = (flags & Component.CPU) == Component.CPU;
        boolean test4 = (Component.GRAPHICS & Component.GRAPHICS) == Component.GRAPHICS;

        System.out.println(String.format("Flags[%d] - T[%b, %b, %b, %b]", flags, test1, test2, test3, test4));

        assertTrue(test1);
        assertTrue(test2);
        assertFalse(test3);
        assertTrue(test4);
    }
}