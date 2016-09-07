package szabados.alpar.parseAll

class ParseStaff {
    static parseStaff(List<String> value) {
        /*@formatter:off*/
        return new Staff(staffIndex:       value[1]?.toFloat() ?: 0,
                         horizontalOffset: value[2]?.toFloat() ?: 0,
                         rightEnd:         value[3]?.toFloat() ?: 0,
                         size:             value[4]?.toFloat() ?: 0)
        /*@formatter:on*/
    }
}