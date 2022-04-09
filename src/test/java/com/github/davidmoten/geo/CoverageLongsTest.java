package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoverageLongsTest {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    /*@Test
    public void getHashLength() throws Exception{
        long[] test = {1};
        double ratio = 4;
        CoverageLongs coveragelongs = new CoverageLongs(test,1,ratio);
        int hashlength = coveragelongs.getHashLength();
        assertEquals(1,hashlength);
        test = new long[]{};
        coveragelongs = new CoverageLongs(test,0,ratio);
        hashlength = coveragelongs.getHashLength();
        assertEquals(0,hashlength);
        test = new long[]{1,2};
        coveragelongs = new CoverageLongs(test,1,ratio);
        hashlength = coveragelongs.getHashLength();
        assertEquals(1,hashlength);
    }*/
    @Test
    public void getCount() throws Exception{
        long[] test = {1};
        double ratio = 4;
        CoverageLongs coveragelongs = new CoverageLongs(test,1,ratio);
        int count = coveragelongs.getCount();
        assertEquals(1,count);
        test = new long[]{};
        coveragelongs = new CoverageLongs(test,0,ratio);
        count = coveragelongs.getCount();
        assertEquals(0,count);
        test = new long[]{1,2};
        coveragelongs = new CoverageLongs(test,-1,ratio);
        count = coveragelongs.getCount();
        assertEquals(-1,count);
    }
    /*@Test
    public void toStringTest() throws Exception{
        long[] test = {1};
        double ratio = 4;
        CoverageLongs coveragelongs = new CoverageLongs(test,1,ratio);
        String str = coveragelongs.toString();
        assertNotEquals("Coverage [hashes=" + coveragelongs.getHashes() + ", ratio=" + coveragelongs.getRatio() + "]",str);
        test = new long[]{};
        coveragelongs = new CoverageLongs(test,0,ratio);
        str = coveragelongs.toString();
        assertNotEquals("Coverage [hashes=" + coveragelongs.getHashes() + ", ratio=" + coveragelongs.getRatio() + "]",str);
        test = new long[]{1,2};
        coveragelongs = new CoverageLongs(test,2,ratio);
        str = coveragelongs.toString();
        assertNotEquals("Coverage [hashes=" + coveragelongs.getHashes() + ", ratio=" + coveragelongs.getRatio() + "]",str);
    }*/
}