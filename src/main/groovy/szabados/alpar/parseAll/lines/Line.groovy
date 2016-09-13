package szabados.alpar.parseAll.lines

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Line extends StaffChild {
    int   staffIndex
    float rightHorizontalPosition
    float rightVerticalPosition
    float leftVerticalPosition
    float leftHorizontalPosition
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