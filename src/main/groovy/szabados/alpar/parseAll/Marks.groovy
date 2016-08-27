package szabados.alpar.parseAll

enum Marks {
    NONE(0),
    FLAT(1),
    SHARP(2),
    NATURAL(3),
    WEDGE(4),
    ACCENT(5),
    TENUTO(6),
    STACCATO(7),
    WEDGE_STACCATO(8),
    ACCENT_STACCATO(9),
    TENUTO_STACCATO(10),
    DOWN_BOW(11),
    UP_BOW(12),
    HARMONIC(13),
    FERMATA(14),
    ARSIS_SIGN(15),
    THESIS_SIGN(16),
    MORDANT(17),
    INVERTED_MORDANT(18),
    HEAVY_WEDGE(19),
    TRILL(20),
    TRILL_FLAT(21),
    TRILL_SHARP(22),
    TRILL_NATURAL(23),
    PLUS(24),
    ACCENT_TENUTO(25),
    DOUBLE_STACCATO(26),
    TRIPLE_STACCATO(27),
    QUAD_STACCATO(28),
    _(29),
    FINGERING_0(30),
    FINGERING_1(31),
    FINGERING_2(32),
    FINGERING_3(33),
    FINGERING_4(34),
    FINGERING_5(35),
    FINGERING_6(36)

    private final int ordinal

    private Marks(int ordinal) {
        this.ordinal = ordinal
    }

    public static Marks getMarks(int ordinal) {
        for (Marks marks : values()) {
            if (ordinal == marks.ordinal)
                return marks
        }
        throw new IllegalArgumentException()
    }
}