package net.braniumacademy.exercises1;

import android.content.Context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JSonParser {
    public String getJSONFromFile(Context context) {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try (InputStream inputStream = context.getResources().openRawResource(R.raw.country)) {
            Reader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            int size;
            while ((size = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, size);
            }
        } catch (IOException ignored) {
        }
        return writer.toString();
    }

    public List<Country> getCountries(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, new TypeReference<List<Country>>() {
            });
        } catch (JsonProcessingException ignored) {
            return null;
        }
    }
}
