package szabados.alpar.parseAll

enum Elements {
    NOTE(1),
    REST(2),
    CLEF(3),
    LINE(4),
    SLUR(5),
    BEAM(6),
    TRILL(7),
    STAFF(8),
    MISC(9),
    NUMBER(10),
    DRAW(11),
    CIRCLE(12),
    DUMMY(13),
    BAR_LINE(14),
    CIEL(15),
    TEXT(16),
    KEY_SIGNATURE(17),
    METER(18)

    private final int ordinal

    private Elements(int ordinal) {
        this.ordinal = ordinal
    }

    public static elementType(Elements types) {
        if (types.ordinal == 16) return 't'
        "${types.ordinal}"
    }
}