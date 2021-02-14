package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private static final String defaultMessage = "Data not available";

    // Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    @Override
    public String toString() {
        if (this.name.equals("") && this.employer.toString().equals("") && this.location.toString().equals("") && this.positionType.toString().equals("") && this.coreCompetency.toString().equals("")) {
            return "OOPS! This job does not seem to exist.";
        } else {
            if (this.name == "") {
                this.name = defaultMessage;
            }
            if (this.employer.getValue() == "") {
                this.employer.setValue(defaultMessage);
            }
            if (this.location.getValue() == "") {
                this.location.setValue(defaultMessage);
            }
            if (this.positionType.toString() == "") {
                this.positionType.setValue(defaultMessage);
            }
            if (this.coreCompetency.toString() == "") {
                this.coreCompetency.setValue(defaultMessage);
            }
        }
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nEmployer: " + this.employer +
                "\nLocation: " + this.location +
                "\nPosition Type: " + this.positionType +
                "\nCore Competency: " + this.coreCompetency + "\n";
    }



    // Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


}
