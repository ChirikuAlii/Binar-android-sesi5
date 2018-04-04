package com.duniaeureka.retrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duniaeureka.retrofit.R;
import com.duniaeureka.retrofit.model.Artikel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chirikualii on 04/04/18.
 */

public class ArtikelAdapter extends  RecyclerView.Adapter<ArtikelAdapter.Holder> {


   private List<Artikel> artikelList;

    public ArtikelAdapter(List<Artikel> artikelList) {
        this.artikelList = artikelList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artikel,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return artikelList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        public Holder(View itemView) {
            super(itemView);
        }

        public void bind(int position) {

            Artikel artikel = artikelList.get(position);

            ImageView imgArtikel = itemView.findViewById(R.id.img_berita);
            TextView tvJudul = itemView.findViewById(R.id.tv_judul_artikel);
            TextView tvTanggal = itemView.findViewById(R.id.tv_tanggal);

            Picasso.get()
                    .load(artikel.getUrlToImage())
                    .placeholder(R.mipmap.ic_launcher)
                    //.centerCrop()
                    .error(R.mipmap.ic_launcher)
                    .into(imgArtikel);
            tvJudul.setText(artikel.getTitle());
            tvTanggal.setText(artikel.getPublishedAt());

        }
    }
}
