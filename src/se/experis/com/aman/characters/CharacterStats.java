package se.experis.com.aman.characters;

public class CharacterStats {

    private double health;
    private double strength;
    private double dex;
    private double intelli;

    public CharacterStats(double health, double strength, double dex, double intelli) {
        this.health = health;
        this.strength = strength;
        this.dex = dex;
        this.intelli = intelli;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDex() {
        return dex;
    }

    public void setDex(double dex) {
        this.dex = dex;
    }

    public double getIntelli() {
        return intelli;
    }

    public void setIntelli(double intelli) {
        this.intelli = intelli;
    }
}
