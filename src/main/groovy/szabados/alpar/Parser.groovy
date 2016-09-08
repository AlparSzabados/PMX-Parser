package szabados.alpar

import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.Staff
import szabados.alpar.parseAll.StaffChild

import static szabados.alpar.parseAll.Elements.*
import static szabados.alpar.parseAll.ParseNote.parseNote
import static szabados.alpar.parseAll.ParseRest.parseRest
import static szabados.alpar.parseAll.ParseStaff.parseStaff
import static szabados.alpar.parseAll.ParseText.parseText

//TODO make it work for every item
class Parser {
    static Sheet parser(List<List<String>> list) {
        List<Staff> staffs = []
        List<StaffChild> staffElements = []

        float currentStaffIndex = 0.0
        for (int i in 0..<list.size()) {
            List<String> currentElement = list[i]
            List<String> nextElement = list[i + 1]
            String musicalElement = currentElement[0]
            float musicalElementStaffIndex = currentElement[1]?.toFloat() ?: 0

            if (musicalElement == elementType(STAFF) && musicalElementStaffIndex != currentStaffIndex) {
                staffs += parseStaff(currentElement)
                currentStaffIndex = musicalElementStaffIndex
            } else if (musicalElement == elementType(STAFF) && musicalElementStaffIndex == currentStaffIndex)
                staffElements += parseStaff(currentElement)
            else if (musicalElement == elementType(NOTE))
                staffElements += parseNote(currentElement)
            else if (musicalElement == elementType(REST))
                staffElements += parseRest(currentElement)
            else if (musicalElement == elementType(TEXT))
                staffElements += parseText(currentElement, nextElement)
            else if (musicalElement == elementType(REST))
                staffElements += parseRest(currentElement)
        }

        def staffsNeeded = 0
        for (int i in 0..<staffElements.size()) {
            if (staffs.size() == 0) {
                staffs += new Staff(staffIndex: staffElements[i].staffIndex)
                staffsNeeded = staffElements[i].staffIndex
            }
            for (int j in 0..<staffs.size()) {
                if (staffElements[i].staffIndex == staffs[j].staffIndex && staffElements[i].staffIndex > staffsNeeded) {
                    staffsNeeded = staffElements[i].staffIndex
                } else if (staffElements[i].staffIndex > staffsNeeded) {
                    staffs += new Staff(staffIndex: staffElements[i].staffIndex)
                    staffsNeeded = staffElements[i].staffIndex
                }
            }
        }

        staffs.sort()

        for (int i in 0..<staffElements.size())
            for (int j in 0..<staffs.size())
                if (staffElements[i].staffIndex == staffs[j].staffIndex)
                    staffs[j].elements += staffElements[i]

        return new Sheet(staffs: staffs)
    }
}