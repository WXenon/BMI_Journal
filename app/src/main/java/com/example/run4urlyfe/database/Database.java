package com.example.run4urlyfe.database;

import android.provider.BaseColumns;

public final class Database {
    Database(){}

    public static class DB implements BaseColumns{
        public static final String TABLE_USER = "Users";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PW = "Password";
        public static final String COL_CONTACT = "Contact";
    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DB.TABLE_USER + " (" +
                    DB._ID + " INTEGER PRIMARY KEY," +
                    DB.COL_EMAIL + " TEXT," +
                    DB.COL_PW + " TEXT," +
                    DB.COL_CONTACT + " TEXT)";

    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DB.TABLE_USER;
}
