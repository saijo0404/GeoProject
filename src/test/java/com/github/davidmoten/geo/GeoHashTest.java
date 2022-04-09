package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GeoHashTest {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void adjacentHash() throws Exception{
        String str = GeoHash.adjacentHash("29jw",Direction.BOTTOM,1);
        assertEquals("29jt",str);
        str = GeoHash.adjacentHash("29jw",Direction.BOTTOM,0);
        assertEquals("29jw",str);
        str = GeoHash.adjacentHash("29jw",Direction.BOTTOM,-1);
        assertEquals("29jx",str);

        str = GeoHash.adjacentHash("29jw",Direction.TOP,1);
        assertEquals("29jx",str);
        str = GeoHash.adjacentHash("29jw",Direction.TOP,0);
        assertEquals("29jw",str);
        str = GeoHash.adjacentHash("29jw",Direction.TOP,-1);
        assertEquals("29jt",str);

        str = GeoHash.adjacentHash("29jw",Direction.LEFT,1);
        assertEquals("29jq",str);
        str = GeoHash.adjacentHash("29jw",Direction.LEFT,0);
        assertEquals("29jw",str);
        str = GeoHash.adjacentHash("29jw",Direction.LEFT,-1);
        assertEquals("29jy",str);

        str = GeoHash.adjacentHash("29jw",Direction.RIGHT,1);
        assertEquals("29jy",str);
        str = GeoHash.adjacentHash("29jw",Direction.RIGHT,0);
        assertEquals("29jw",str);
        str = GeoHash.adjacentHash("29jw",Direction.RIGHT,-1);
        assertEquals("29jq",str);
        /**************************************************************/
        str = GeoHash.adjacentHash("-29jw",Direction.BOTTOM,1);
        assertEquals("-29jq",str);
        str = GeoHash.adjacentHash("-29jw",Direction.BOTTOM,0);
        assertEquals("-29jw",str);
        str = GeoHash.adjacentHash("-29jw",Direction.BOTTOM,-1);
        assertEquals("-29jy",str);

        str = GeoHash.adjacentHash("-29jw",Direction.TOP,1);
        assertEquals("-29jy",str);
        str = GeoHash.adjacentHash("-29jw",Direction.TOP,0);
        assertEquals("-29jw",str);
        str = GeoHash.adjacentHash("-29jw",Direction.TOP,-1);
        assertEquals("-29jq",str);

        str = GeoHash.adjacentHash("-29jw",Direction.LEFT,1);
        assertEquals("-29jt",str);
        str = GeoHash.adjacentHash("-29jw",Direction.LEFT,0);
        assertEquals("-29jw",str);
        str = GeoHash.adjacentHash("-29jw",Direction.LEFT,-1);
        assertEquals("-29jx",str);

        str = GeoHash.adjacentHash("-29jw",Direction.RIGHT,1);
        assertEquals("-29jx",str);
        str = GeoHash.adjacentHash("-29jw",Direction.RIGHT,0);
        assertEquals("-29jw",str);
        str = GeoHash.adjacentHash("-29jw",Direction.RIGHT,-1);
        assertEquals("-29jt",str);
        /****************************************************************/
    }
    @Test
    public void neighbours() throws Exception{
        List<String> res = Arrays.asList("29jq", "29jy", "29jx", "29jt", "29jr", "29jm", "29jz", "29jv");
        List<String> list = GeoHash.neighbours("29jw");
        assertEquals(res,list);
        res = Arrays.asList("-29jt", "-29jx", "-29jy", "-29jq", "-29jv", "-29jm", "-29jz", "-29jr");
        list = GeoHash.neighbours("-29jw");
        assertEquals(res,list);
        try{
            GeoHash.neighbours("");
        }catch (IllegalArgumentException e){
            String s = "adjacent has no meaning for a zero length hash that covers the whole world";
            assertEquals(s,e.getMessage());
        }
    }
    @Test
    public void encodeHash() throws Exception{
        String encodeHash = "";
        //encodeHash(1,1,1);
        try{
            encodeHash = GeoHash.encodeHash(1,1,1);
        }catch (IllegalArgumentException e){}
        assertEquals("s",encodeHash);
        //encodeHash(1,1,0);
        try {
            GeoHash.encodeHash(1,1,0);
        }catch (IllegalArgumentException e){
            String s = "length must be greater than zero";
            assertEquals(s,e.getMessage());
        }
        //encodeHash(100,1,1);
        try {
            GeoHash.encodeHash(100,1,1);
        }catch (IllegalArgumentException e){
            String s = "latitude must be between -90 and 90 inclusive";
            assertEquals(s,e.getMessage());
        }
        //encodeHash(-100,1,1);
        try {
            GeoHash.encodeHash(-100,1,1);
        }catch (IllegalArgumentException e){
            String s = "latitude must be between -90 and 90 inclusive";
            assertEquals(s,e.getMessage());
        }
        try{
            GeoHash.encodeHash(90,100,13);
        }catch (IllegalArgumentException e){
            String s = "invalid long geohash -9223372036854775795";
            assertEquals(s,e.getMessage());
        }
    }
    @Test
    public void top() throws Exception{
        String str = GeoHash.top("29jw");
        assertEquals("29jx",str);
        str = GeoHash.top("-29jw");
        assertEquals("-29jy",str);
        try{
            GeoHash.top("");
        }catch (IllegalArgumentException e){
            String s = "adjacent has no meaning for a zero length hash that covers the whole world";
            assertEquals(s,e.getMessage());
        }
    }
    /*@Test
    public void right() throws Exception{
        String str = GeoHash.right("29jw");
        assertEquals("29jy",str);
        str = GeoHash.right("-29jw");
        assertEquals("-29jx",str);
        try{
            GeoHash.right("");
        }catch (IllegalArgumentException e){
            String s = "adjacent has no meaning for a zero length hash that covers the whole world";
            assertEquals(s,e.getMessage());
        }
    }
    @Test
    public void left() throws Exception{
        String str = GeoHash.left("29jw");
        assertEquals("29jq",str);
        str = GeoHash.left("-29jw");
        assertEquals("-29jt",str);
        try{
            GeoHash.left("");
        }catch (IllegalArgumentException e){
            String s = "adjacent has no meaning for a zero length hash that covers the whole world";
            assertEquals(s,e.getMessage());
        }
    }
    @Test
    public void bottom() throws Exception{
        String str = GeoHash.bottom("29jw");
        assertEquals("29jt",str);
        str = GeoHash.bottom("-29jw");
        assertEquals("-29jq",str);
        try{
            GeoHash.bottom("");
        }catch (IllegalArgumentException e){
            String s = "adjacent has no meaning for a zero length hash that covers the whole world";
            assertEquals(s,e.getMessage());
        }
    }*/
    @Test
    public void hashLengthToCoverBoundingBox() throws Exception{
        int lenght;
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,180,-90,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,180,-90,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,0,-90,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,180,0,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,180,-90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,-90,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,180,0,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,180,-90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,0,0,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,0,-90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,180,0,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,0,-180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,-90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,180,0,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(90,0,0,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,0,0);
        assertEquals(12,lenght);
        /*******************************************************************************************************/
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,-180,90,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,-180,90,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,0,90,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,-180,0,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,-180,90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,90,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,-180,0,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,-180,90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,0,0,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,0,90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,-180,0,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,0,180);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,0,90,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(0,-180,0,0);
        assertEquals(0,lenght);
        lenght = GeoHash.hashLengthToCoverBoundingBox(-90,0,0,0);
        assertEquals(0,lenght);
    }
    @Test
    public void gridAsString() throws Exception{
        Set<String> highlightThese = Collections.singleton("");
        String str = GeoHash.gridAsString("29jw",1,1, 1,1,highlightThese);
        assertEquals("29jv \n",str);
        highlightThese = Collections.singleton("29jw");
        str = GeoHash.gridAsString("29jw",1,1,1,1,highlightThese);
        assertEquals("29jv \n",str);
        highlightThese = Collections.singleton("-29jw");
        str = GeoHash.gridAsString("29jw",1,1,1,1,highlightThese);
        assertEquals("29jv \n",str);
        highlightThese = Collections.singleton("29jv");
        str = GeoHash.gridAsString("29jw",1,1,1,1,highlightThese);
        assertEquals("29JV \n",str);
    }
    @Test
    public void heightDegrees() throws Exception{
        double result = GeoHash.heightDegrees(1);
        assertEquals(45,result,0);
        result = GeoHash.heightDegrees(13);
        assertEquals(4.190951585769653E-8,result,0);
        result = GeoHash.heightDegrees(0);
        assertEquals(180,result,0);
        try {
            GeoHash.heightDegrees(-1);
        }catch (ArrayIndexOutOfBoundsException e){
            assertEquals("-1",e.getMessage());
        }
    }
    @Test
    public void widthDegrees() throws  Exception{
        double result = GeoHash.widthDegrees(1);
        assertEquals(45,result,0);
        result = GeoHash.widthDegrees(13);
        assertEquals(4.190951585769653E-8,result,0);
        result = GeoHash.widthDegrees(0);
        assertEquals(360,result,0);
        try {
            GeoHash.widthDegrees(-1);
        }catch (ArrayIndexOutOfBoundsException e){
            assertEquals("-1",e.getMessage());
        }
    }
    @Test
    public void coverBoundingBoxLongs() throws Exception{
        CoverageLongs coverageLongs;
        try{
            GeoHash.coverBoundingBoxLongs(0,0,0,0,0);
        }catch (IllegalArgumentException e){
            String s = "length must be greater than zero";
            assertEquals(s,e.getMessage());
        }
        try{
            GeoHash.coverBoundingBoxLongs(0,0,1,0,0);
        }catch (IllegalArgumentException e){
            String s = "topLeftLat must be >= bottomRighLat";
            assertEquals(s,e.getMessage());
        }
        try{
            GeoHash.coverBoundingBoxLongs(0,1,0,0,0);
        }catch (IllegalArgumentException e){
            String s = "topLeftLon must be <= bottomRighLon";
            assertEquals(s,e.getMessage());
        }
        coverageLongs = GeoHash.coverBoundingBoxLongs(1,0,0,1,1);
        System.out.println(coverageLongs.getHashes());
        System.out.println(coverageLongs.getCount());
        System.out.println(coverageLongs.getRatio());
        assertEquals(1,coverageLongs.getCount());
        assertEquals(2025.0,coverageLongs.getRatio(),0);
    }
}