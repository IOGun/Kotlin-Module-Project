
class NoteSelectionScreen(var archive: Archive ): TemplateOfScreen() {

   override val messagesOfScreen = mutableMapOf(
           "title_of_screen" to "\n Записи в архиве ${archive.name}:",
           "exit_message" to "\nВы вышли из меню",
           "text_message" to "",
           "cursor_message" to "Выберите пункт меню > "
   )

    override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Добавить новую заметку в архив", {openNoteCreateScreen(archive.listOfNotes); false} ))
        for (row in archive.listOfNotes) {
            listOfMenuItems.add(ItemOfMenu("Открыть заметку \"${row.text}\"", { openNoteScreen(row); false}) )
        }
        listOfMenuItems.add(ItemOfMenu("Выход", { exitFromThisScreen(); true }))
    }

    fun openNoteScreen(note: Note){
        val newScreenOfNoteScreen: NoteScreen = NoteScreen(note)
        createScreen(newScreenOfNoteScreen)
    }

    fun openNoteCreateScreen(listOfNote: MutableList<Note> ){
        val newScreenOfNoteCreateScreen: NoteCreateScreen = NoteCreateScreen(listOfNote)
        createScreen(newScreenOfNoteCreateScreen)
    }

}