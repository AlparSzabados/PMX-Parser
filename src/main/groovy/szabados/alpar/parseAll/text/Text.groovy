package szabados.alpar.parseAll.text

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

//TODO add missing fields
@Canonical
class Text extends StaffChild {
    int    staffIndex
    float  horizontalOffset
    float  verticalOffset
    float  kerning
    float  fontSize
    String text
}