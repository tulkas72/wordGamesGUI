


class WordCatalog
{
    private val words = mutableListOf<String>()
    private val wordListReader = WordListReader()


    val size: Int
        get() = words.size

    suspend fun load(fileName: String)
    {
        words.addAll(wordListReader.readList(fileName))
    }


    fun add(word: String)
    {
        words.add(word)
    }

    fun get(index: Int): String
    {
        return words[index]
    }

    fun getWordsStartingWith(letter: Char): List<String>
    {
        return words.filter { it.lowercase().startsWith(letter.toString()) }
    }

    fun getRandomWord(): String
    {
        return words.random()
    }

    fun nLetterWords(n:Int): List<String>
    {
        return words.filter { it.length == n }
    }

    fun find(word: String): Int
    {
        return words.indexOf(word)
    }

    fun size(): Int
    {
        return words.size
    }

}