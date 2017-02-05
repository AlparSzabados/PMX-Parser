package szabados.alpar.parseAll.staffs

import groovy.transform.Canonical

@Canonical
class Staff implements StaffChild {
    int              staffIndex
    float            horizontalOffset
    float            rightEnd
    float            size
}