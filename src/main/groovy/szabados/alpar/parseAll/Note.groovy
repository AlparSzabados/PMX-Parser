package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical class Note extends StaffChild {
    int staffIndex
    float horizontalOffset
    float verticalOffset
    Accidental accidental
    float size
}