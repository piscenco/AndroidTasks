package com.example.fragmentsample

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


object PersonRepository {
	private val FLOWER_EL_LIST: MutableMap<Long, FlowerEl> = HashMap()
	private val DESCR_LIST: MutableMap<Long, FlowerEl> = HashMap()
	fun initialize(context: Context) {
		try {
			// ???
			//val flower_names :MutableList<String> = ArrayList()
			BufferedReader(InputStreamReader(context.assets.open("names.txt"))).use { reader ->
				var name = reader.readLine()
				var id: Long = 0
				while(!TextUtils.isEmpty(name)) {
					FLOWER_EL_LIST[id] = FlowerEl(id, name)
					++id
					name = reader.readLine()
					//flower_names.add(name)
				}
			}

			BufferedReader(InputStreamReader(context.assets.open("descriptions.txt"))).use { reader ->
				var new_descr = reader.readLine()
				var id: Long = 0
				while(!TextUtils.isEmpty(new_descr)) {
					DESCR_LIST[id] = FlowerEl(id, new_descr)
					++id
					new_descr = reader.readLine()
				}
				val i = 0
			}
		} catch(e: IOException) {
			e.printStackTrace()
			// Ничего не делать
		}
	}

	fun getPersonList(): List<FlowerEl> {
		return ArrayList(FLOWER_EL_LIST.values)
	}

	fun getPersonById(id: Long): FlowerEl {
		return FLOWER_EL_LIST[id] ?: throw Exception()
	}

	fun getDescrList():List<FlowerEl>{
	     return ArrayList(DESCR_LIST.values)
	}
	fun getDescrById(id: Long): String {
		return DESCR_LIST[id]?.name ?: throw Exception()
	}

}