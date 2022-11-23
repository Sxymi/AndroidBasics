package org.sxymi.androidbasics.classes.database.items;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.sxymi.androidbasics.classes.database.DatabaseHandler;

import java.io.Serializable;

public abstract class BaseItem implements Serializable {
    protected int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getTableName();

    public abstract ContentValues getContentValues();

    public boolean insert(Context context) {
        DatabaseHandler database = new DatabaseHandler(context);
        SQLiteDatabase sqlite = database.getWritableDatabase();

        boolean result = sqlite.insert(this.getTableName(), null, this.getContentValues()) != -1;

        sqlite.close();
        database.close();

        return result;
    }

    public boolean update(Context context) {
        DatabaseHandler database = new DatabaseHandler(context);
        SQLiteDatabase sqlite = database.getWritableDatabase();

        boolean result = sqlite.update(this.getTableName(), this.getContentValues(), "ID = " + this.getId(), null) == 1;

        sqlite.close();
        database.close();

        return result;
    }

    public boolean delete(Context context) {
        DatabaseHandler database = new DatabaseHandler(context);
        SQLiteDatabase sqlite = database.getWritableDatabase();

        boolean result = sqlite.delete(this.getTableName(), "ID = " + this.getId(), null) == 1;

        sqlite.close();
        database.close();

        return result;
    }
}
