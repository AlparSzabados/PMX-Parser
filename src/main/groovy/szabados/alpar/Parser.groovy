package szabados.alpar

import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff
import szabados.alpar.parseAll.StaffChild

import static szabados.alpar.parseAll.Elements.*
import static szabados.alpar.parseAll.Elements.getElement
import static szabados.alpar.parseAll.ParseNote.parseNote
import static szabados.alpar.parseAll.ParseStaff.parseStaff
import static szabados.alpar.parseAll.ParseText.parseText

//TODO make it work for every item
class Parser {
    static Sheet parser(List<List<String>> list) {
        List<Staff> staffs = []
        List<StaffChild> elements = []

        float currentStaff = 0.0
        for (int i in 0..<list.size()) {
            List<String> currentElement = list[i]
            List<String> nextElement = list[i + 1]
            if (currentElement[0] == getElement(STAFF) && currentElement[1].toFloat() != currentStaff) {
                staffs += parseStaff(currentElement)
                currentStaff = currentElement[1].toFloat()
            } else if (currentElement[0] == getElement(STAFF) && currentElement[1].toFloat() == currentStaff) {
                elements += parseStaff(currentElement)
            } else if (currentElement[0] == getElement(NOTE)) {
                elements += parseNote(currentElement)
            } else if (currentElement[0] == getElement(TEXT)) {
                elements += parseText(currentElement, nextElement)
            }
        }

        def staffsNeeded = 0
        for (int i in 0..<elements.size()) {
            if (staffs.size() == 0) {
                staffs += new Staff(staffIndex: elements[i].staffIndex)
                staffsNeeded = elements[i].staffIndex
            }
            for (int j in 0..<staffs.size()) {
                if (elements[i].staffIndex == staffs[j].staffIndex && elements[i].staffIndex > staffsNeeded) {
                    staffsNeeded = elements[i].staffIndex
                } else if (elements[i].staffIndex > staffsNeeded) {
                    staffs += new Staff(staffIndex: elements[i].staffIndex)
                    staffsNeeded = elements[i].staffIndex
                }
            }
        }

        staffs.sort()

        for (int i in 0..<elements.size())
            for (int j in 0..<staffs.size())
                if (elements[i].staffIndex == staffs[j].staffIndex)
                    staffs[j].elements += elements[i]

        return new Sheet(staffs: staffs)
    }
}





