package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical class Note {
    float horizontalOffset
    float verticalOffset
    Accidental accidental
    float size
}