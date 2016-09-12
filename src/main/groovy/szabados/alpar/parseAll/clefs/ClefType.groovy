package szabados.alpar.parseAll.clefs

enum ClefType {
    TREBLE(0),
    BASS(1),
    ALTO(2),
    TENOR(3),
    PERCUSSION(4),
    CHORAL_TENOR(0.8 as float),
    OCTAVE_UP(0.88 as float),
    TWO_OCTAVES_UP(0.15 as float),
    BASS_OCTAVE_DOWN(1.8 as float),
    FOUR_STRING(44),
    FIVE_STRING(55),
    SIX_STRING(66)

    private final float ordinal

    private ClefType(float ordinal) {
        this.ordinal = ordinal
    }

    public static ClefType getClefType(float ordinal) {
        for (ClefType clef : values()) {
            if (ordinal == clef.ordinal)
                return clef
        }
        throw new IllegalArgumentException()
    }
}