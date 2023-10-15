import java.util.Scanner

class NoteCreateScreen(var listOfNotes: MutableList<Note>): TemplateOfScreen() {

    override val messagesOfScreen = mutableMapOf(
            "title_of_screen" to "\n Создание заметки:",
            "exit_message" to "\nВы вышли из меню",
            "text_message" to "",
            "cursor_message" to "Выберите пункт меню > "
    )

    override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Создать новую заметку", {addNote(); false} ))
        listOfMenuItems.add(ItemOfMenu("Выход", {exitFromThisScreen(); true }))
    }

   fun addNote(): Boolean {
        while (true) {
            println("\nВведите текст заметки")
            val str = Scanner(System.`in`).nextLine()
            if (str.isEmpty()) {
                println("Ошибка ввода. Заметка не может быть пустой. Добавьте текст.")
            } else{
                val note : Note = Note(str)
                listOfNotes.add(note)
                println("\nВы добавили заметку ${note.text} в архив")
                return true
            }
        }

    }

}