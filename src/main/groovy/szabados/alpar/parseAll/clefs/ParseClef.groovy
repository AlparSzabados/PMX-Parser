package szabados.alpar.parseAll.clefs

class ParseClef {
    static parseClef(List<String> value) {
        return new Clef([
                staffIndex          : value[1]?.toFloat() ?: 0,
                horizontalPosition  : value[2]?.toFloat() ?: 0,
                verticalPosition    : value[3]?.toFloat() ?: 0,
                clefType            : ClefType.getClefType(value[4].toFloat()),
                size                : value[5]?.toFloat() ?: 0,
                verticalSize        : value[6]?.toFloat() ?: 0,
                verticalDisplacement: value[14].toFloat() ?: 0
        ])
    }
}