package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Base32Test {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void encodeBase32() throws Exception {
        String encode = Base32.encodeBase32(75324, 4);
        assertEquals("29jw", encode);
        encode = Base32.encodeBase32(-75324, 4);
        assertEquals("-29jw", encode);
        encode = Base32.encodeBase32(75324, 7);
        assertEquals("00029jw", encode);
        encode = Base32.encodeBase32(-75324, 7);
        assertEquals("-00029jw", encode);

        encode = Base32.encodeBase32(75324);
        assertEquals("0000000029jw", encode);
        encode = Base32.encodeBase32(-75324);
        assertEquals("-0000000029jw", encode);
    }
    @Test
    public void decodeBase32() throws Exception{
        long decode = Base32.decodeBase32("29jw");
        assertEquals(75324, decode);
        decode = Base32.decodeBase32("-29jw");
        assertEquals(-75324, decode);
        decode = Base32.decodeBase32("");
        assertEquals(0, decode);
    }
    @Test
    public void getCharIndex() throws Exception{
        try {
            Base32.getCharIndex('a');
        }catch (IllegalArgumentException e){
            String s = "not a base32 character: a";
            assertEquals(s,e.getMessage());
        }
        Integer result = null;
        try {
            result = Base32.getCharIndex('0');
        }catch (IllegalArgumentException e){
            String s = "not a base32 character: 0";
            assertEquals(s,e.getMessage());
        }
        assertEquals(new Integer(0),result);
    }
}