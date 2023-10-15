
class ArchiveSelectionScreen(var listOfArchives: MutableList<Archive>) : TemplateOfScreen() {

   override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Добавить новый архив в список", {openCreateScreen(); false} ))
        for (row in listOfArchives) {
            listOfMenuItems.add(ItemOfMenu("Открыть архив \"${row.name}\"", { openNoteSelectionScreen(row); false}) )
        }
        listOfMenuItems.add(ItemOfMenu("Выход", {exitFromThisScreen(); true }))

    }

    fun openNoteSelectionScreen(archive: Archive){
        val newScreenOfNoteSelectionScreen : NoteSelectionScreen = NoteSelectionScreen(archive)
        createScreen(newScreenOfNoteSelectionScreen)
    }

    fun openCreateScreen() {
        val newScreen: ArchiveCreateScreen = ArchiveCreateScreen(listOfArchives)
        createScreen(newScreen)
    }

}