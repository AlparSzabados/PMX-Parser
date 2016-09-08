package szabados.alpar

import spock.lang.Specification

import static szabados.alpar.ReplaceHeader.replaceHeader

class ReplaceHeaderTest extends Specification {
    /*@formatter:off*/
    def 'replace header'() {
        when:   def value = replaceHeader(text)
        then:   value == result

        where: text                                                                                                 || result
               't 0001.0000 0000.0000 -0013.0000 0001.0000 0000.7100\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz' || [['t', '1.0000', '0.0000', '-13.0000', '1.0000', '0.7100'], ['_00?c 2016 Schott Music GmbH & Co. KG, Mainz']]
               '1 0002.0000 0000.0000 -0013.0000 0001.0000 0000.7100\n8 0002.0000 0000.0000 0200.0000 0140.0000'    || [['1', '2.0000', '0.0000', '-13.0000', '1.0000', '0.7100'], ['8', '2.0000', '0.0000', '200.0000', '140.0000']]
    }

    def 'remove leading zeroes'(){
        when:   def value = replaceHeader(text)
        then:   value == result

        where: text                                                                                                  || result
               '1.000 0002.3000 0008.2314'                                                                           || [['1.000', '2.3000', '8.2314']]
               ' t 0001.0000 0000.0000 -0013.0000 0001.0000 0000.7100\n_00?c 2016 Schott Music GmbH & Co. KG, Mainz' || [['t', '1.0000', '0.0000', '-13.0000', '1.0000', '0.7100'], ['_00?c 2016 Schott Music GmbH & Co. KG, Mainz']]
    }
    /*@formatter:on*/
}