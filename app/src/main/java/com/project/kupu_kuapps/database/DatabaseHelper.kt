package com.project.kupu_kuapps.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "user.db"
        private const val DATABASE_VERSION = 1

        const val TABLE_USERS = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(name: String, email: String, password: String) {
        val db = this.writableDatabase
        val insertQuery = "INSERT INTO $TABLE_USERS ($COLUMN_NAME, $COLUMN_EMAIL, $COLUMN_PASSWORD) VALUES ('$name', '$email', '$password')"
        db.execSQL(insertQuery)
        db.close()
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = '$email' AND $COLUMN_PASSWORD = '$password'"
        val cursor = db.rawQuery(selectQuery, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count > 0
    }
}
