package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LatLongTest {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void add() throws Exception{
        double lat = 0;
        double lon = 0;
        LatLong latlong = new LatLong(lat,lon);
        LatLong newlatLong = latlong.add(1,1);
        assertEquals(lat+1,newlatLong.getLat(),0);
        assertEquals(lon+1,newlatLong.getLon(),0);
        newlatLong = latlong.add(-1,-1);
        assertEquals(lat-1,newlatLong.getLat(),0);
        assertEquals(lon-1,newlatLong.getLon(),0);
        newlatLong = latlong.add(0,0);
        assertEquals(lat,newlatLong.getLat(),0);
        assertEquals(lon,newlatLong.getLon(),0);
    }
    @Test
    public void toStringTest() throws Exception{
        double lat = 0;
        double lon = 0;
        LatLong latlong = new LatLong(lat,lon);
        String str = latlong.toString();
        assertEquals("LatLong [lat="+lat+", lon="+lon+"]",str);
        lat = 1;
        lon = 1;
        latlong = new LatLong(lat,lon);
        str = latlong.toString();
        assertEquals("LatLong [lat="+lat+", lon="+lon+"]",str);
        lat = -1;
        lon = -1;
        latlong = new LatLong(lat,lon);
        str = latlong.toString();
        assertEquals("LatLong [lat="+lat+", lon="+lon+"]",str);
    }
}