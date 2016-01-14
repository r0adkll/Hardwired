package com.r0adkll.hardwired.data.model;

import com.ftinc.kit.util.Utils;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.r0adkll.hardwired.data.model.Component.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
public class ComponentTest {

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

    @Test
    public void testGetComponent() throws Exception {
        Component subComponentMock = mock(Component.class);

        Component t1 = new Component();
        t1.id = Utils.getRandom().nextInt(100);
        t1.title = String.valueOf(Utils.getRandom().nextFloat() * 100);
        t1.components = mock(List.class);
        t1.components.add(subComponentMock);
        t1.imageUri = "images/computer.png";
        t1.value = "VALUE";
        t1.min = "MIN";
        t1.max = "MAX";

        // Test getting a casted copy
        CPU cpu = t1.getComponent(CPU.class);
        assertNotNull(cpu);
        assertEquals(t1.id, cpu.id);
        assertEquals(t1.title, cpu.title);
        assertEquals(t1.imageUri, cpu.imageUri);
        assertEquals(t1.value, cpu.value);
        assertEquals(t1.min, cpu.min);
        assertEquals(t1.max, cpu.max);
        verify(cpu.components).add(subComponentMock);

    }

    @Test(expected = NullPointerException.class)
    public void testGetType() throws Exception {

        Component computer = mockComponent("images/computer.png");
        Component ssd = mockComponent("images/hdd.png", "Samsung SSD 850 Evo Series");
        Component hdd = mockComponent("images/hdd.png");
        Component gfx = mockComponent("images/nvidia.png");
        Component gfx2 = mockComponent("images/ati.png");
        Component ram = mockComponent("images/ram.png");
        Component cpu = mockComponent("images/cpu.png");
        Component mobo = mockComponent("images/mainboard.png");
        Component unknown = mockComponent("");
        Component error = mockComponent(null);

        // Test Components
        assertEquals(computer.getType(), COMPUTER);
        assertEquals(ssd.getType(), SSD);
        assertEquals(hdd.getType(), HDD);
        assertEquals(gfx.getType(), GRAPHICS);
        assertEquals(gfx2.getType(), GRAPHICS);
        assertEquals(ram.getType(), MEMORY);
        assertEquals(cpu.getType(), CPU);
        assertEquals(mobo.getType(), MOTHERBOARD);
        assertEquals(unknown.getType(), UNKNOWN);

        // Test that this throws an error
        error.getType();
    }

    private Component mockComponent(String imageUri, String title){
        Component component = new Component();
        component.imageUri = imageUri;
        component.title = title;
        return component;
    }

    private Component mockComponent(String imageUri){
        return mockComponent(imageUri, "");
    }

}