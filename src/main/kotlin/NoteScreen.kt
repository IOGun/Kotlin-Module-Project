
class NoteScreen(val note: Note): TemplateOfScreen() {
    override val messagesOfScreen = mutableMapOf(
            "title_of_screen" to "\n Просмотр заметки:",
            "exit_message" to "\nВы вышли из меню",
            "text_message" to "\nТекст заметки:\n${note.text} \n",
            "cursor_message" to "Выберите пункт меню > "
    )

    override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Выход", {exitFromThisScreen(); true }))
    }

}