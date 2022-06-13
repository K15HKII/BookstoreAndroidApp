package k15hkii.se114.bookstore.data.remote;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import k15hkii.se114.bookstore.R;
import k15hkii.se114.bookstore.data.model.location.City;
import lombok.Getter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class LocationRepository {

    private final Context context;
    private final Gson gson;

    private final List<City> cities = new ArrayList<>();

    @Getter(lazy = true)
    private final boolean initialize = initialize();

    @Inject
    public LocationRepository(@NonNull Context context, @NonNull Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    private boolean initialize() {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try (InputStream is = context.getResources().openRawResource(R.raw.local_location)) {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonString = writer.toString();

        City[] cities = gson.fromJson(jsonString, City[].class);
        this.cities.addAll(Arrays.asList(cities));
        return true;
    }

    public List<City> getCities() {
        return cities;
    }

    public City getCity(int id) {
        for (City city : cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return null;
    }

}
