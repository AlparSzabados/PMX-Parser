package szabados.alpar.parseAll.clefs

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Clef implements StaffChild {
    int      staffIndex
    float    horizontalPosition
    float    verticalPosition
    ClefType clefType
    float    size
    float    verticalSize
    float    verticalDisplacement
}