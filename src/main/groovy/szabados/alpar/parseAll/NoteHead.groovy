package szabados.alpar.parseAll

enum NoteHead {
    BLACK(0),
    HALF(1),
    WHOLE(2),
    BREVE(3),
    WHITE_DIAMOND(4),
    BLACK_DIAMOND(5),
    X_NOTE(6),
    HEADLESS(7),
    DIAMOND_X(8),
    OVAL_X(9);

    private final int ordinal

    private NoteHead(int ordinal) {
        this.ordinal = ordinal
    }

    public static NoteHead getNoteHead(int ordinal){
        for (NoteHead noteHead : values()) {
            if (ordinal == noteHead.ordinal)
                return noteHead
        }
        throw new IllegalArgumentException()
    }
}