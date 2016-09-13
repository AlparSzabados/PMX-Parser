package szabados.alpar.parseAll.lines

class ParseLine {
    static parseLine(List<String> value) {
//        def lineWiggle = value[6]?.toFloat() ?: 0
//        def line = 0
//        def wiggle = 0
//        (lineWiggle > -2) ? (line = lineWiggle.toInteger()) : (wiggle = lineWiggle)
        return new Line([staffIndex             : value[1]?.toFloat() ?: 0,
                         leftHorizontalPosition : value[2]?.toFloat() ?: 0,
                         leftVerticalPosition   : value[3]?.toFloat() ?: 0,
                         rightVerticalPosition  : value[4]?.toFloat() ?: 0,
                         rightHorizontalPosition: value[5]?.toFloat() ?: 0,
//                         lineType               : getLineType(line),
                         wiggleCurve            : value[6]?.toFloat() ?: 0,
                         dashSize               : value[7]?.toFloat() ?: 0,
                         rotationOrDashSpace    : value[8]?.toFloat() ?: 0,
                         thickness              : value[9]?.toFloat() ?: 0,
                         leftVerticalBracket    : value[10]?.toFloat() ?: 0,
                         rightVerticalBracket   : value[11]?.toFloat() ?: 0,
                         rotation               : value[12]?.toFloat() ?: 0,
                         crescendoStart         : value[13]?.toFloat() ?: 0,
                         crescendoEnd           : value[14]?.toFloat() ?: 0])
    }
}