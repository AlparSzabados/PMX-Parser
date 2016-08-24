package szabados.alpar.parseAll

enum Accidental {
    NONE(0),
    FLAT(1),
    SHARP(2),
    NATURAL(3),
    DOUBLE_FLAT(4),
    DOUBLE_SHARP(5),
    ONE_FOURTH_TONE_FLAT(6),
    THREE_FOURTH_TONE_FLAT(7),
    ONE_FOURTH_TONE_SHARP(8),
    THREE_FOURTH_TONE_SHARP(9);

    private final int ordinal

    private Accidental(int ordinal) {
        this.ordinal = ordinal
    }

    public static Accidental get(int ordinal){
        for (Accidental accidental : values()) {
            if (ordinal == accidental.ordinal)
                return accidental
        }
        throw new IllegalArgumentException()
    }
}