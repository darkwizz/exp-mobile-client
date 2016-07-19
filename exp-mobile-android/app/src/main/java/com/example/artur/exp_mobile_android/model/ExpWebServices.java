package com.example.artur.exp_mobile_android.model;

import com.example.artur.exp_mobile_android.model.entities.ExpOpportunity;
import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.entities.jsondeserializers.ExpOpportunityDeserializer;
import com.example.artur.exp_mobile_android.model.exceptions.InvalidTokenException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by artur on 19.07.16.
 */
public class ExpWebServices {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String BASE_URL = "http://localhost:8000/api/v1/";

    private OkHttpClient client = new OkHttpClient();
    private String token = null;

    /**
     * Logs into EXP system and keeps exp auth token.
     * @param email - exp user email;
     * @param password - exp user password;
     * @returns <code>true</code>, when successive login;
     *          <code>false</code> otherwise
     */
    public boolean login(String email, String password) {
        try {
            String json = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}";
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(BASE_URL + "login")
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            String token = result.split("\":\"")[1];
            this.token = token.substring(0, token.length() - 2);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Logs out from EXP system; makes token invalid.
     * @return <code>true</code> when successive logout;
     *         <code>false</code> when token is already invalid
     */
    // TODO
    public boolean logout() {
        return false;
    }

    /**
     * Gets list of all available opportunities (without filters).
     * @return list of opportunities
     */
    // TODO filters
    // TODO pagination (and in server too)
    public List<ExpOpportunity> getOpportunities() throws InvalidTokenException {
        try {
            String url = BASE_URL + "opportunities/" + token;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            JsonElement element = new JsonParser().parse(body);
            if (element == null) {
                return null;
            }
            JsonElement data = element.getAsJsonObject().get("data");
            if (data == null) {
                return null;
            }
            Type type = new TypeToken<List<ExpOpportunity>>(){}.getType();
            Gson gson = getGson(ExpOpportunity.class, new ExpOpportunityDeserializer());
            List<ExpOpportunity> opportunities = gson.fromJson(data, type);
            return opportunities;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Gets opportunity with specified identifier.
     * @param id - opportunity id;
     * @return needed opportunity
     */
    public ExpOpportunity getOpportunity(String id) throws InvalidTokenException {
        try {
            String url = BASE_URL + "opportunities/" + id + "/" + token;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            Gson gson = getGson(ExpOpportunity.class, new ExpOpportunityDeserializer());
            ExpOpportunity opportunity = gson.fromJson(body, ExpOpportunity.class);
            return opportunity;
        } catch (IOException ex) {
            return null;
        }
    }

    private <T> Gson getGson(Class<T> type, JsonDeserializer<T> deserializer) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(type, deserializer)
                .create();
        return gson;
    }

    /**
     * Gets list of all registered EPs (without filters).
     * @return list of EPs
     */
    // TODO filters
    public List<ExpPerson> getEps() throws InvalidTokenException {
        try {
            String url = BASE_URL + "eps/" + token;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Gets list of current logged in manager EPs.
     * @return list of EPs
     */
    public List<ExpPerson> getMyEps() throws InvalidTokenException {
        try {
            String url = BASE_URL + "eps/my/" + token;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Gets EP with specified id.
     * @param id - EP id;
     * @return needed EP
     */
    public ExpPerson getEp(String id) throws InvalidTokenException {
        try {
            String url = BASE_URL + "eps/" + id + "/" + token;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            return null;
        } catch (IOException ex) {
            return null;
        }
    }
}
