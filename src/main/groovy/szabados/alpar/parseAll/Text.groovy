package szabados.alpar.parseAll

import groovy.transform.Canonical

//TODO add missing fields
@Canonical
class Text extends StaffChild {
    int staffIndex
    float horizontalOffset
    float verticalOffset
    float kerning
    float fontSize
    String text
}