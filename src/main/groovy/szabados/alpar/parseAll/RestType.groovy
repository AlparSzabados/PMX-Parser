package szabados.alpar.parseAll

enum RestType {
    _128TH(5),
    _64TH(4),
    _32ND(3),
    _16TH(2),
    _8TH(1),
    _QUARTER(0),
    _HALF(-1),
    _WHOLE(-2),
    _BREVE(-3),
    _REPEAT_BAR_SIGN(-4),
    _MULTI_BAR_REST(-5),
    _NARROW_DOUBLE_WHOLE(-6),
    _FOUR_BAR_REST(-7),
    _1_BAR_REST(-11),
    _2_BAR_REST(-12),
    _3_BAR_REST(-13),
    _4_BAR_REST(-14),
    _5_BAR_REST(-15),
    _6_BAR_REST(-16),
    _7_BAR_REST(-17),
    _8_BAR_REST(-18),
    _9_BAR_REST(-19);

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