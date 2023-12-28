package net.braniumacademy.exercises1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {
    private ListView listCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        setTitle(getString(R.string.title_activity));
        listCountry = findViewById(R.id.list_view_country);
        CountryAdapter adapter = new CountryAdapter(getApplicationContext(), new ArrayList<>());
        listCountry.setAdapter(adapter);
        // todo 2: tạo đối tượng của lớp ViewModel sau đó thực hiện các thao tác cần thiết
        // để hiển thị dữ liệu lên màn hình

        configEventHandler();
    }

    private void configEventHandler() {
        AdapterView.OnItemClickListener handler = ((adapterView, view, index, l) ->
                createIntent(index));
        listCountry.setOnItemClickListener(handler);
    }

    private void createIntent(int index) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Utils.EXTRA_COUNTRY_INDEX, index);
        startActivity(intent);
    }
}