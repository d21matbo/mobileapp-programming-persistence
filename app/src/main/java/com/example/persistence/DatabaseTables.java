package com.example.persistence;

public class DatabaseTables {

    static class Car {
        static final String TABLE_NAME = "car";
        static final String COLUMN_LICNO = "licno";
        static final String COLUMN_BRAND = "brand";
        static final String COLUMN_MODEL = "model";
    }

    static final String SQL_CREATE_TABLE_CAR =
            "CREATE TABLE " + Car.TABLE_NAME + " (" +
                    Car.COLUMN_LICNO + " TEXT PRIMARY KEY, " +
                    Car.COLUMN_BRAND + " TEXT, " +
                    Car.COLUMN_MODEL + "TEXT)";

    static final String SQL_DELETE_TABLE_CAR =
            "DROP TABLE IF EXISTS " + Car.TABLE_NAME;
}
