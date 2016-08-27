package szabados.alpar.parseAll

import static szabados.alpar.parseAll.Accidental.getAccidental
import static szabados.alpar.parseAll.Marks.getMarks
import static szabados.alpar.parseAll.NoteHead.getNoteHead
import static szabados.alpar.parseAll.StemDirection.getStemDirection

class ParseNote {
    static parseNote(List<String> value) {
        def value4 = value[4]?.toDouble() ?: 0D
        def accidental = (int) value4 % 10
        def stem = (int) value4 % 100 - accidental
        def accidentalInParentheses = value4 >= 100
        def accidentalOffset = accidentalInParentheses ? value4 - stem - accidental - 100
                : value4 - stem - accidental

        def value5 = (int) value[5]?.toFloat() ?: 0
        def noteHeadInParentheses = value5 >= 10
        def noteHead = noteHeadInParentheses ? value5 - 10 : value5

        def value8 = value[8]?.toDouble() ?: 0D
        def flags = (int) value8 % 10
        def dots = (int) value8 % 100 - flags
        def dotsOffset = (int) value8 - dots - flags
        def dotDisplacement = value8 - flags - dots - dotsOffset

        def value10 = value[10]?.toFloat() ?: 0F
        def mark = (int) value10
        def marksDisplacement = value10 - mark
        /*@formatter:off*/
        return new Note(staffIndex:               value[1]?.toFloat() ?: 0,
                        horizontalPosition:       value[2]?.toFloat() ?: 0,
                        verticalPosition:         value[3]?.toFloat() ?: 0,
                        accidental:               getAccidental(accidental),
                        stemDirection:            getStemDirection(stem),
                        accidentalDisplacement:   accidentalOffset,
                        accidentalInParentheses:  accidentalInParentheses,
                        noteHead:                 getNoteHead(noteHead),
                        noteHeadInParentheses:    noteHeadInParentheses,
                        duration:                 value[6]?.toFloat() ?: 0,
                        stemLength:               value[7]?.toFloat() ?: 0,
                        numberOfFlags:            flags,
                        numberOfDots:             dots,
                        dotsOffset:               dotsOffset,
                        dotDisplacement:          dotDisplacement,
                        leftRightDisplacement:    value[9]?.toFloat() ?: 0,
                        marks:                    getMarks(mark),
                        marksDisplacement:        marksDisplacement,
                        staffDisplacement:        value[11]?.toFloat() ?: 0 as int,
                        marksHorizontalOffset:    value[12]?.toFloat() ?: 0,
                        marksVerticalOffset:      value[13]?.toFloat() ?: 0,
                        size:                     value[14]?.toFloat() ?: 0,
                        ledgerLineThickness:      value[15]?.toFloat() ?: 0,
                        stemThickness:            value[16]?.toFloat() ?: 0,
                        markSize:                 value[17]?.toFloat() ?: 0)
        /*@formatter:on*/
    }
}