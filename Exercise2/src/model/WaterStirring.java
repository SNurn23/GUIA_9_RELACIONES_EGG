package model;

public class WaterStirring {
    private int posA;
    private int posW;

    public WaterStirring(int posA, int posW) {
        this.posA = posA;
        this.posW = posW;
    }

    public WaterStirring() {
    }

    public int getPosA() {
        return posA;
    }

    public void setPosA(int posA) {
        this.posA = posA;
    }

    public int getPosW() {
        return posW;
    }

    public void setPosW(int posW) {
        this.posW = posW;
    }

    @Override
    public String toString() {
        return String.format("Water Stirring [Current position: %d , Water position: %d\n", posA, posW);
    }
}
