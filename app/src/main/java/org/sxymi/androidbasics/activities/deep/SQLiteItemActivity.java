package org.sxymi.androidbasics.activities.deep;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.activities.list.SQLiteActivity;
import org.sxymi.androidbasics.classes.Functions;
import org.sxymi.androidbasics.classes.database.items.ExampleItem;

public class SQLiteItemActivity extends BaseActivity {
    private Button buttonInsert, buttonUpdate, buttonDelete;
    private EditText editTextName, editTextValue;
    private RelativeLayout layoutInsert, layoutEdit;
    private ExampleItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.item == null) {
            this.layoutInsert.setVisibility(View.VISIBLE);
        } else {
            this.layoutEdit.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sqlite_item;
    }

    @Override
    protected void initializeControls() {
        this.buttonInsert = this.findViewById(R.id.sqlite_item_button_insert);
        this.buttonUpdate = this.findViewById(R.id.sqlite_item_button_edit);
        this.buttonDelete = this.findViewById(R.id.sqlite_item_button_delete);
        this.editTextName = this.findViewById(R.id.sqlite_item_edit_text_name);
        this.editTextValue = this.findViewById(R.id.sqlite_item_edit_text_value);
        this.layoutInsert = this.findViewById(R.id.sqlite_item_layout_relative_insert);
        this.layoutEdit = this.findViewById(R.id.sqlite_item_layout_relative_edit);
    }

    @Override
    protected void handleControls() {
        this.buttonInsert.setOnClickListener(view -> {
            if (!this.validateForm()) {
                return;
            }

            this.readForm();
            this.item.insert(this);

            Functions.goToActivity(this, SQLiteActivity.class);
        });

        this.buttonUpdate.setOnClickListener(view -> {
            if (!this.validateForm()) {
                return;
            }

            this.readForm();
            this.item.update(this);

            Functions.goToActivity(this, SQLiteActivity.class);
        });

        this.buttonDelete.setOnClickListener(view -> {
            this.item.delete(this);

            Functions.goToActivity(this, SQLiteActivity.class);
        });
    }

    @Override
    protected void readBundle(Bundle bundle) {
        super.readBundle(bundle);

        this.item = bundle.getSerializable(SQLiteActivity.KEY, ExampleItem.class);
        if (this.item != null) {
            this.editTextName.setText(this.item.getName());
            this.editTextValue.setText(String.valueOf(this.item.getValue()));
        }
    }

    private boolean validateForm() {
        if (Functions.isEditTextEmpty(this.editTextName) || Functions.isEditTextEmpty(this.editTextValue)) {
            Functions.sendToast(this, R.string.error_empty_edit_text);
            return false;
        }

        return true;
    }

    private void readForm() {
        String name = this.editTextName.getText().toString();
        int value = Integer.parseInt(this.editTextValue.getText().toString());

        if (this.item == null) {
            this.item = new ExampleItem(name, value);
        } else {
            this.item.setName(name);
            this.item.setValue(value);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}