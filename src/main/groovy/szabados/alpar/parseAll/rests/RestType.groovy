package szabados.alpar.parseAll.rests

enum RestType {
    _128TH(5),
    _64TH(4),
    _32ND(3),
    _16TH(2),
    _8TH(1),
    QUARTER(0),
    HALF(-1),
    WHOLE(-2),
    BREVE(-3),
    REPEAT_BAR_SIGN(-4),
    MULTI_BAR_REST(-5),
    NARROW_DOUBLE_WHOLE(-6),
    FOUR_BAR_REST(-7),
    ONE_BAR_REST(-11),
    TWO_BAR_REST(-12),
    THREE_BAR_REST(-13),
    FOUT_BAR_REST(-14),
    FIVE_BAR_REST(-15),
    SIX_BAR_REST(-16),
    SEVEN_BAR_REST(-17),
    EIGHT_BAR_REST(-18),
    NINE_BAR_REST(-19);

    private final int ordinal

    private RestType(int ordinal) {
        this.ordinal = ordinal
    }

    public static RestType getRestType(int ordinal) {
        for (RestType restType : values()) {
            if (ordinal == restType.ordinal)
                return restType
        }
        throw new IllegalArgumentException()
    }
}