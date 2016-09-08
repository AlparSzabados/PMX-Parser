package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical
class Rests extends StaffChild {
    int      staffIndex
    float    horizontalPosition
    float    verticalPosition
    RestType restType
    float    dots
    float    duration
    float    number
    float    centering
    float    horizontalDisplacement
    float    numberVerticalOffset
    float    numberSize
    float    cues
    float    numberFont
    float    size
    float    numberHorizontalOffset
}