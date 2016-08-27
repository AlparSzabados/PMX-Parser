package szabados.alpar.parseAll

import groovy.transform.Canonical

@ Canonical
class Staff extends StaffChild {
    int staffIndex
    float horizontalOffset
    float rightEnd
    List<StaffChild> elements = []
}