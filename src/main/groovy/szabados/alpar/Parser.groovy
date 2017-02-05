package szabados.alpar

import szabados.alpar.parseAll.Sheet
import szabados.alpar.parseAll.staffs.StaffChild

import static szabados.alpar.parseAll.Elements.*
import static szabados.alpar.parseAll.clefs.ParseClef.parseClef
import static szabados.alpar.parseAll.lines.ParseLine.parseLine
import static szabados.alpar.parseAll.notes.ParseNote.parseNote
import static szabados.alpar.parseAll.rests.ParseRest.parseRest
import static szabados.alpar.parseAll.slurs.ParseSlur.parseSlur
import static szabados.alpar.parseAll.staffs.ParseStaff.parseStaff
import static szabados.alpar.parseAll.text.ParseText.parseText

//TODO make it work for every item
class Parser {
    static Sheet parser(List<List<String>> list) {
        List<StaffChild> elements = []

        for (int i in 0..<list.size()) {
            List<String> currentElement = list[i]
            List<String> nextElement = list[i + 1]
            String musicalElement = currentElement[0]
            switch (musicalElement) {
                case elementType(STAFF): elements += parseStaff(currentElement); break
                case elementType(NOTE): elements += parseNote(currentElement); break
                case elementType(REST): elements += parseRest(currentElement); break
                case elementType(CLEF): elements += parseClef(currentElement); break
                case elementType(LINE): elements += parseLine(currentElement); break
                case elementType(SLUR): elements += parseSlur(currentElement); break
                case elementType(TEXT): elements += parseText(currentElement, nextElement); break
            }
        }
        return new Sheet(elements: elements)
    }
}