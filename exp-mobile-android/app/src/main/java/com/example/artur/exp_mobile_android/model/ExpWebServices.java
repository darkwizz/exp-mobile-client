package com.example.artur.exp_mobile_android.model;

import com.example.artur.exp_mobile_android.model.entities.ExpOpportunity;
import com.example.artur.exp_mobile_android.model.entities.ExpPerson;
import com.example.artur.exp_mobile_android.model.exceptions.InvalidTokenException;

import java.io.IOException;
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

    /**
     * Logs into EXP system and returns exp auth token.
     * @param email - exp user email;
     * @param password - exp user password;
     * @return authentication token
     */
    public String login(String email, String password) {
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
            token = token.substring(0, token.length() - 2);
            return token;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Logs out from EXP system; makes token invalid.
     * @param token - authentication token;
     * @return <code>true</code> when successive logout;
     *         <code>false</code> when token is already invalid
     */
    // TODO
    public boolean logout(String token) {
        return false;
    }

    /**
     * Gets list of all available opportunities (without filters).
     * @param token - authentication token
     * @return list of opportunities
     */
    // TODO filters
    // TODO pagination (and in server too)
    public List<ExpOpportunity> getOpportunities(String token) throws InvalidTokenException {
        try {
            String url = BASE_URL + "opportunities/" + token;
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
     * Gets opportunity with specified identifier.
     * @param token - authentication token;
     * @param id - opportunity id;
     * @return needed opportunity
     */
    public ExpOpportunity getOpportunity(String token, String id) throws InvalidTokenException {
        try {
            String url = BASE_URL + "opportunities/" + id + "/" + token;
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
     * Gets list of all registered EPs (without filters).
     * @param token - authenticity token;
     * @return list of EPs
     */
    // TODO filters
    public List<ExpPerson> getEps(String token) throws InvalidTokenException {
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
     * @param token - authenticity token
     * @return list of EPs
     */
    public List<ExpPerson> getMyEps(String token) throws InvalidTokenException {
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
     * @param token - authenticity token;
     * @param id - EP id;
     * @return needed EP
     */
    public ExpPerson getEp(String token, String id) throws InvalidTokenException {
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
