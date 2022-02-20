package net.ivanvega.peticionesredhttpb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    ImageView imgview, imgview3, imgview4, imgview5;
    List<Heroes> heroesList = new ArrayList<Heroes>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillHeroesList();
        queue = Volley.newRequestQueue(this);


        recyclerView = (RecyclerView) findViewById(R.id.rv_Heroes);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(heroesList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);

    }

    private void fillHeroesList(){
        Heroes h0 = new Heroes(1, "Spiderman", "https:\\/\\/simplifiedcoding.net\\/demos\\/view-flipper\\/images\\/spiderman.jpg");
        Heroes h1 = new Heroes(2, "Ironman", "https:\\/\\/simplifiedcoding.net\\/demos\\/view-flipper\\/images\\/ironman.jpg");
        Heroes h2 = new Heroes(3, "Thor", "https:\\/\\/simplifiedcoding.net\\/demos\\/view-flipper\\/images\\/thor.jpg");
        Heroes h3 = new Heroes(4, "Wolverine", "https:\\/\\/simplifiedcoding.net\\/demos\\/view-flipper\\/images\\/wolverine.jpeg");

        heroesList.addAll(Arrays.asList(new Heroes[]{h0, h1, h2, h3}));
    }

}