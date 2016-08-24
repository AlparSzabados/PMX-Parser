package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Note
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff
import szabados.alpar.parseAll.Text

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.Accidental.FLAT

//TODO make it work for the other test too
class TestDriven extends Specification {
    /*@formatter:off*/
    def 'test driven development'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent                                                                                                                         || result
//        't 1 0 -13 1 0.71\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz\nt 1 0 -13 1 0.71\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz'  || new Sheet(staffs: [new Staff(elements: [new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz')], [new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz')])])
        't 1 0 -13 1 0.71\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz\n 8 1 0 200'                                                                    || new Sheet(staffs: [new Staff(elements: [new Text(staffIndex: 1, horizontalOffset: 0.0, verticalOffset: -13.0, kerning: 1.0, fontSize: 0.71, text: '_00?c 2016 Schott Music GmbH & Co. KG, Mainz')])])
        '1 2 0 -13 1 0.71\n8 2 0 200'                                                                                                       || new Sheet(staffs: [new Staff(staffIndex: 2, horizontalOffset: 0.0, rightEnd: 200.0, elements: [new Note(horizontalOffset: 0.0, verticalOffset: -13.0, accidental: FLAT, size: 0.71)])])
    }
    /*@formatter:on*/
}
