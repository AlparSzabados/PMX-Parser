package szabados.alpar.parseAll

class ParseText {
    static parseText(List<String> value, String text) {
        /*@formatter:off*/
        return new Text(staffIndex:       value[1].toInteger(),
                        horizontalOffset: value[2].toFloat(),
                        verticalOffset:   value[3].toFloat(),
                        kerning:          value[4].toFloat(),
                        fontSize:         value[5].toFloat(),
                        text:             text)
        /*@formatter:on*/
    }
}