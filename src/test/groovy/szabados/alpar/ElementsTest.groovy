package szabados.alpar

import spock.lang.Specification
import szabados.alpar.parseAll.Elements

import static szabados.alpar.parseAll.Elements.*

class ElementsTest extends Specification {
    def 'should return elements'(){
        when: def elements = getElement(elems)
        then: elements == result

        where: elems          || result
               REST           ||'2.0000'
               NOTE           ||'1.0000'
               TRILL          ||'7.0000'
               CLEF           ||'3.0000'
               SLUR           ||'5.0000'
               BEAM           ||'6.0000'
               LINE           ||'4.0000'
               STAFF          ||'8.0000'
               MISC           ||'9.0000'
               DRAW           ||'11.0000'
               NUMBER         ||'10.0000'
               CIRCLE         ||'12.0000'
               METER          ||'18.0000'
               DUMMY          ||'13.0000'
               BAR_LINE       ||'14.0000'
               KEY_SIGNATURE  ||'17.0000'
               TEXT           ||'t'
               CIEL           ||'15.0000'
    }
}