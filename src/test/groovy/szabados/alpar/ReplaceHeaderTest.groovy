package szabados.alpar

import spock.lang.Specification

class ReplaceHeaderTest extends Specification {
    /*@formatter:off*/
    def 'replace header'() {
        when:   def value = ReplaceHeader.replaceHeader(text)
        then:   value == result

        where: text                                                             || result
               "t 1 0 -13 1 0.71\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz" || [['16', '1', '0', '-13', '1', '0.71'], '_00?c 2016 Schott Music GmbH & Co. KG, Mainz']
               "1 2 0 -13 1 0.71\n8 2 0 200 140"                                || [['1', '2', '0', '-13', '1', '0.71'], ['8', '2', '0', '200', '140']]
    }
    /*@formatter:on*/
}