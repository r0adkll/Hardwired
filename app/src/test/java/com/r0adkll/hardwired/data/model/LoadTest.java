package com.r0adkll.hardwired.data.model;

import android.text.TextUtils;

import com.ftinc.kit.util.Utils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/13/16.
 */
public class LoadTest {

    Load mockLoad;

    @Before
    public void setUp() throws Exception {
        mockLoad = new Load();
        mockLoad.value = generateRandomPercentValue();
        mockLoad.min = generateRandomPercentValue();
        mockLoad.max = generateRandomPercentValue();
    }

    @Test
    public void testGetValue() throws Exception {
        assertTrue(mockLoad.getValue() != -1);
    }

    @Test
    public void testGetMin() throws Exception {
        assertTrue(mockLoad.getMin() != -1);
    }

    @Test
    public void testGetMax() throws Exception {
        assertTrue(mockLoad.getMin() != -1);
    }

    @Test
    public void testGetLabel() throws Exception {
        Load testMock1 = mock(Load.class);
        testMock1.title = "GPU Core";

        assertEquals(testMock1.getLabel(), "Core");

        Load testMock2 = mock(Load.class);
        testMock2.title = "CPU Core #1";

        assertEquals(testMock2.getLabel(), "Core #1");
    }

    private static String generateRandomPercentValue(){
        return String.format("%.1f%%", Utils.getRandom().nextFloat() * 100);
    }
}