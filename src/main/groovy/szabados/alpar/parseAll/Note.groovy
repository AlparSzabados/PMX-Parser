package szabados.alpar.parseAll

import groovy.transform.Canonical

@Canonical
class Note extends StaffChild {
    int           staffIndex
    float         horizontalPosition
    float         verticalPosition
    Accidental    accidental
    StemDirection stemDirection
    float         accidentalDisplacement
    boolean       accidentalInParentheses
    NoteHead      noteHead
    boolean       noteHeadInParentheses
    float         duration
    float         stemLength
    int           numberOfFlags
    int           numberOfDots
    int           dotsOffset
    float         dotDisplacement
    float         leftRightDisplacement
    Marks         marks
    float         marksDisplacement
    int           staffDisplacement
    float         marksHorizontalOffset
    float         marksVerticalOffset
    float         size
    float         ledgerLineThickness
    float         stemThickness
    float         markSize
}