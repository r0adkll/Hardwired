package com.r0adkll.hardwired.data.model;

import com.ftinc.kit.util.Utils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
public class CPUTest {

    CPU mockCpu;

    @Before
    public void setUp() throws Exception {
        mockCpu = new CPU();
    }

    @Test
    public void testGetTotalLoad() throws Exception {
        Component loadMock = mock(Component.class);
        loadMock.title = "CPU Total";
        when(loadMock.getComponent(Load.class))
                .thenReturn(mock(Load.class));

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Load";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockCpu.components = Arrays.asList(loadContainerMock);

        // Validate method
        Load load = mockCpu.getTotalLoad();
        assertNotNull(load);
    }

    @Test
    public void testGetCoreLoads() throws Exception {
        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Load";
        loadContainerMock.components = new ArrayList<>(8);

        int numCores = Utils.getRandom().nextInt(8);
        for (int i = 0; i < numCores; i++) {
            loadContainerMock.components.add(generateCoreLoadMock(i));
        }

        mockCpu.components = Arrays.asList(loadContainerMock);

        // Validate method
        List<Load> load = mockCpu.getCoreLoads();
        assertTrue(!load.isEmpty());
        assertEquals(load.size(), numCores);
    }

    @Test
    public void testGetBusClock() throws Exception {
        Component coreClockMock = mock(Component.class);
        when(coreClockMock.getComponent(Clock.class))
                .thenReturn(mock(Clock.class));
        coreClockMock.title = "Bus Speed";

        Component clockContainerMock = mock(Component.class);
        clockContainerMock.title = "Clocks";
        clockContainerMock.components = Arrays.asList(coreClockMock);

        mockCpu.components = Arrays.asList(clockContainerMock);

        Clock core = mockCpu.getBusClock();
        assertNotNull(core);
    }

    @Test
    public void testGetCoreClocks() throws Exception {
        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Clocks";
        loadContainerMock.components = new ArrayList<>(8);

        int numCores = Utils.getRandom().nextInt(8);
        for (int i = 0; i < numCores; i++) {
            loadContainerMock.components.add(generateCoreClockMock(i));
        }

        mockCpu.components = Arrays.asList(loadContainerMock);

        // Validate method
        List<Clock> load = mockCpu.getCoreClocks();
        assertTrue(!load.isEmpty());
        assertEquals(load.size(), numCores);
    }

    private Component generateCoreLoadMock(int index){
        Component loadMock = mock(Component.class);
        loadMock.title = String.format("CPU Core #%d", index);
        when(loadMock.getComponent(Load.class))
                .thenReturn(mock(Load.class));

        return loadMock;
    }

    private Component generateCoreClockMock(int index){
        Component clockMock = mock(Component.class);
        clockMock.title = String.format("CPU Core #%d", index);
        when(clockMock.getComponent(Clock.class))
                .thenReturn(mock(Clock.class));

        return clockMock;
    }

}