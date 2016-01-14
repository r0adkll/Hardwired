package com.r0adkll.hardwired.data.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
public class HDDTest {

    HDD mockHDD;

    @Before
    public void initMocks(){
        mockHDD = new HDD();
    }

    @Test
    public void testGetLoad() throws Exception {
        Component loadMock = mock(Component.class);
        when(loadMock.getComponent(Load.class))
                .thenReturn(mock(Load.class));

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Load";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockHDD.components = Arrays.asList(loadContainerMock);

        // Validate method
        Load load = mockHDD.getLoad();
        assertNotNull(load);
    }

    @Test
    public void testGetTemperature() throws Exception {
        Component tempMock = mock(Component.class);
        when(tempMock.getComponent(Temperature.class))
                .thenReturn(mock(Temperature.class));

        Component tempContainerMock = mock(Component.class);
        tempContainerMock.title = "Temperatures";
        tempContainerMock.components = Arrays.asList(tempMock);

        mockHDD.components = Arrays.asList(tempContainerMock);

        Temperature temperature = mockHDD.getTemperature();
        assertNotNull(temperature);
    }
}