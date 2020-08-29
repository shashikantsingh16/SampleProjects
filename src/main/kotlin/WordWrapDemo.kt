fun main(){
    val wrap = WordWrapDemo()
    val sentence = "This is demo for something special which is there. For any length of Word"

    wrap.getListAndPrint(wrap.tokenizeWordInMap(sentence), 20)

}


class WordWrapDemo {

    private var leadingSpace : Int = 0

    fun getListAndPrint(listOfWordWithCount: List<Pair<String,Int>>, lineSize: Int){

        var leadingSpaceRemaining = lineSize - leadingSpace
        var currentLineLengthCount = 0
        var sentence = ""
        var listOfSentence  = mutableListOf<String>()

        listOfWordWithCount.forEach {

            var word = it.first
            var wordLength = it.second

            if ((currentLineLengthCount + wordLength) > lineSize){
                print(sentence)
                listOfSentence.add(sentence)
                currentLineLengthCount = 0
                println()
                sentence = ""

                sentence += "$word "
                currentLineLengthCount += wordLength+1
            }else{
                sentence += "$word "
                currentLineLengthCount += wordLength+1
            }
        }
        print(sentence)
    }

    fun tokenizeWordInMap(statements: String): List<Pair<String,Int>>{
        var listOfWordWithCount = mutableListOf<Pair<String,Int>>()
        val length = statements.length
        var index = 0
        var wordLength = 0
        var words = ""

        countLeadingSpace(statements)

        while (index < length){
            val chars = statements[index++].toString()
            if (chars.equals(" ", false)){
                listOfWordWithCount.add(Pair(words,wordLength))

                words = ""
                wordLength = 0
            }else{
                wordLength++
                words += chars
            }
        }
        listOfWordWithCount.add(Pair(words,wordLength))
        return listOfWordWithCount
    }

    private fun countLeadingSpace(statements: String) {
        var index=0
        var spaceCount = 0
        while (index < statements.length){
            if (statements[index++].toString() == " "){
                spaceCount++
            }else{
                break
            }
        }
        leadingSpace = spaceCount
    }
}