import com.soywiz.korio.file.VfsFile
import com.soywiz.korio.file.std.resourcesVfs

class WordListReader
{
    suspend fun readList(fileName: String): List<String>
    {
        val file:VfsFile= resourcesVfs["dictionaries/$fileName"]
        val list: MutableList<String> = file.readLines().map { it.trim() }.toMutableList()


        return list
    }

    suspend fun readMatp(fileName: String): MutableMap<Char,List<String> >
    {
        val file:VfsFile= resourcesVfs["dictionaries/$fileName"]
        val list: MutableList<String> = file.readLines().map { it.trim() }.toMutableList()
        val dict: MutableMap<Char,List<String> > = mutableMapOf()
        val letters = listOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')

        for (letter in letters)
        {
            dict[letter] = list.filter { it.lowercase().startsWith(letter.toString()) }
        }

        return dict

    }
}