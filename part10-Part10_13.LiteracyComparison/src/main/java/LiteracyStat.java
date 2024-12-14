/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hachem
 */
public class LiteracyStat {
    private String country;
    private String year;
    private boolean gender;
    private double stat;

    public LiteracyStat(String country, String year, boolean gender, double stat) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.stat = stat;
    }

    public String getCountry() {
        return country;
    }

    public String getYear() {
        return year;
    }

    public double getStat() {
        return stat;
    }
        
    public String gender() {
        return this.gender == true ? "female" : "male";
    }

    @Override
    public String toString() {
        return getCountry() + " (" + getYear() + "), " + gender() + ", " + getStat();
    }    
}
