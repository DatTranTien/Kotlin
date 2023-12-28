package net.braniumacademy.exercises1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageFlag;
    private TextView textCountry;
    private TextView textCapital;
    private TextView textPopulation;
    private TextView textArea;
    private TextView textDensity;
    private TextView textWorldShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent incomeIntent = getIntent();
        initViews();
        int index = -1;
        if (incomeIntent != null) {
            index = incomeIntent.getIntExtra(Utils.EXTRA_COUNTRY_INDEX, -1);
        }
        // todo 3: tạo đối tượng của lớp CountryViewModel và thực hiện các thao tác để
        // hiển thị dữ liệu chi tiết của quốc gia được chọn lên màn hình

    }

    @SuppressLint("SetTextI18n")
    private void showDetail(Country country) {
        setTitle(country.getName());
        String countryStr = getString(R.string.text_nation) + " " + country.getName();
        String capitalStr = getString(R.string.text_capital) + " " + country.getCapital();
        String popStr = getString(R.string.text_population) + " " +
                Utils.getNumberFormatted(country.getPopulation()) +
                " " + getString(R.string.text_million);
        String areaStr = getString(R.string.text_area) + " " +
                Utils.getNumberFormatted(country.getArea())
                + " " + getString(R.string.text_km2);
        String densityStr = getString(R.string.text_density) + " " +
                Utils.getNumberFormatted(country.getDensity()) +
                " " + getString(R.string.text_ppa);
        String worldShareStr = getString(R.string.text_world_share) +
                " " + country.getWorldShare();
        textCountry.setText(countryStr);
        textCapital.setText(capitalStr);
        textPopulation.setText(popStr);
        textArea.setText(areaStr);
        textDensity.setText(densityStr);
        textWorldShare.setText(worldShareStr);
        imageFlag.setImageDrawable(Utils.getDrawable(this, country.getFlag()));
    }

    private void initViews() {
        imageFlag = findViewById(R.id.image_flag_detail);
        textCountry = findViewById(R.id.text_nation_detail);
        textCapital = findViewById(R.id.text_capital_detail);
        textPopulation = findViewById(R.id.text_population_detail);
        textArea = findViewById(R.id.text_area_detail);
        textDensity = findViewById(R.id.text_density_detail);
        textWorldShare = findViewById(R.id.text_world_share_detail);
    }
}