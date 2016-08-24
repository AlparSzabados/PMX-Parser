package szabados.alpar

class ReplaceHeader {
    static replaceHeader(String text) {
        List<String> fileContentAsList = []

        text.eachLine { line ->
            def listOfStrings = splitLinesToLists(line)

            listOfStrings.removeAll { it.bytes == [] } //TODO find a petter way. Using `space` is not working.

            def stringHeader = '_'
            if (listOfStrings[0].startsWith(stringHeader))
                listOfStrings = listOfStrings.join(' ')

            fileContentAsList += [listOfStrings]
        }
        fileContentAsList
    }

    def static List<String> splitLinesToLists(String line) {
        def pattern = / (\s)?/
        line.split(pattern) as List
    }
}