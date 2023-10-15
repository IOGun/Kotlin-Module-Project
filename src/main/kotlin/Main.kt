
fun main(args: Array<String>) {

    val listOfArchive: MutableList<Archive> = mutableListOf()
    val mainScreen: ArchiveSelectionScreen = ArchiveSelectionScreen(listOfArchive)

    val screen: ArchiveSelectionScreen = ArchiveSelectionScreen(listOfArchive)
    mainScreen. createScreen(screen)


}