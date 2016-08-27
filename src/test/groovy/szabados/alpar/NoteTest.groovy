package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Note
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.Accidental.FLAT
import static szabados.alpar.parseAll.NoteHead.BLACK
import static szabados.alpar.parseAll.StemDirection.UP

class NoteTest extends Specification {
    /*@formatter:off*/
    def 'should parse notes'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = '0008.0000 0002.0000 0.0000 0200.0000\n'+
                '0001.0000 0002.0000 0000.0000 -0013.0000 0111.9900 0001.0000 0000.5000 0001.0000 1122.9300 0002.3000 0007.5000 0000.0000 -0001.0000 0002.0000 0000.0000 0000.0000 0002.0000 0001.2000'
        result = new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements:
                [new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, stemDirection: UP, accidental: FLAT, accidentalDisplacement: 0.99, accidentalInParentheses: true, noteHead: BLACK, noteHeadInParentheses: false, duration: 0.5, stemLength: 1, numberOfFlags: 2, numberOfDots: 20, dotsOffset: 1100, dotDisplacement: 0.93, leftRightDisplacement: 2.3, marks: 7.5, staffDisplacement: 0, marksHorizontalOffset: -1, marksVerticalOffset: 2, size: 0, ledgerLineThickness: 0, stemThickness: 2, markSize: 1.2)])])
    }
    /*@formatter:on*/
}