package szabados.alpar.parseAll

import groovy.transform.Canonical

@ Canonical class Staff {
    int staffIndex
    float horizontalOffset
    float rightEnd
    List<StaffChild> elements = []
}
