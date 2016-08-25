package szabados.alpar.parseAll

import static szabados.alpar.parseAll.Accidental.getAccidental
import static szabados.alpar.parseAll.NoteHead.*
import static Condition.*

class ParseNote {
    static parseNote(List<String> value) {
        /*@formatter:off*/
        def value4 = value[4].toDouble()
        def value5 = value[5].toInteger()
        return new Note(staffIndex:         value[1].toFloat(),
                        horizontalOffset:   value[2].toFloat(),
                        verticalOffset:     value[3].toFloat(),
                        stem:               stripStem(value4),
                        accidental:         getAccidental(stripAccidental(value4)),
                        accidentalOffset:   stripAccidOffset(value4),
                        accidParantheses:   (value4 >= 100) ? 100 : 0,
                        noteHead:           getNoteHead((value5 >= 10) ? (value5 - 10) : value5),
                        noteHeadParantheses: value5 >= 10 ? YES : NO)
//                        size:               value[].toFloat())
        /*@formatter:on*/
    }

    static stripStem(Double n) {
        if (n >= 100)
            n -= 100
        if (n >= 10)
            return n - (n % 10)
        else return 0
    }

    static stripAccidental(Double n) {
        if (n >= 100)
            n -= 100
        if (n >= 20)
            n -= 20
        if (n >= 10 && n < 20)
            n -= 10
        return n as int

    }

    static stripAccidOffset(Double n) {
        int n1 = (int) Math.floor(n)
        n - n1
    }
}