import java.util.Scanner

class ArchiveCreateScreen(var listOfArchives: MutableList<Archive>): TemplateOfScreen() {
    override val messagesOfScreen = mutableMapOf(
            "title_of_screen" to "\n Создание архива ",
            "exit_message" to "\nВы вышли из меню",
            "text_message" to "",
            "cursor_message" to "Выберите пункт меню > "
    )

    override fun createListOfMenu() {
        listOfMenuItems.clear()
        listOfMenuItems.add(ItemOfMenu("Создать новый архив", {addArchive(); false} ))
        listOfMenuItems.add(ItemOfMenu("Выход", {exitFromThisScreen(); true }))
    }

    fun addArchive(): Boolean {
        while (true) {
            println("\nВведите название архива")
            val str = Scanner(System.`in`).nextLine()
            if (str.isEmpty()) {
                println("Ошибка ввода. Название архива не может быть пустым. Добавьте текст.")
            } else{
                var title: String = str
                val newArchive : Archive = Archive(title, mutableListOf())
                listOfArchives.add(newArchive)
                println("\nАрхив \"${newArchive.name}\" успешно добавлен")
                return true
            }
        }
    }

}