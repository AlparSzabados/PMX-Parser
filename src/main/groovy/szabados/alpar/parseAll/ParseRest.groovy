package szabados.alpar.parseAll

import static szabados.alpar.parseAll.RestType.*

class ParseRest {
    static parseRest(List<String> value) {
        return new Rests([
                staffIndex            : value[1]?.toFloat() ?: 0,
                horizontalPosition    : value[2]?.toFloat() ?: 0,
                verticalPosition      : value[3]?.toFloat() ?: 0,
                restType              : getRestType(value[4].toFloat() as int),
                dots                  : value[5]?.toFloat() ?: 0,
                duration              : value[6]?.toFloat() ?: 0,
                number                : value[7]?.toFloat() ?: 0,
                centering             : value[8]?.toFloat() ?: 0,
                horizontalDisplacement: value[9]?.toFloat() ?: 0,
                numberVerticalOffset  : value[10]?.toFloat() ?: 0,
                numberSize            : value[11]?.toFloat() ?: 0,
                cues                  : value[12]?.toFloat() ?: 0,
                numberFont            : value[13]?.toFloat() ?: 0,
                size                  : value[14]?.toFloat() ?: 0,
                numberHorizontalOffset: value[15]?.toFloat() ?: 0
        ])
    }
}