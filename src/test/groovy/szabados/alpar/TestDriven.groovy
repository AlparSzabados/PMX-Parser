package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.*

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.Accidental.FLAT
import static szabados.alpar.parseAll.Condition.NO
import static szabados.alpar.parseAll.NoteHead.BLACK

//TODO make it work for the other test too
class TestDriven extends Specification {
    /*@formatter:off*/
    def 'test driven development'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent                                                         || result
        '0001.0000 0002.0000 0000.0000 -0013.0000 0111.9900 1 0000.7100\n'+
        '8 2 0 200'                                                         || new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements: [new Note(staffIndex: 2, horizontalOffset: 0.0, verticalOffset: -13.0, stem: 10, accidental: FLAT, accidentalOffset: 0.99, accidParantheses: 100, noteHead: BLACK, noteHeadParantheses: NO)])])

        '8 2 0 200\n'+
        '8 2 0 150\n'+
        '0001.0000 2 0 -13 1 1'                                             || new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 200, elements: [new Staff(staffIndex: 2, horizontalOffset: 0, rightEnd: 150),
                                                                                                                                                                          new Note(staffIndex: 2, horizontalOffset: 0.0, verticalOffset: -13.0, accidental: FLAT, noteHead: BLACK, noteHeadParantheses: NO)])])

        't 1 0 -13 1 0.71\n'+
        '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
        't 1 0 -13 1 0.71\n'+
        '_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n'+
        '0001.0000 2 0 -13 1 1\n'+
        '8 2 0 200'                                                          || new Sheet(staffs: [new Staff(staffIndex: 1, elements: [new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz'),
                                                                                                                                   new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz')]),
                                                                                                   new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements: [new Note(staffIndex: 2, horizontalOffset: 0.0, verticalOffset: -13.0, accidental: FLAT, noteHead: BLACK, noteHeadParantheses: NO)])])
    }
    /*@formatter:on*/
}
