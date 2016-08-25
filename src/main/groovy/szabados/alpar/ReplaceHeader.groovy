package szabados.alpar

class ReplaceHeader {

    static List<List<String>> replaceHeader(String text) {
        List<List<String>> fileContentAsList = []
        text.eachLine { line ->
            fileContentAsList += [(removeLeadingZeroes(splitLinesToLists(line)))]
        }
        fileContentAsList
    }

    static List<String> removeLeadingZeroes(List<String> text) {
        List<String> noLeadingZeroes = []
        def negative = '-'
        for (int i = 0; i < text.size(); i++) {
            String minus = ''
            int j
            for (j = 0; j < text[i].size(); j++) {
                if (text[i].size() == 1) break
                else if (text[i][j] == negative && text[i][j + 1] == '0') {
                    j += 1
                    minus = negative
                } else if (text[i][j] != '0') break
            }
            if (text[i][j] == '.')
                j -= 1
            noLeadingZeroes += "${minus}${text[i].substring(j)}"
        }
        noLeadingZeroes
    }

    static List<String> splitLinesToLists(String text) {
        String line = text.trim()
        if (!line.startsWith('_')) {
            def pattern = / (\s)?/
            line.split(pattern) as List
        } else
            [line]
    }
}