package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job fullFieldJob;
    Job equalJob;
    Job emptyFieldJob;


    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
        fullFieldJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        equalJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        emptyFieldJob = new Job("Web Developer", new Employer(""), new Location("NWA"), new PositionType("Full Stack"), new CoreCompetency("Java"));
    }


    @Test
    public void testSettingJobId() {
        assertEquals(1,testJob2.getId() - testJob1.getId());
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


}
