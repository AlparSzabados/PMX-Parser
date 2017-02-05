package szabados.alpar.parseAll.rests

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Rest implements StaffChild {
    int      staffIndex
    float    horizontalPosition
    float    verticalPosition
    RestType restType
    float    dots
    float    duration
    float    number
    float    centering
    float    horizontalDisplacement
    float    numberVerticalOffset
    float    numberSize
    float    cues
    float    numberFont
    float    size
    float    numberHorizontalOffset
}