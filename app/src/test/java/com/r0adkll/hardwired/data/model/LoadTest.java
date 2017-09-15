package com.r0adkll.hardwired.data.model;

import android.os.Build;

import com.ftinc.kit.util.Utils;
import com.r0adkll.hardwired.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/13/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
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
        when(testMock1.getLabel()).thenCallRealMethod();

        testMock1.title = "GPU Core";

        assertEquals(testMock1.getLabel(), "Core");

        Load testMock2 = mock(Load.class);
        when(testMock2.getLabel()).thenCallRealMethod();
        testMock2.title = "CPU Core #1";

        assertEquals(testMock2.getLabel(), "Core #1");
    }

    private static String generateRandomPercentValue(){
        return String.format("%.1f%%", Utils.getRandom().nextFloat() * 100);
    }
}