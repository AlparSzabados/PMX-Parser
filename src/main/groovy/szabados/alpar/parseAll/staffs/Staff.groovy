package szabados.alpar.parseAll.staffs

import groovy.transform.Canonical

@Canonical
class Staff extends StaffChild {
    int              staffIndex
    float            horizontalOffset
    float            rightEnd
    float            size
    boolean          dummyStaff = false
    List<StaffChild> elements   = []
}