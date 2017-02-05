package szabados.alpar.parseAll.slurs

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Slur implements StaffChild {
    int   staffIndex
    float leftHorizontalPosition
    float leftVerticalPosition
    float rightVerticalPosition
    float rightHorizontalPosition
    float curvature
    float offset
    float flattening
    float curveCenter
    float style
    float direction
    float thickness
    float invisibleSlurStart
    float invisibleSlurEnd
    float number
    float numberHorizontalOffset
    float numberVerticalOffset
}