package szabados.alpar.parseAll.lines

enum LineType {
    DASH(1),
    LINE(0),
    WIGGLE(-1);

    private final int ordinal

    private LineType(int ordinal) {
        this.ordinal = ordinal
    }

    public static LineType getLineType(int ordinal) {
        for (LineType line : values()) {
            if (ordinal == line.ordinal)
                return line
        }
        throw new IllegalArgumentException()
    }
}
