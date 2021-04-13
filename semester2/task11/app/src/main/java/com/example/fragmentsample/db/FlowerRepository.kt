package com.example.fragmentsample.db

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.util.*

class FlowerRepository(private val databaseHolder: DatabaseHolder) {

    fun addEl(Flower: Flower) {
        try {
            val database = databaseHolder.open() ?: throw IllegalStateException()
            val contentValues = ContentValues()
            contentValues.put(FlowerContract.Columns.NAME, Flower.name)
            database.insert(FlowerContract.TABLE_NAME, null, contentValues)
        } finally {
            databaseHolder.close()
        }
    }

    fun loadAll(): List<Flower> {
        val FlowerList: MutableList<Flower> = mutableListOf()
        var cursor: Cursor? = null
        try {
            val database = databaseHolder.open() ?: throw IllegalStateException()
            cursor = database.query(
                    FlowerContract.TABLE_NAME, arrayOf(BaseColumns._ID, FlowerContract.Columns.NAME),
                    null,
                    null,
                    null,
                    null,
                    null
            )
            while (cursor.moveToNext()) {
                val Flower = Flower()
                Flower.id = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID))
                Flower.name = cursor.getString(cursor.getColumnIndex(FlowerContract.Columns.NAME))
                // Flower.count = cursor.getString(cursor.getColumnIndex(FlowerContract.Columns.NAME))
                FlowerList.add(Flower)
            }
        } finally {
            cursor?.close()
            databaseHolder.close()
        }
        return FlowerList
    }
}