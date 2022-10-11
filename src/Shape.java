public enum Shape {
    TILES("Tiles" , (byte) 1) ,
    HEARTS("Hearts" , (byte) 2) ,
    SPADES("Spades" , (byte) 3),
    CLOVERS("Clovers" , (byte) 4);

    private final String name;
    private final byte number;
    private Shape(String name , byte number) {
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public byte getShapeNum() {
        return number;
    }
}
