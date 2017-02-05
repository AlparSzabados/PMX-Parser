package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.rests.Rest
import szabados.alpar.parseAll.staffs.Staff

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader
import static szabados.alpar.parseAll.rests.RestType.*

class RestTest extends Specification {
    /*@formatter:off*/
    def 'should parse rests'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = ' 8  0001.0000  0000.0000  0000.0000  0000.8500\n' +
                ' 2  0001.0000  0004.5000  0002.0000  0000.0000  0000.0000  0001.0000\n' +
                ' 2  0001.0000  0029.8571  0000.0000 -0001.0000  0000.0000  0002.0000 -0001.0000  0000.0000  0000.0000  0003.0000  0002.0000\n' +
                ' 2  0001.0000  0096.5714  0000.0000 -0002.0000  0000.0000  0004.0000  0001.0000'
        result = new Sheet(elements: [new Staff(staffIndex: 1, horizontalOffset: 0.0, rightEnd: 0.0, size: 0.85, dummyStaff: false, elements:
                [new Rest(staffIndex: 1, horizontalPosition: 4.5, verticalPosition: 2, restType: QUARTER, dots: 0, duration: 1),
                 new Rest(staffIndex: 1, horizontalPosition: 29.8571, verticalPosition: 0, restType: HALF, dots: 0, duration: 2, number: -1, centering: 0, horizontalDisplacement: 0, numberVerticalOffset: 3, numberSize: 2),
                 new Rest(staffIndex: 1, horizontalPosition: 96.5714, verticalPosition: 0, restType: WHOLE, dots: 0, duration: 4, number: 1)])])
        /*@formatter:on*/
    }
}