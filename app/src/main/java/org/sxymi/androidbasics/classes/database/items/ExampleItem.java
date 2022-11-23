package org.sxymi.androidbasics.classes.database.items;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class ExampleItem extends BaseItem implements ExampleItemConsts {
    private String name;
    private int value;

    public ExampleItem(String name, int value) {
        this(-1, name, value);
    }

    public ExampleItem(int id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, this.getName());
        values.put(COLUMN_VALUE, this.getValue());

        return values;
    }

    @NonNull
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put(COLUMN_ID, this.getId());
            json.put(COLUMN_NAME, this.getName());
            json.put(COLUMN_VALUE, this.getValue());

            return json.toString();
        } catch (JSONException e) {
            return json.toString();
        }
    }
}
