package szabados.alpar.parseAll.slurs

class ParseSlur {
    static parseSlur(List<String> value) {
        return new Slur([staffIndex             : value[1]?.toFloat() ?: 0,
                         leftHorizontalPosition : value[2]?.toFloat() ?: 0,
                         leftVerticalPosition   : value[3]?.toFloat() ?: 0,
                         rightVerticalPosition  : value[4]?.toFloat() ?: 0,
                         rightHorizontalPosition: value[5]?.toFloat() ?: 0,
                         curvature              : value[6]?.toFloat() ?: 0,
                         offset                 : value[7]?.toFloat() ?: 0,
                         flattening             : value[8]?.toFloat() ?: 0,
                         curveCenter            : value[9]?.toFloat() ?: 0,
                         style                  : value[10]?.toFloat() ?: 0,
                         direction              : value[11]?.toFloat() ?: 0,
                         thickness              : value[12]?.toFloat() ?: 0,
                         invisibleSlurStart     : value[13]?.toFloat() ?: 0,
                         invisibleSlurEnd       : value[14]?.toFloat() ?: 0,
                         number                 : value[15]?.toFloat() ?: 0,
                         numberHorizontalOffset : value[16]?.toFloat() ?: 0,
                         numberVerticalOffset   : value[17]?.toFloat() ?: 0])
    }
}