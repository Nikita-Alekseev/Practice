package com.example.practice.dtos;

public class WorkerDto {
    private Long id;
    private String fullNameOfTheWorker;
    private String jobTitle;
    private String dateOfEmployment;
    private Integer wage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNameOfTheWorker() {
        return fullNameOfTheWorker;
    }

    public void setFullNameOfTheWorker(String fullNameOfTheWorker) {
        this.fullNameOfTheWorker = fullNameOfTheWorker;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    protected WorkerDto() {};

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", fullNameOfTheWorker=" + fullNameOfTheWorker +
                ", jobTitle=" + jobTitle +
                ", dateOfEmployment=" + dateOfEmployment +
                ", wage=" + wage +
                '}';
    }

    public WorkerDto(Long id, String fullNameOfTheWorker, String jobTitle, String dateOfEmployment, Integer wage) {
        this.id = id;
        this.fullNameOfTheWorker = fullNameOfTheWorker;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
        this.wage = wage;
    }
}
