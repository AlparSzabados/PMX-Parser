package szabados.alpar

import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff

import static szabados.alpar.parseAll.ParseNote.parseNote
import static szabados.alpar.parseAll.ParseStaff.parseStaff
import static szabados.alpar.parseAll.ParseText.parseText

//TODO make it work for every item
class Parser {
    static parser(List list) {
        Staff staff
        List<Staff> staves = []

        for (i in 0..<list.size()-1) {
            def currentItem = list[i]
            def nextItem = list[i + 1]

            List elements = []

            if (currentItem[1] == '8') {
                staves += parseStaff(currentItem)
            } else {
                staff = new Staff()
            }

            if (currentItem[1].toString().toInteger() == staves.staffIndex || staff.staffIndex == 0) {
                if (currentItem[0] == '1') {
                    elements += parseNote(currentItem)
                }

                if (currentItem[0] == 't' && nextItem instanceof String) {
                    elements += parseText(currentItem, nextItem)
                }
            }

            if (staves != null)
                staves.elements = elements
            else
                staff.elements = elements
        }

        if (staves != null) {
            return new Sheet(staffs: staves)
        } else
            return new Sheet(staffs: staff)
    }
}
