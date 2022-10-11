public enum Value {
    LAS1("Las_small_value",(byte) 1 , (byte) 1),
    LAS2("Las_big_value" , (byte) 1 ,(byte) 11),
    DOS("Dos", (byte) 2, (byte) 2) ,
    TRES("Tres", (byte) 3 , (byte) 3) ,
    CUATRO("Cuatro", (byte) 4 , (byte) 4) ,
    CINCO("Cinco", (byte) 5 , (byte) 5) ,
    SEIS("Seis", (byte) 6 , (byte) 6) ,
    SIETE("Siete", (byte) 7 , (byte) 7) ,
    OCHO("Ocho", (byte) 8 , (byte) 8) ,
    NUEVO("Nuevo", (byte) 9 , (byte) 9) ,
    DIEZ("Diez", (byte) 10 , (byte) 10) ,
    JACK("Jack", (byte) 11 , (byte) 10),
    QUEEN("Queen", (byte) 12 , (byte) 10),
    KING("King", (byte) 13 , (byte) 10);
    private final String name;
    private final byte number;
    private final byte value;

    Value(String name, byte number , byte value) {
        this.name = name;
        this.number = number;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public byte getCardVal() {
        return value;
    }

    public byte getCardNum() {
        return number;
    }
}