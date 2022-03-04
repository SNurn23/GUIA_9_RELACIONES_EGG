public class Carta {
    private int num;
    private PaloEnum palo;

    public Carta(int num, PaloEnum palo) {
        this.num = num;
        this.palo = palo;
    }

    public Carta() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public PaloEnum getPalo() {
        return palo;
    }

    public void setPalo(PaloEnum palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return String.format("Carta[ Num: %d, Palo: %s ] \n",num,palo);
    }
}
