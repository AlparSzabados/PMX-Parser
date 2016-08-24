package szabados.alpar.parseAll

import static szabados.alpar.parseAll.MusicalElements.Elements.*

class MusicalElements {
    enum Elements {
        NOTE, REST, TEXT, STAFF
    }

    static final ArrayList<String> listFirstIndex = ['1', '2', '16', '8']

    public static TypeOfElement(Elements types) {
        switch (types){
            case NOTE: listFirstIndex[0]
                break
            case REST: listFirstIndex[1]
                break
            case TEXT: listFirstIndex[2]
                break
            case STAFF: listFirstIndex[3]
                break
        }
    }
}