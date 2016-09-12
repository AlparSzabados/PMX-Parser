package szabados.alpar.parseAll.text

class ParseText {
    static parseText(List<String> value, List<String> text) {
        /*@formatter:off*/
        return new Text(staffIndex:       value[1].toFloat(),
                        horizontalOffset: value[2].toFloat(),
                        verticalOffset:   value[3].toFloat(),
                        kerning:          value[4].toFloat(),
                        fontSize:         value[5].toFloat(),
                        text:             text[0])
        /*@formatter:on*/
    }
}