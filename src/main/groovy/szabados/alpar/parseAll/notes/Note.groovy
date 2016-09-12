package szabados.alpar.parseAll.notes

import groovy.transform.Canonical
import szabados.alpar.parseAll.staffs.StaffChild

@Canonical
class Note extends StaffChild {
    int           staffIndex
    float         horizontalPosition
    float         verticalPosition
    Accidentals   accidental
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