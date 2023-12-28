package net.braniumacademy.exercises1;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

// todo 1: chuyển đổi CountryViewModel thành lớp singleton
public class CountryViewModel extends ViewModel {
    private MutableLiveData<List<Country>> liveDataCountry;

    public LiveData<List<Country>> getCountries() {
        if (liveDataCountry == null) {
            liveDataCountry = new MutableLiveData<>();
        }
        return liveDataCountry;
    }

    public void loadData(Context context) {
        JSonParser parser = new JSonParser();
        String jsonString = parser.getJSONFromFile(context);
        if (jsonString != null) {
            List<Country> countryList = parser.getCountries(jsonString);
            if (countryList != null) {
                liveDataCountry.setValue(countryList);
            }
        }
    }
}
