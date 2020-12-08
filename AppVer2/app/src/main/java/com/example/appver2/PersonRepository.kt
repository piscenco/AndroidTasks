package com.example.appver2

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object PersonRepository {
	private val PERSON_LIST: MutableMap<Long, Person> = HashMap()
	private val DESCR_LIST: MutableMap<Long, Person> = HashMap()
	fun initialize(context: Context) {
		try {
			BufferedReader(InputStreamReader(context.assets.open("names.txt"))).use { reader ->
				var name = reader.readLine()
				var id: Long = 0
				while(!TextUtils.isEmpty(name)) {
					PERSON_LIST[id] = Person(id, name)
					++id
					name = reader.readLine()
				}
			}

			BufferedReader(InputStreamReader(context.assets.open("descriptions.txt"))).use { reader ->
				var new_descr = reader.readLine()
				var id: Long = 0
				while(!TextUtils.isEmpty(new_descr)) {
					DESCR_LIST[id] = Person(id, new_descr)
					++id
					new_descr = reader.readLine()
				}
			}
		} catch(e: IOException) {
			e.printStackTrace()
			// Ничего не делать
		}
	}

	fun getPersonList(): List<Person> {
		return ArrayList(PERSON_LIST.values)
	}

	fun getPersonById(id: Long): Person {
		return PERSON_LIST[id] ?: throw Exception()
	}

	fun getDescrList():List<Person>{
	     return ArrayList(DESCR_LIST.values)
	}
	fun getDescrById(id: Long): Person {
		return DESCR_LIST[id] ?: throw Exception()
	}
}