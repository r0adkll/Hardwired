package com.r0adkll.hardwired.data.model;

import android.os.Build;

import com.ftinc.kit.util.Utils;
import com.r0adkll.hardwired.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
public class ClockTest {

    Clock mockClock;

    @Before
    public void setUp() throws Exception {
        mockClock = new Clock();
        mockClock.value = generateRandomClockValue();
        mockClock.min = generateRandomClockValue();
        mockClock.max = generateRandomClockValue();
    }

    @Test
    public void testGetSpeedMhz() throws Exception {
        assertTrue(mockClock.getSpeedMhz() != -1);
    }

    @Test
    public void testGetMinSpeedMhz() throws Exception {
        assertTrue(mockClock.getMinSpeedMhz() != -1);
    }

    @Test
    public void testGetMaxSpeedMhz() throws Exception {
        assertTrue(mockClock.getMaxSpeedMhz() != -1);
    }

    @Test
    public void testGetLabel() throws Exception {
        Clock testMock1 = mock(Clock.class);
        when(testMock1.getLabel()).thenCallRealMethod();
        testMock1.title = "GPU Core";

        assertEquals(testMock1.getLabel(), "Core");

        Clock testMock2 = mock(Clock.class);
        when(testMock2.getLabel()).thenCallRealMethod();
        testMock2.title = "CPU Memory";

        assertEquals(testMock2.getLabel(), "Memory");
    }

    private static String generateRandomClockValue(){
        return String.format("%d MHz", Utils.getRandom().nextInt(5000));
    }
}