package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.lines.Line
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.staffs.Staff

import static szabados.alpar.Parser.parser
import static szabados.alpar.ReplaceHeader.replaceHeader

class LineTest extends Specification {
    /*@formatter:off*/
    def 'should parse rests'() {
        when: def input = replaceHeader(fileContent)
              def value = parser(input)

        then: value == result

        where:
        fileContent = '4 1.0  2.000 13.00 13.00 6.80 100.0000\n' +
                      '8 1.0  0.000 0.00 0.70\n' +
                      '4 1.0  8.000 0.00 999.00 12.00 -1.0000\n' +
                      '4 1.0  18.000 0.00 0.00 22.00 1.0000\n' +
                      '4 1.0  26.000 0.00 0.00 38.00 1.0000 2.00 6.00\n' +
                      '4 1.0  38.000 0.00 1.00 44.40 -1.0000\n' +
                      '4 1.0  48.000 0.00 1.00 54.40 -3.0000'
        result = new Sheet(elements: [new Staff(staffIndex: 1, horizontalOffset: 0.0, rightEnd: 0.0, size: 0.7, dummyStaff: false, elements:
                [new Line(staffIndex: 1, leftHorizontalPosition: 2, leftVerticalPosition: 13, rightVerticalPosition: 13, rightHorizontalPosition: 6.8, wiggleCurve: 100),
                 new Line(staffIndex: 1, leftHorizontalPosition: 8, leftVerticalPosition: 0, rightVerticalPosition: 999, rightHorizontalPosition: 12, wiggleCurve: -1),
                 new Line(staffIndex: 1, leftHorizontalPosition: 18, leftVerticalPosition: 0, rightVerticalPosition: 0, rightHorizontalPosition: 22, wiggleCurve: 1),
                 new Line(staffIndex: 1, leftHorizontalPosition: 26, leftVerticalPosition: 0, rightVerticalPosition: 0, rightHorizontalPosition: 38, wiggleCurve: 1, dashSize: 2, rotationOrDashSpace: 6),
                 new Line(staffIndex: 1, leftHorizontalPosition: 38, leftVerticalPosition: 0, rightVerticalPosition: 1, rightHorizontalPosition: 44.4, wiggleCurve: -1),
                 new Line(staffIndex: 1, leftHorizontalPosition: 48, leftVerticalPosition: 0, rightVerticalPosition: 1, rightHorizontalPosition: 54.4, wiggleCurve: -3)])])
        /*@formatter:on*/
    }
}
