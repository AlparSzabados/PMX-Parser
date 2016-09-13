package szabados.alpar

import szabados.alpar.parseAll.ParseSlur
import szabados.alpar.parseAll.lines.ParseLine
import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.staffs.Staff
import szabados.alpar.parseAll.staffs.StaffChild

import static szabados.alpar.parseAll.Elements.*
import static ParseLine.*
import static szabados.alpar.parseAll.ParseSlur.*
import static szabados.alpar.parseAll.clefs.ParseClef.parseClef
import static szabados.alpar.parseAll.notes.ParseNote.parseNote
import static szabados.alpar.parseAll.rests.ParseRest.parseRest
import static szabados.alpar.parseAll.staffs.ParseStaff.parseStaff
import static szabados.alpar.parseAll.text.ParseText.parseText

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

            switch (musicalElement) {
                case elementType(STAFF):
                    if (musicalElementStaffIndex == currentStaffIndex) {
                        staffElements += parseStaff(currentElement)
                    } else {
                        staffs += parseStaff(currentElement)
                        currentStaffIndex = musicalElementStaffIndex
                    }
                    break;
                case elementType(NOTE): staffElements += parseNote(currentElement); break
                case elementType(REST): staffElements += parseRest(currentElement); break
                case elementType(CLEF): staffElements += parseClef(currentElement); break
                case elementType(LINE): staffElements += parseLine(currentElement); break
                case elementType(SLUR): staffElements += parseSlur(currentElement); break
                case elementType(TEXT): staffElements += parseText(currentElement, nextElement); break
            }
        }

        staffs = createMissingStaffs(staffs, staffElements)

        combineStaffsWithElements(staffs, staffElements)

        staffs.sort { a, b -> a.staffIndex <=> b.staffIndex }

        return new Sheet(staffs: staffs)
    }

    static combineStaffsWithElements(List<Staff> staffs, List<StaffChild> staffElements) {
        for (int i in 0..<staffElements.size())
            for (int j in 0..<staffs.size())
                if (staffElements[i].staffIndex == staffs[j].staffIndex)
                    staffs[j].elements += staffElements[i]
    }

    static createMissingStaffs(List<Staff> staffs, List<StaffChild> staffElements) {
        def staffsNeeded = 0
        for (int i in 0..<staffElements.size()) {
            if (staffs.size() == 0) {
                staffs += new Staff(staffIndex: staffElements[i].staffIndex, dummyStaff: true)
                staffsNeeded = staffElements[i].staffIndex
            }
            for (int j in 0..<staffs.size()) {
                if (staffElements[i].staffIndex > staffsNeeded) {
                    if (staffElements[i].staffIndex == staffs[j].staffIndex)
                        staffsNeeded = staffElements[i].staffIndex
                    else {
                        staffs += new Staff(staffIndex: staffElements[i].staffIndex, dummyStaff: true)
                        staffsNeeded = staffElements[i].staffIndex
                    }
                }
            }
        }
        return staffs
    }
}