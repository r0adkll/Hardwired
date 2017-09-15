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
public class DataTest {

    Data mockData;

    @Before
    public void setUp() throws Exception {
        mockData = new Data();
        mockData.value = generateMockMemory();
        mockData.min = generateMockMemory();
        mockData.max = generateMockMemory();
    }

    @Test
    public void testGetDataType() throws Exception {
        Data t1 = new Data();
        t1.title = "Used Memory";

        Data t2 = new Data();
        t2.title = "Available Memory";

        Data t3 = new Data();
        t3.title = "Total Memory";

        assertEquals(t1.getDataType(), Data.USED);
        assertEquals(t2.getDataType(), Data.AVAILABLE);
        assertEquals(t3.getDataType(), Data.GENERAL);
    }

    @Test
    public void testGetAmount() throws Exception {
        assertTrue(mockData.getAmount() != -1f);
    }

    @Test
    public void testGetMinAmount() throws Exception {
        assertTrue(mockData.getMinAmount() != -1f);
    }

    @Test
    public void testGetMaxAmount() throws Exception {
        assertTrue(mockData.getMaxAmount() != -1f);
    }

    private String generateMockMemory(){
        return String.format("%.1f GB", Utils.getRandom().nextFloat() * 256);
    }
}