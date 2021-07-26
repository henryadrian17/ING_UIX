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
            // TODO: Mi logica
            String Json = "{'user':'" + username + "','passwd':'" + password + "'}";
            OkHttpClient client = new OkHttpClient();
            RequestBody formBody = new FormBody.Builder()
                    .add("user", username)
                    .add("passwd", password)
                    .build();
            Request request = new Request.Builder()
                    .url("http://192.168.10.101/api/auth/login")
                    .post(formBody)
                    .build();
            Response response = client.newCall(request).execute();
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
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