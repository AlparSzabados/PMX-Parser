package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.clefs.Clef
import szabados.alpar.parseAll.staffs.Staff

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.clefs.ClefType.TREBLE

class ClefTest extends Specification {
    /*@formatter:off*/
    def 'should parse rests'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)
        then: value == result

        where:
        fileContent = ' 8  0001.0000  0000.0000  0000.0000  0000.8500\n' +
                      ' 3  0001.0000  0004.5000  0002.0000  0000.0000  0000.0000  0001.0000 0000.0000 0000.0000 0000.0000 0000.0000 0000.0000 0000.0000 0000.0000 0002.0000 '
        result = new Sheet(elements: [
                 new Staff(staffIndex: 1, horizontalOffset: 0.0, rightEnd: 0.0, size: 0.85),
                 new Clef(staffIndex: 1, horizontalPosition: 4.5, verticalPosition: 2, clefType: TREBLE, size: 0, verticalSize: 1, verticalDisplacement: 2)])
        /*@formatter:on*/
    }
}