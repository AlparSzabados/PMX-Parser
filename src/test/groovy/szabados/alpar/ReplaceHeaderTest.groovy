package szabados.alpar

import spock.lang.Specification

import static szabados.alpar.ReplaceHeader.*

class ReplaceHeaderTest extends Specification {
    /*@formatter:off*/
    def 'replace header'() {
        when:   def value = replaceHeader(text)
        then:   value == result

        where: text                                                             || result
               't 1 0 -13 1 0.71\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz' || [['t', '1', '0', '-13', '1', '0.71'], ['_00?c 2016 Schott Music GmbH & Co. KG, Mainz']]
               '1 2 0 -13 1 0.71\n8 2 0 200 140'                                || [['1', '2', '0', '-13', '1', '0.71'], ['8', '2', '0', '200', '140']]
    }

    def 'remove leading zeroes'(){
        when:   def value = replaceHeader(text)
        then:   value == result

        where: text                                                                                                  || result
               '0001.000 0002.3000 0008.2314'                                                                        || [['1.000', '2.3000', '8.2314']]
               ' t 0001.0000 0000.0000 -0013.0000 0001.0000 0000.7100\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz' || [['t', '1.0000', '.0000', '-13.0000', '1.0000', '0.7100'], ['_00?c 2016 Schott Music GmbH & Co. KG, Mainz']]
    }
    /*@formatter:on*/
}