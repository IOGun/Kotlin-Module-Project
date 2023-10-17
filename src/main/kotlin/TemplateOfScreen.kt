import java.util.Scanner

class Archive(val name: String, var listOfNotes: MutableList<Note>)

data class Note(val name: String, val text: String)

class ItemOfMenu(val name: String,
                 val menuFunc: () -> Boolean
)

abstract class TemplateOfScreen {

    open val messagesOfScreen = mutableMapOf(
            "title_of_screen" to "\n Список архивов:",
            "exit_message" to "\nВы вышли из программы",
            "text_message" to "",
            "cursor_message" to "Выберите пункт меню > "
    )

    var listOfMenuItems: MutableList<ItemOfMenu> = mutableListOf()

    abstract fun createListOfMenu()

    fun showScreen() {
        println(messagesOfScreen["title_of_screen"])
        createListOfMenu()
        listOfMenuItems.forEachIndexed { index, row -> println("${index}. ${row.name}") }
        println(messagesOfScreen["text_message"])
        print("Выберите пункт меню > ")
    }

    fun checkItemOfMenu(str: String): Int {
        return if (str.toIntOrNull() == null) {
            println("Ошибка ввода! Введите число")
            -1
        } else {
            val numOfMenuItems: Int = listOfMenuItems.size
            val menuItem: Int = str.toInt()
            if ((menuItem > (numOfMenuItems - 1)) or (menuItem < 0)) {
                println("Данный пункт в меню отсутствует! Выберите другой")
                -1
            } else {
                menuItem
            }
        }
    }

    fun chooseItemOfMenu(item: Int): Boolean {
        return listOfMenuItems[item].menuFunc.invoke()
    }

    fun exitFromThisScreen() {
        println(messagesOfScreen["exit_message"])
    }

    fun createScreen(screen: TemplateOfScreen) {
        while (true) {
            screen.showScreen()
            val str = Scanner(System.`in`).nextLine()
            val itemOfMenu: Int = screen.checkItemOfMenu(str)
            if (itemOfMenu >= 0) {
                val exitFromMenu = screen.chooseItemOfMenu(itemOfMenu)
                if (exitFromMenu) return
            }
        }
    }

}