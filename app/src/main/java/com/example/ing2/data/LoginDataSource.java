package com.example.ing2.data;

import android.os.StrictMode;

import com.example.ing2.data.model.LoggedInUser;

import java.io.IOException;
import java.io.OutputStreamWriter;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONObject;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public Result<LoggedInUser> login(String username, String password) {

        try {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("user", username)
                    .add("passwd", password)
                    .build();
            Request request = new Request.Builder()
                    .url("http://167.71.105.232/api/auth/login")
                    .post(formBody)
                    .build();
            Response response = client.newCall(request).execute();
            JSONObject obj = new JSONObject(response.body().string());
            String token = obj.getString("access_token");
            Request request2 = new Request.Builder()
                    .url("http://167.71.105.232/api/auth/me")
                    .addHeader("Authorization", "Bearer "+token)
                    .build();
            Response response2 = client.newCall(request2).execute();
            System.out.println("Paso la conversion 0");
            JSONObject obj2 = new JSONObject(response2.body().string());
            System.out.println("Paso la conversion");
            String id = obj2.getString("ID");
            String name = obj2.getString("username");
            System.out.println(name);
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            id,
                            name, token);
            System.out.println(fakeUser);
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            System.out.println(e);
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}