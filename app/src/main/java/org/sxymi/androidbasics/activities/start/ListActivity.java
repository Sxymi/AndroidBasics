package org.sxymi.androidbasics.activities.start;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.sxymi.androidbasics.R;
import org.sxymi.androidbasics.activities.BaseActivity;
import org.sxymi.androidbasics.activities.list.CanvasActivity;
import org.sxymi.androidbasics.activities.list.FileActivity;
import org.sxymi.androidbasics.activities.list.FragmentsActivity;
import org.sxymi.androidbasics.activities.list.IntentsActivity;
import org.sxymi.androidbasics.activities.list.LifeCycleActivity;
import org.sxymi.androidbasics.activities.list.LogcatActivity;
import org.sxymi.androidbasics.activities.list.MultimediaActivity;
import org.sxymi.androidbasics.activities.list.NotificationsActivity;
import org.sxymi.androidbasics.activities.list.PictureActivity;
import org.sxymi.androidbasics.activities.list.SQLiteActivity;
import org.sxymi.androidbasics.activities.list.WidgetsActivity;
import org.sxymi.androidbasics.classes.Functions;
import org.sxymi.androidbasics.classes.list.ListItem;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity {
    private ListView list;
    private List<ListItem> items = new ArrayList<ListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeItems();
        this.initializeAdapter();
    }

    private void initializeItems() {
        this.addItem(R.string.label_activity_notifications, NotificationsActivity.class);
        this.addItem(R.string.label_activity_widgets, WidgetsActivity.class);
        this.addItem(R.string.label_activity_fragments, FragmentsActivity.class);
        this.addItem(R.string.label_activity_intents, IntentsActivity.class);
        this.addItem(R.string.label_activity_sqlite, SQLiteActivity.class);
        this.addItem(R.string.label_activity_file, FileActivity.class);
        //this.addItem(R.string.label_activity_maps, MapsActivity.class);
        this.addItem(R.string.label_activity_picture, PictureActivity.class);
        this.addItem(R.string.label_activity_multimedia, MultimediaActivity.class);
        this.addItem(R.string.label_activity_canvas, CanvasActivity.class);
        this.addItem(R.string.label_activity_logcat, LogcatActivity.class);
        this.addItem(R.string.label_activity_lifecycle, LifeCycleActivity.class);
    }

    private void initializeAdapter() {
        List<String> translations = new ArrayList<String>();
        Resources resources = this.getResources();

        for (ListItem item : items) {
            translations.add(resources.getString(item.getIdString()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, translations);
        this.list.setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_list;
    }

    @Override
    protected void initializeControls() {
        this.list = this.findViewById(R.id.list_list);
    }

    @Override
    protected void handleControls() {
        this.list.setOnItemClickListener((parent, view, position, id) -> {
            Functions.goToActivity(this, this.items.get(position).getTarget());
        });
    }

    private void addItem(int idString, Class<?> target) {
        this.items.add(new ListItem(idString, target));
    }
}