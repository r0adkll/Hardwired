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

/**
 * Project: Hardwired
 * Package: com.r0adkll.hardwired.data.model
 * Created by drew.heavner on 1/14/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
public class FanTest {

    Fan mockFan;

    @Before
    public void setUp() throws Exception {
        mockFan = new Fan();
        mockFan.value = generateFanSpeed();
        mockFan.min = generateFanSpeed();
        mockFan.max = generateFanSpeed();
    }

    @Test
    public void testGetSpeed() throws Exception {
        assertTrue(mockFan.getSpeed() != -1);
    }

    @Test
    public void testGetMinSpeed() throws Exception {
        assertTrue(mockFan.getMinSpeed() != -1);
    }

    @Test
    public void testGetMaxSpeed() throws Exception {
        assertTrue(mockFan.getMaxSpeed() != -1);
    }

    private static String generateFanSpeed(){
        return String.format("%d RPM", Utils.getRandom().nextInt(5000));
    }

}