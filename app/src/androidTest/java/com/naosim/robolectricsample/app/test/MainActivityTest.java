package com.naosim.robolectricsample.app.test;

import com.naosim.robolectricsample.app.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by nao_pillows on 2014/05/24.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    @Test
    public void testGetTrue() throws Exception {
        assertTrue(MainActivity.getTrue());
    }
}
