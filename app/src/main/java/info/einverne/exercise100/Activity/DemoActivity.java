package info.einverne.exercise100.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.einverne.exercise100.R;

public class DemoActivity extends AppCompatActivity {

    public static final String TAG = "EV_DEMO_TAG";

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        listView = (ListView)findViewById(R.id.listView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                getData(),
                R.layout.list_item_textview,
                new String[] { "name"},
                new int[] { R.id.list_item_textview });
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new listItemClickListener());

    }

    private class listItemClickListener implements AdapterView.OnItemClickListener {

        /**
         * Item Click
         * @param parent The AdapterView where the click happened.
         * @param view The view within the AdapterView that was clicked (this will be a view provided by the adapter)
         * @param position The position of the view in the adapter.
         * @param id The row id of the item that was clicked.
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d(TAG, "View: "+view.getId()+" position: "+position+" id: "+id);
            TextView tv = (TextView)view;

            Map<String, String> item = getData().get(position);
            String ac = item.get("activity");

            switch (ac){
                case "DataActivity":
                    Intent intent = new Intent(DemoActivity.this, DataActivity.class);
                    startActivity(intent);
                    break;
                case "TextViewTestActivity":
                    intent = new Intent(DemoActivity.this, TextViewTestActivity.class);
                    startActivity(intent);
                    break;
                case "BasicActivity":
                    intent = new Intent(DemoActivity.this, BasicActivity.class);
                    startActivity(intent);
                case "ChangeThemeActivity":
                    intent = new Intent(DemoActivity.this, ChangeThemeActivity.class);
                    startActivity(intent);
                default:
                    break;
            }
        }
    }

    private List<Map<String, String>> getData() {
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Saving Files");
        map.put("activity", "DataActivity");
        data.add(map);
        map = new HashMap<>();
        map.put("name", "TextView Test");
        map.put("activity", "TextViewTestActivity");
        data.add(map);
        map = new HashMap<>();
        map.put("name", "Basic Control Test");
        map.put("activity", "BasicActivity");
        data.add(map);
        // 改变app主题
        map = new HashMap<>();
        map.put("name", "Change Theme");
        map.put("activity", "ChangeThemeActivity");
        data.add(map);

        return data;
    }
}
