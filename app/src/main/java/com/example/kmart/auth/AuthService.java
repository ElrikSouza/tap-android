package com.example.kmart.auth;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kmart.localdb.LocalDatabase;

public class AuthService {
    private final SQLiteDatabase database;


    public AuthService(Context context) {
        this.database = (new LocalDatabase(context)).getWritableDatabase();
    }

    private Credentials getUserCredentials(String username) {
        Cursor cursor = this.database.rawQuery("SELECT password FROM user_account WHERE username = ?;", new String[]{username});

        if (!cursor.moveToFirst()) {
            return null;
        }

        String password = cursor.getString(0);

        cursor.close();

        return new Credentials(username, password);
    }

    public boolean areCredentialsValid(Credentials credentials) {
        Credentials validCredentials = this.getUserCredentials(credentials.getUsername());

        if (validCredentials == null) {
            return false;
        }

        return validCredentials.isEquals(credentials);
    }
}
