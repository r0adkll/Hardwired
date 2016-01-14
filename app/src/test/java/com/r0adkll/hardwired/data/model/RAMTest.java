package com.r0adkll.hardwired.data.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
public class RAMTest {

    RAM mockRam;

    @Before
    public void setUp() throws Exception {
        mockRam = new RAM();
    }

    @Test
    public void testGetLoad() throws Exception {
        Component loadMock = mock(Component.class);
        when(loadMock.getComponent(Load.class))
                .thenReturn(mock(Load.class));

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Load";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockRam.components = Arrays.asList(loadContainerMock);

        // Validate method
        Load load = mockRam.getLoad();
        assertNotNull(load);
    }

    @Test
    public void testGetUsedMemory() throws Exception {
        Data dataMock = mock(Data.class);
        when(dataMock.getDataType())
                .thenReturn(Data.USED);

        Component loadMock = mock(Component.class);
        when(loadMock.getComponent(Data.class))
                .thenReturn(dataMock);

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Data";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockRam.components = Arrays.asList(loadContainerMock);

        // Validate method
        Data data = mockRam.getUsedMemory();
        assertNotNull(data);
    }

    @Test
    public void testGetAvailableMemory() throws Exception {
        Data dataMock = mock(Data.class);
        when(dataMock.getDataType())
                .thenReturn(Data.AVAILABLE);

        Component loadMock = mock(Component.class);
        when(loadMock.getComponent(Data.class))
                .thenReturn(dataMock);

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Data";
        loadContainerMock.components = Arrays.asList(loadMock);

        mockRam.components = Arrays.asList(loadContainerMock);

        // Validate method
        Data data = mockRam.getAvailableMemory();
        assertNotNull(data);
    }

    @Test
    public void testGetTotalMemory() throws Exception {
        Component usedMock = generateDataMock(Data.USED, 10.3f);
        Component availMock = generateDataMock(Data.AVAILABLE, 4.7f);

        Component loadContainerMock = mock(Component.class);
        loadContainerMock.title = "Data";
        loadContainerMock.components = Arrays.asList(usedMock, availMock);

        mockRam.components = Arrays.asList(loadContainerMock);

        // Validate method
        assertEquals(mockRam.getTotalMemory(), 15f, 0.01f);
    }

    private Component generateDataMock(@Data.Type int type, float value){
        Data dataMock = mock(Data.class);
        when(dataMock.getDataType()).thenReturn(type);
        when(dataMock.getAmount()).thenReturn(value);

        Component dataComponentMock = mock(Component.class);
        when(dataComponentMock.getComponent(Data.class))
                .thenReturn(dataMock);

        return dataComponentMock;
    }
}