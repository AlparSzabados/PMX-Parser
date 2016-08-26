package szabados.alpar.parseAll

enum StemDirection {
    NO_STEM(0),
    UP(10),
    DOWN(20)

    private final int ordinal

    private StemDirection(int ordinal) {
        this.ordinal = ordinal
    }

    public static StemDirection getStemDirection(int ordinal) {
        for (StemDirection stems : values()) {
            if (stems.ordinal == ordinal)
                return stems
        }
        throw new IllegalArgumentException()
    }
}