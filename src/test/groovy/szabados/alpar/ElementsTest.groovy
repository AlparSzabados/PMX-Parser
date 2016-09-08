package szabados.alpar

import spock.lang.Specification

import static szabados.alpar.parseAll.Elements.*

class ElementsTest extends Specification {
    def 'should return elements'() {
        /*@formatter:off*/
        when: def elements = elementType(elems)
        then: elements == result

        where: elems          || result
               REST           ||'2'
               NOTE           ||'1'
               TRILL          ||'7'
               CLEF           ||'3'
               SLUR           ||'5'
               BEAM           ||'6'
               LINE           ||'4'
               STAFF          ||'8'
               MISC           ||'9'
               DRAW           ||'11'
               NUMBER         ||'10'
               CIRCLE         ||'12'
               METER          ||'18'
               DUMMY          ||'13'
               BAR_LINE       ||'14'
               KEY_SIGNATURE  ||'17'
               TEXT           ||'t'
               CIEL           ||'15'
    }
}