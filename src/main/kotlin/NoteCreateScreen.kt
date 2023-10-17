import java.util.Scanner

class NoteCreateScreen(var listOfNotes: MutableList<Note>) : TemplateOfScreen() {

    override val messagesOfScreen = mutableMapOf(
            "title_of_screen" to "\n Создание заметки:",
            "exit_message" to "\nВы вышли из меню",
            "text_message" to "",
            "cursor_message" to "Выберите пункт меню > "
    )

    override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Создать новую заметку", { addNote(); false }))
        listOfMenuItems.add(ItemOfMenu("Выход", { exitFromThisScreen(); true }))
    }

    private fun addNote() {
        var name = ""
        var text = ""
        var mess = "имя"
        while (true) {
            println("\nВведите ${mess} заметки")
            val str = Scanner(System.`in`).nextLine()
            if (str.isEmpty()) {
                println("Ошибка ввода: ${mess} заметки не может быть пустым. Добавьте текст.")
            } else if (name == "") {
                name = str
                mess = "текст"
            } else if (name != "") {
                text = str
                val note = Note(name, text)
                listOfNotes.add(note)
                println("\nВы добавили заметку \"${note.name}\" c текстом: \n\"${note.text}\" в архив")
                break
            }
        }

    }

}