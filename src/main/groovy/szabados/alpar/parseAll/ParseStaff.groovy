package szabados.alpar.parseAll

class ParseStaff {
    static parseStaff(List<String> value) {
        /*@formatter:off*/
        return new Staff(staffIndex:       value[1].toInteger(),
                         horizontalOffset: value[2].toInteger(),
                         rightEnd:         value[3].toFloat())
        /*@formatter:on*/
    }
}