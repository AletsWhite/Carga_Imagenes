package net.ivanvega.peticionesredhttpb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Heroes> heroesList;
    Context context;
    public RecyclerViewAdapter(List<Heroes> heroesList, Context context) {
        this.heroesList = heroesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroes, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_heroeNombre.setText(heroesList.get(position).getNombre());
        requestImageMethod(heroesList.get(position).enlace, holder.iv_heroePic);
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_heroePic;
        TextView tv_heroeNombre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_heroePic = itemView.findViewById(R.id.heroeImage);
            tv_heroeNombre = itemView.findViewById(R.id.nombreHeroe);
        }
    }

    void requestImageMethod(String url, ImageView img){
        ImageRequest imgReq = new
                ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img.setImageBitmap(response);
                    }

                },300,300,
                ImageView.ScaleType.CENTER,
                Bitmap.Config.ALPHA_8,
                error -> {
                    error.printStackTrace();
                }
        );
        MySingleton.getInstance(context).addToRequestQueue(imgReq);
    }
}
