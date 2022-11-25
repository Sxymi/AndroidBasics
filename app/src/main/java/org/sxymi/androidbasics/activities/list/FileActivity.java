package org.sxymi.androidbasics.activities.list;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.classes.Functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileActivity extends BaseActivity {
    private final static String FILE_NAME = "example_file.txt";
    private Button button;
    private EditText editText;
    private boolean isEditMode = false;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.createFile();
        this.readFile();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_file;
    }

    @Override
    protected void initializeControls() {
        this.file = new File(this.getFilesDir(), FILE_NAME);
        this.button = this.findViewById(R.id.file_button);
        this.editText = this.findViewById(R.id.file_edit_text);
    }

    @Override
    protected void handleControls() {
        this.button.setOnClickListener(view -> {
            this.changeMode();

            if (!this.isEditMode) {
                this.writeFile();
            }
        });
    }

    private void changeMode() {
        this.isEditMode = !this.isEditMode;
        this.button.setText(this.isEditMode ? R.string.file_button_save : R.string.file_button_edit);
        this.editText.setEnabled(this.isEditMode);
    }

    private void createFile() {
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                Functions.sendToast(this, R.string.error_file_not_created);
            }
        }
    }

    private void readFile() {
        try {
            Scanner scanner = new Scanner(this.file);
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
            scanner.close();

            this.editText.setText(content.toString());
        } catch (FileNotFoundException e) {
            Functions.sendToast(this, R.string.error_file_read);
        }
    }

    private void writeFile() {
        try {
            FileWriter writer = new FileWriter(this.file);
            writer.write(this.editText.getText().toString());
            writer.close();
        } catch (IOException e) {
            Functions.sendToast(this, R.string.error_file_write);
        }
    }
}
