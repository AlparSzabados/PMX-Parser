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

    private static final List<String> FirstValue = ['1.0000',
                                                    '2.0000',
                                                    '3.0000',
                                                    '4.0000',
                                                    '5.0000',
                                                    '6.0000',
                                                    '7.0000',
                                                    '8.0000',
                                                    '9.0000',
                                                    '10.0000',
                                                    '11.0000',
                                                    '12.0000',
                                                    '13.0000',
                                                    '14.0000',
                                                    '15.0000',
                                                    't',
                                                    '17.0000',
                                                    '18.0000']

    public static getElement(Elements types) {
        return FirstValue[types.ordinal - 1]
    }
}