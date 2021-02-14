package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job testJob1;
    Job emptyJob;
    Job fullFieldJob;
    Job equalJob;
    Job emptyFieldJob;


    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        emptyJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        fullFieldJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        equalJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        emptyFieldJob = new Job("Product Tester", new Employer("ACME"), new Location("NWA"), new PositionType(""), new CoreCompetency("Java"));
    }


    @Test
    public void testSettingJobId() {
        assertEquals(1,emptyJob.getId() - testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(fullFieldJob.getEmployer().getValue(), "ACME");
        assertTrue(fullFieldJob.getEmployer() instanceof Employer);
        assertEquals(fullFieldJob.getLocation().getValue(), "Desert");
        assertTrue(fullFieldJob.getLocation() instanceof Location);
        assertEquals(fullFieldJob.getPositionType().getValue(), "Quality Control");
        assertTrue(fullFieldJob.getPositionType() instanceof PositionType);
        assertEquals(fullFieldJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(fullFieldJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(equalJob.equals(fullFieldJob));
    }

    @Test
    public void testToStringLines() {
        assertTrue(fullFieldJob.toString().startsWith("\n"));
        assertTrue(fullFieldJob.toString().endsWith("\n"));
    }

    @Test
    public void testLabelEachLine() {
        String testingToString =
                "\nID: " + fullFieldJob.getId() +
                "\nName: Product Tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality Control" +
                "\nCore Competency: Persistence\n";
        assertEquals(fullFieldJob.toString(), testingToString);
    }

    @Test
    public void testReturnsMessageIfEmptyField() {
        assertTrue(emptyFieldJob.toString().contains("Data not available"));
    }

    @Test
    public void testAllFieldsEmptyReturnsOops() {
        assertTrue(emptyJob.toString().contains("OOPS! This job does not seem to exist."));
    }

}
