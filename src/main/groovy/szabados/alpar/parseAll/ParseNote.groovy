package szabados.alpar.parseAll

import static szabados.alpar.parseAll.Accidental.get

class ParseNote {
    static parseNote(List<String> value) {
        /*@formatter:off*/
        return new Note(horizontalOffset:   value[2].toInteger(),
                        verticalOffset:     value[3].toInteger(),
                        accidental:         get(value[4].toInteger()),
                        size:               value[5].toFloat())
        /*@formatter:on*/
    }
}