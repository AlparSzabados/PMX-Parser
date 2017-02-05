package szabados.alpar.parseAll.lines

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Line implements StaffChild {
    int   staffIndex
    float leftHorizontalPosition
    float leftVerticalPosition
    float rightVerticalPosition
    float rightHorizontalPosition
    float wiggleCurve
    float dashSize
    float rotationOrDashSpace
    float thickness
    float leftVerticalBracket
    float rightVerticalBracket
    float rotation
    float crescendoStart
    float crescendoEnd
    float addedHorizontalPoint
    float addedVerticalPoint
}