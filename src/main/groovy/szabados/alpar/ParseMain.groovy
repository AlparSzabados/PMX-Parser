package szabados.alpar

import static szabados.alpar.ReplaceHeader.replaceHeader

class ParseMain {
    public static void main(String... args) {
        def input = Settings.INPUT_FILE.text
        def prepareInput = replaceHeader(input)
        prepareInput
    }
}