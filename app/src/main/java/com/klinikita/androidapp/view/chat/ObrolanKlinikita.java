package com.klinikita.androidapp.view.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.view.chat.adapter.Obrolan;
import com.klinikita.androidapp.view.chat.adapter.ObrolanAdapter;

import java.util.ArrayList;

public class ObrolanKlinikita extends AppCompatActivity {
    RecyclerView rvObrolan;
    ArrayList<Obrolan>obrolanList = new ArrayList<>();
    EditText edtChatMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obrolan_klinikita);
        rvObrolan = (RecyclerView)findViewById(R.id.rv_obrolan);
        edtChatMessage = (EditText)findViewById(R.id.edt_chat_message);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvObrolan.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setStackFromEnd(true);

//        String [] textobrolan = {"Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo","Hallo",};
//        for (int i = 0; i < textobrolan.length; i++){
//
//            Obrolan obrolan = new Obrolan(textobrolan[i]);
//
//            obrolanList.add(obrolan);
//        }
//        ObrolanAdapter obrolanAdapter = new ObrolanAdapter(this,obrolanList);
//        rvObrolan.setAdapter(obrolanAdapter);
    }

    public void kirimPesan(View view) {
        String messageBaru = edtChatMessage.getText().toString().trim();
        Obrolan baru = new Obrolan(messageBaru);
        obrolanList.add(baru);
        ObrolanAdapter adapter = new ObrolanAdapter(this,obrolanList);
        rvObrolan.setAdapter(adapter);
        edtChatMessage.setText("");
    }
    private boolean isEmpty(EditText edtChatMessage) {
        if (edtChatMessage.getText().toString().trim().length() == 0)
            return false;

        return true;}
}
