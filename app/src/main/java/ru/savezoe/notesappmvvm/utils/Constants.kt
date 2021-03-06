package ru.savezoe.notesappmvvm.utils

import ru.savezoe.notesappmvvm.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String

object Constants {
    object Keys {
        const val NOTE_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new notes"
        const val NOTE_TITLE = "title"
        const val NOTE_SUBTITLE = "subtitle"
        const val SAVE = "Сохранить"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val WHAT_WILL_WE_USE = "Что будете использовать"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val ID = "id"
        const val NONE = "none"
        const val UPDATE = "Обновить"
        const val DELETE = "Удалить"
        const val NAV_BACK = "Назад"
        const val EDIT_NOTE = "Edit Note"
        const val EMPTY = ""
        const val UPDATE_NOTE = "Update note"
        const val SIGN_IN = "Sign In"
        const val LOG_IN = "LOG IN"
        const val LOGIN_TEXT = "Login"
        const val PASSWORD_TEXT = "Password"
    }

    object Screens {
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val NOTE_SCREEN = "note_screen"
        const val ADD_SCREEN = "add_screen"
    }

}