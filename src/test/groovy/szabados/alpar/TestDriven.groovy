package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.notes.Note
import szabados.alpar.parseAll.staffs.Staff
import szabados.alpar.parseAll.text.Text

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.notes.Accidentals.FLAT
import static szabados.alpar.parseAll.notes.Marks.NONE
import static szabados.alpar.parseAll.notes.NoteHead.BLACK
import static szabados.alpar.parseAll.notes.StemDirection.NO_STEM

class TestDriven extends Specification {
    /*@formatter:off*/
    def 'multiple staffs on the same line'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = '8 0002.0000 0.0000 0200.0000\n'+
                      '8 0002.0000 0.0000 0150.0000\n'+
                      '1 0002.0000 0.0000 -0013.0000 1.0000 1.0000'
        result = new Sheet(elements: [
                 new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 200),
                 new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 150),
                 new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, accidental: FLAT, stemDirection: NO_STEM, noteHead: BLACK, noteHeadInParentheses: false, marks: NONE)])
        }

    def 'test repeating text'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = 't 1.0000 0.0000 -0013.0000 0001.0000 0.7100\n'+
                      '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
                      't 1.0000 0.0000 -0013.0000 1.0000 0.7100\n'+
                      '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
                      '1 0002.0000 0.0000 -0013.0000 1.0000 1.0000\n'+
                      '8 0002.0000 0.0000 0200.0000'
         result = new Sheet(elements: [
                 new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                 new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                 new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, accidental: FLAT, stemDirection: NO_STEM, noteHead: BLACK, noteHeadInParentheses: false, marks: NONE),
                 new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0)])
    }

    def 'test no staff with elements' () {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = 't 0001.0000 0.0000 -0013.0000 0001.0000 0.7100\n'+
                      '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
                      't 0001.0000 0.0000 -0013.0000 1.0000 0.7100\n'+
                      '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
                      '1 0002.0000 0.0000 -0013.0000 1.0000 1.0000'
        result = new Sheet(elements: [
                 new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                 new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                 new Note(staffIndex: 2, horizontalPosition: 0.0, verticalPosition: -13.0, accidental: FLAT, stemDirection: NO_STEM, noteHead: BLACK, noteHeadInParentheses: false, marks: NONE)])
    }
    /*@formatter:on*/
}