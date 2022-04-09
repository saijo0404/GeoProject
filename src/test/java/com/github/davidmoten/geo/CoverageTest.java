package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class CoverageTest {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    /*@Test
    public void getHashes() throws Exception{
        Set<String> hashes = Collections.singleton("29jw");
        double ratio = 4;
        Coverage coverage = new Coverage(hashes,ratio);
        Set<String> str = coverage.getHashes();
        assertEquals(hashes, str);
        hashes = Collections.singleton("-29jw");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        str = coverage.getHashes();
        assertEquals(hashes, str);
        hashes = Collections.singleton("");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        str = coverage.getHashes();
        assertEquals(hashes, str);
    }
    @Test
    public void getHashLength() throws Exception{
        Set<String> hashes = Collections.singleton("29jw");
        double ratio = 4;
        Coverage coverage = new Coverage(hashes,ratio);
        int length = coverage.getHashLength();
        assertEquals(4, length);

        hashes = Collections.singleton("-29jw");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        length = coverage.getHashLength();
        assertEquals(5, length);
        length = coverage.getHashLength();
        assertEquals(5, length);

        hashes = Collections.singleton("");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        length = coverage.getHashLength();
        assertEquals(0, length);

        long[] test={};
        ratio = 4;
        CoverageLongs coveragelongs = new CoverageLongs(test,0,ratio);
        coverage = new Coverage(coveragelongs);
        length = coverage.getHashLength();
        assertEquals(0, length);

        test = new long[]{1};
        ratio = 4;
        coveragelongs = new CoverageLongs(test,1,ratio);
        coverage = new Coverage(coveragelongs);
        length = coverage.getHashLength();
        assertEquals(1, length);
    }
    @Test
    public void tostring() throws Exception{
        Set<String> hashes = Collections.singleton("29jw");
        double ratio = 4;
        Coverage coverage = new Coverage(hashes,ratio);
        String s = coverage.toString();
        assertEquals("Coverage [hashes=" + coverage.getHashes() + ", ratio="+coverage.getRatio()+"]",s);
        hashes = Collections.singleton("-29jw");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        s = coverage.toString();
        assertEquals("Coverage [hashes=" + coverage.getHashes() + ", ratio="+coverage.getRatio()+"]",s);
        hashes = Collections.singleton("");
        ratio = 4;
        coverage = new Coverage(hashes,ratio);
        s = coverage.toString();
        assertEquals("Coverage [hashes=" + coverage.getHashes() + ", ratio="+coverage.getRatio()+"]",s);
    }*/
}