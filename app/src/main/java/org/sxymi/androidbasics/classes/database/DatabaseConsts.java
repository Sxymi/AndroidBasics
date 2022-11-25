package org.sxymi.androidbasics.classes.database;

import org.sxymi.androidbasics.classes.database.items.ExampleItemConsts;

public class DatabaseConsts {
    public static String getCreateTablesSql() {
        StringBuilder sql = new StringBuilder();
        // ExampleItem
        sql.append("CREATE TABLE ").append(ExampleItemConsts.TABLE_NAME).append(" (")
                .append(ExampleItemConsts.COLUMN_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ExampleItemConsts.COLUMN_NAME).append(" TEXT, ")
                .append(ExampleItemConsts.COLUMN_VALUE).append(" INTEGER)");

        return sql.toString();
    }

    public static String getSelectAllFrom(String tableName) {
        return "SELECT * FROM " + tableName + ";";
    }
}
