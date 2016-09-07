package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical
class Staff extends StaffChild {
    int staffIndex
    float horizontalOffset
    float rightEnd
    float size
    List<StaffChild> elements = []
}