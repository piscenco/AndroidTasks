package com.example.fragmentsample.db

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
// does not work on sdk 30. why?

object FlowerContract {
    const val TABLE_NAME = "person_table"
    fun createTable(db: SQLiteDatabase) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME
                        + " ( "
                        + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Columns.NAME + " TEXT NOT NULL"
                        + " );"
        )
    }

    interface Columns : BaseColumns {
        companion object {
            const val NAME = "name"
        }
    }
}
/*

object FlowerContract {
    const val TABLE_NAME = "flower_table"
    fun createTable(db: SQLiteDatabase) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME
                        + " ( "
                        + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + Columns.NAME + " TEXT NOT NULL"
                        + Colums.NumberOfFlowers + "INT"
                        + " );"
        )
    }

    interface Columns : BaseColumns {
        companion object {
            const val NAME = "name"
        }
    }
}
*/