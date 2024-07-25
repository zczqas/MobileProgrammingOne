package com.bca_sixth.mobileprogrammingone.unit_6;

public class DriverDetail {
    private final int image;
    private final String name;
    //    private String team;
    private final String description;

    //    public DriverDetail(int image, String name, String team, String description) {
    public DriverDetail(int image, String name, String description) {
        this.image = image;
        this.name = name;
//        this.team = team;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

//    public String getTeam() {
//        return team;
//    }

    public String getDescription() {
        return description;
    }
}
