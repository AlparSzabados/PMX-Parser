package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Note
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff
import szabados.alpar.parseAll.Text

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.Accidental.FLAT
import static szabados.alpar.parseAll.NoteHead.BLACK
import static szabados.alpar.parseAll.StemDirection.NO_STEM
import static szabados.alpar.parseAll.StemDirection.UP

//TODO make it work for the other test too
class TestDriven extends Specification {
    /*@formatter:off*/
    def 'test driven development'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent                                                                 || result
        '0001.0000 0002.0000 0000.0000 -0013.0000 0111.9900 0001.0000 0000.5000\n'+
        '0008.0000 0002.0000 0.0000 0200.0000'                                      || new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements: [new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, stemDirection: UP, accidental: FLAT, accidentalDisplacement: 0.99, accidentalInParentheses: true, noteHead: BLACK, noteHeadInParentheses: false, duration: 0.5)])])

        '0008.0000 0002.0000 0.0000 0200.0000\n'+
        '0008.0000 0002.0000 0.0000 0150.0000\n'+
        '0001.0000 0002.0000 0.0000 -0013.0000 1.0000 1.0000'                       || new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 200, elements: [new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 150),
                                                                                                                                                                                  new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, accidental: FLAT, stemDirection: NO_STEM, noteHead: BLACK, noteHeadInParentheses: false)])])

        't 1.0000 0.0000 -0013.0000 0001.0000 0.7100\n'+
        '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
        't 1.0000 0.0000 -0013.0000 1.0000 0.7100\n'+
        '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
        '0001.0000 0002.0000 0.0000 -0013.0000 1.0000 1.0000\n'+
        '0008.0000 0002.0000 0.0000 0200.0000'                                      || new Sheet(staffs: [new Staff(staffIndex: 1, elements: [new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                                                                                                                                   new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz')]),
                                                                                                                                   new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements: [new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, accidental: FLAT, stemDirection: NO_STEM, noteHead: BLACK, noteHeadInParentheses: false)])])
    }
    /*@formatter:on*/
}
