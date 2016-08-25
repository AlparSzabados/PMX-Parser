package szabados.alpar.parseAll

enum MusicalElements {
    NOTE(1),
    REST(2),
    TEXT(16),
    STAFF(8)

    private final int ordinal

    private MusicalElements(int ordinal) {
        this.ordinal = ordinal
    }

    private static final List<String> listFirstIndex = ['1.0000', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', 't']

    public static getElement(MusicalElements types) {
        return listFirstIndex[types.ordinal - 1]
    }
}