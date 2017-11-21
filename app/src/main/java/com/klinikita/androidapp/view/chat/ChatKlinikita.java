package com.klinikita.androidapp.view.chat;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.chat.adapter.Chat;
import com.klinikita.androidapp.view.chat.adapter.ChatRecyclerAdapter;
import com.klinikita.androidapp.view.feed.StatusBaru;
import com.klinikita.androidapp.view.feed.adapter.FeedRecyclerAdapter;
import com.klinikita.androidapp.view.more.adapter.MoreRecyclerAdapter;

import java.util.ArrayList;

public class ChatKlinikita extends AppCompatActivity {
    ArrayList<Chat> chatList = new ArrayList<>();
    RecyclerView rvChat;
    ImageView ivUser;
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_klinikita);
        rvChat = (RecyclerView) findViewById(R.id.rv_chat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvChat.setLayoutManager(linearLayoutManager);
        getSupportActionBar().hide();

        String[] namaUser = {"Dr. Hamim", "Dr. Iyan", "Dr. Roni", "Dr. Edwin", "Dr. Fakhri", "Dr. Aldi","Dr. Rizal","Dr. Amien","Sholeh"};
        int[] gambarUser = {R.drawable.ic_login_facebook,
                R.drawable.ic_more_help,
                R.drawable.ic_more_syaratketentuan,
                R.drawable.ic_more_profil,
                R.drawable.ic_more_pengaturan,
                R.drawable.ic_more_logout,
                R.drawable.facebook,
                R.drawable.google,
                R.drawable.akun};
        String[] historychat = {"Gimana dok ?", "Resep Obatnya", "sekitar 2 minggu yang lalu", "Tempatya sebelah mana dok", "Biayanya sekitar berapa", "sekitar pukul 10:00","ya nggak bisa gitu dong","Maksudnya gmana ya", "oh yayaya"};
        String[] lingkaran = {"3", "7", "1", "2", "5", "1","9","1", "3"};
        String[] time = {"09:00", "17:12", "17:13", "13:30", "20:00", "15:00", "15:12", "17:12","13:00"};

        for (int i = 0; i < namaUser.length; i++) {
            Chat chat = new Chat(namaUser[i], historychat[i], time[i],gambarUser[i],lingkaran[i]);
            chatList.add(chat);
        }
        ChatRecyclerAdapter chatRecyclerAdapter = new ChatRecyclerAdapter(this, chatList);

        rvChat.setAdapter(chatRecyclerAdapter);
        {

        }
    }

//    public void creat(View view) {
//        Intent i = new Intent(view.getContext(),NewChat.class);
//        startActivity(i);
//    }
}
