package com.example.tourney.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.tourney.Player;

public class Repository extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "smashTournament";

    // Player
    private static final String TABLE_PLAYERS = "players";
    private static final String KEY_PLAYER_ID = "id";
    private static final String KEY_PLAYER_NAME = "name";
    private static final String KEY_PLAYER_SCORE = "score";
    private static final String KEY_PLAYER_ACTIVE = "is_active";
    private static final String KEY_PLAYER_BUFFED = "is_buffed";
    private static final String KEY_PLAYER_BUFFS_NUMBER = "number_of_buffs";

    public Repository(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + TABLE_PLAYERS +"(" +
                KEY_PLAYER_ID + " INTEGER PRIMARY KEY," +
                KEY_PLAYER_NAME + " TEXT," +
                KEY_PLAYER_SCORE + " INTEGER," +
                KEY_PLAYER_BUFFED + " BOOL," +
                KEY_PLAYER_ACTIVE + " BOOL," +
                KEY_PLAYER_BUFFS_NUMBER + " INTEGER" + ")";
        db.execSQL(CREATE_PLAYER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);

        onCreate(db);
    }

    void addPlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getName());
        values.put(KEY_PLAYER_SCORE, player.getScore());
        values.put(KEY_PLAYER_BUFFED, player.isBuffed());
        values.put(KEY_PLAYER_ACTIVE, player.isActive());
        values.put(KEY_PLAYER_BUFFS_NUMBER, player.getBuffsNumber());

        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }

    Player getPlayer(String name){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT name, score, is_active, is_buffed, number_of_buffs FROM " +
                TABLE_PLAYERS + " WHERE " + KEY_PLAYER_NAME + "=" + name;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor != null)
            cursor.moveToFirst();

        Player player = new Player(cursor.getString(0),
                Integer.parseInt(cursor.getString(1)),
                Boolean.parseBoolean(cursor.getString(2)),
                Boolean.parseBoolean(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)));

        return player;
    }
}
