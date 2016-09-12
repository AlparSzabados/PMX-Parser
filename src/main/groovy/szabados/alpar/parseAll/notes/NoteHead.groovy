package szabados.alpar.parseAll.notes

enum NoteHead {
    DEFAULT(0),
    BLACK(1),
    HALF(2),
    WHOLE(3),
    BREVE(4),
    WHITE_DIAMOND(5),
    BLACK_DIAMOND(6),
    X_NOTE(7),
    HEADLESS(8),
    DIAMOND_X(9),
    OVAL_X(10);

    private final int ordinal

    private NoteHead(int ordinal) {
        this.ordinal = ordinal
    }

    public static NoteHead getNoteHead(int ordinal) {
        for (NoteHead noteHead : values()) {
            if (ordinal == noteHead.ordinal)
                return noteHead
        }
        throw new IllegalArgumentException()
    }
}