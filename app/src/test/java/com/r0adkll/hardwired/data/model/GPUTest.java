package com.r0adkll.hardwired.data.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/13/16.
 */
public class GPUTest {

    GPU mockGpu;

    @Before
    public void initMocks(){
        mockGpu = new GPU();
    }

    @Test
    public void testGetLoad() throws Exception {
        Component loadMock = mock(Component.class);
        when(loadMock.getComponent(Load.class))
                .thenReturn(mock(Load.class));

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Load";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockGpu.components = Arrays.asList(loadContainerMock);

        // Validate method
        Load load = mockGpu.getLoad();
        assertNotNull(load);
    }

    @Test
    public void testGetCoreClock() throws Exception {
        Component coreClockMock = mock(Component.class);
        when(coreClockMock.getComponent(Clock.class))
                .thenReturn(mock(Clock.class));
        coreClockMock.title = "GPU Core";

        Component clockContainerMock = mock(Component.class);
        clockContainerMock.title = "Clocks";
        clockContainerMock.components = Arrays.asList(coreClockMock);

        mockGpu.components = Arrays.asList(clockContainerMock);

        Clock core = mockGpu.getCoreClock();
        assertNotNull(core);
    }

    @Test
    public void testGetMemoryClock() throws Exception {
        Component memoryClockMock = mock(Component.class);
        when(memoryClockMock.getComponent(Clock.class))
                .thenReturn(mock(Clock.class));
        memoryClockMock.title = "GPU Memory";

        Component clockContainerMock = mock(Component.class);
        clockContainerMock.title = "Clocks";
        clockContainerMock.components = Arrays.asList(memoryClockMock);

        mockGpu.components = Arrays.asList(clockContainerMock);

        Clock memory = mockGpu.getMemoryClock();
        assertNotNull(memory);
    }

    @Test
    public void testGetTemperature() throws Exception {
        Component tempMock = mock(Component.class);
        when(tempMock.getComponent(Temperature.class))
                .thenReturn(mock(Temperature.class));

        Component tempContainerMock = mock(Component.class);
        tempContainerMock.title = "Temperatures";
        tempContainerMock.components = Arrays.asList(tempMock);

        mockGpu.components = Arrays.asList(tempContainerMock);

        Temperature temperature = mockGpu.getTemperature();
        assertNotNull(temperature);
    }

    @Test
    public void testGetFan() throws Exception {
        Component fanMock = mock(Component.class);
        when(fanMock.getComponent(Fan.class))
                .thenReturn(mock(Fan.class));

        Component fanContainerMock = mock(Component.class);
        fanContainerMock.title = "Fans";
        fanContainerMock.components = Arrays.asList(fanMock);

        mockGpu.components = Arrays.asList(fanContainerMock);

        Fan fan = mockGpu.getFan();
        assertNotNull(fan);
    }
}