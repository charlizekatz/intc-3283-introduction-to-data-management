package edu.northwestu.intc3283.datasourcestarter.reports;

import org.springframework.data.relational.core.mapping.Column;

public class JenniferQueryOneRow {
    private String firstName;
    private String lastName;
    private Integer yearDonated;
    private String monthDonated;

    @Column("total")
    private Integer totalDonated;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getYearDonated() {
        return yearDonated;
    }

    public void setYearDonated(Integer yearDonated) {
        this.yearDonated = yearDonated;
    }

    public String getMonthDonated() {
        return monthDonated;
    }

    public void setMonthDonated(String monthDonated) {
        this.monthDonated = monthDonated;
    }

    public Integer getTotalDonated() {
        return totalDonated;
    }

    public void setTotalDonated(Integer totalDonated) {
        this.totalDonated = totalDonated;
    }
}
