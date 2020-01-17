package com.example.labsql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version){

    val DATABASE_NAME = "task.db"
    val DATABASE_VERSION = 1
    val TABLE_NAME = "task"
    val COLUMN_ID = "id"
    val COLUMN_NAME = "taskname"

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = "CREATE_TABLE" + TABLE_NAME +
                "("+COLUMN_ID+ "INTEGER PRIMARY KEY"+COLUMN_NAME+"TEXT)"
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val UPGRADE_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME
        db.execSQL(UPGRADE_TABLE)
        onCreate(db)
    }


}