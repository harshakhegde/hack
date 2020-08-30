package de.harshaheg.hack;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RanGenTest extends TestCase {

    @Test
    public void testGetRandomFixedLength() {
        RanGen ranGen = new RanGen();
        Long random = ranGen.getRandom(10);
        System.out.println("Got: " + random);
        Assert.assertTrue(random.toString().length() <= 10);
    }

    @Test
    public void testGetRandomDigitsRandom() {
        RanGen ranGen = new RanGen();
        Random r = new Random();
        int digits = r.nextInt(19);
        Long random = ranGen.getRandom(digits);
        System.out.println(String.format("Checking for %s and got %s", String.valueOf(digits), String.valueOf(random)));
        Assert.assertTrue(random.toString().length() <= digits);
    }

    @Test
    public void testGetRandomWithinLimit() {
        RanGen ranGen = new RanGen();
        Random r = new Random();
        int digits = r.nextInt(19);
        ranGen.getRandom(digits);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRandomLimitbreach() {
        RanGen ranGen = new RanGen();
        try {
            ranGen.getRandom(20);
            fail("If there is no exception then this is a failure");
        } catch (IllegalArgumentException iae) {
            //NO-OP
        }
    }

    @Test
    public void testRandomness() {
        Set<Long> generatedNumbers = new HashSet<>();
        RanGen ranGen = new RanGen();
        Random r = new Random();
        int digits = r.nextInt(19);
        for (int i = 0; i < 10; i++) {
            Long random = ranGen.getRandom(digits);
            if (generatedNumbers.contains(random)) {
                fail("Numbers are not random. Already had: "+random);
            }
            generatedNumbers.add(random);
        }

    }
}