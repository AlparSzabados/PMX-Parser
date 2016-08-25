package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical class Note extends StaffChild {
    int staffIndex
    float horizontalOffset
    float verticalOffset
    int stem
    Accidental accidental
    float accidentalOffset
    int accidParantheses
    NoteHead noteHead
    float duration
    float stemLenght
    float flag
    float dot
    float leftRightDisplacement
    float marks
    int staffDisplacement
    float marksHorizontalOffset
    float marksVerticalOffset
    float size
    float ledgerLineThicknes
    float stemThicknes
    float markSize
}