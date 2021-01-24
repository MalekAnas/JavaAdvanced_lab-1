package se.black_lemon;

public class MyObject {
    private boolean bool;
    private int value;
    private String name;

    public boolean getBool() {
        return this.bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyObject(boolean bool, int value, String name) {
        this.bool = bool;
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Bool: " + this.bool + ", Name: " + this.name + ", Value: " + this.value);
    }
}
