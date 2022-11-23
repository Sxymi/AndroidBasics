package org.sxymi.androidbasics.activities.list;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.activities.deep.SQLiteItemActivity;
import org.sxymi.androidbasics.classes.Functions;
import org.sxymi.androidbasics.classes.database.DatabaseConsts;
import org.sxymi.androidbasics.classes.database.DatabaseHandler;
import org.sxymi.androidbasics.classes.database.items.ExampleItem;
import org.sxymi.androidbasics.classes.database.items.ExampleItemConsts;

import java.util.ArrayList;
import java.util.List;

public class SQLiteActivity extends BaseActivity {
    public static final String KEY = "sqlite";
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.refreshList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu_sqlite, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_record) {
            Functions.goToActivity(this, SQLiteItemActivity.class);
        } else if (id == R.id.delete_records) {
            this.deleteItems();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sqlite;
    }

    @Override
    protected void initializeControls() {
        this.list = this.findViewById(R.id.sqlite_list);
    }

    @Override
    protected void handleControls() {
        this.list.setOnItemClickListener((parent, view, position, id) -> {
            ExampleItem item = (ExampleItem) parent.getItemAtPosition(position);
            Bundle bundle = new Bundle();
            bundle.putSerializable(SQLiteActivity.KEY, item);

            Functions.goToActivity(this, SQLiteItemActivity.class, bundle);
        });
    }

    private void refreshList() {
        ArrayAdapter<ExampleItem> adapter = new ArrayAdapter<ExampleItem>(this, android.R.layout.simple_list_item_1, this.getItems());
        this.list.setAdapter(adapter);
    }

    private List<ExampleItem> getItems() {
        DatabaseHandler database = new DatabaseHandler(this);
        SQLiteDatabase sqlite = database.getReadableDatabase();
        Cursor cursor = sqlite.rawQuery(DatabaseConsts.getSelectAllFrom(ExampleItemConsts.TABLE_NAME), null);

        List<ExampleItem> items = new ArrayList<ExampleItem>();
        while (cursor.moveToNext()) {
            int columnId = cursor.getColumnIndex(ExampleItemConsts.COLUMN_ID);
            int columnName = cursor.getColumnIndex(ExampleItemConsts.COLUMN_NAME);
            int columnValue = cursor.getColumnIndex(ExampleItemConsts.COLUMN_VALUE);

            items.add(new ExampleItem(cursor.getInt(columnId), cursor.getString(columnName), cursor.getInt(columnValue)));
        }

        cursor.close();
        sqlite.close();
        database.close();

        return items;
    }

    private void deleteItems() {
        DatabaseHandler database = new DatabaseHandler(this);
        SQLiteDatabase sqlite = database.getWritableDatabase();
        boolean result = sqlite.delete(ExampleItemConsts.TABLE_NAME, null, null) != 0;
        sqlite.execSQL("VACUUM;");
        sqlite.close();
        database.close();

        if (result) {
            Functions.sendToast(this, R.string.error_database_success);
            this.refreshList();
        } else {
            Functions.sendToast(this, R.string.error_database_failure);
        }
    }
}