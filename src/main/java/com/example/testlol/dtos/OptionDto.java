package com.example.testlol.dtos;

public class OptionDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OptionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public OptionDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
