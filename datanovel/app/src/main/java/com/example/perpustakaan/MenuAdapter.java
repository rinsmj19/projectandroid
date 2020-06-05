package com.example.perpustakaan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MenuAdapter extends RecyclerView.Adapter <MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<Menu> menus;

    public MenuAdapter(Context mcontext, ArrayList<Menu>menunovel) {

        context = mcontext;
        menus = menunovel;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru = menus.get(position);
        final String gambarbaru = menubaru.getGambar();
        final String harga = menubaru.getHarga();
        final String nama = menubaru.getNama();
        final String detail = menubaru.getDetail();

        holder.tvnamadata.setText(nama);
        holder.tvhargadata.setText(harga);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, DetailActivity.class);

                detailIntent.putExtra("img_menu", gambarbaru);
                detailIntent.putExtra("nama_menu", nama);
                detailIntent.putExtra("detail_menu", detail);

                context.startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView imdata;
        public TextView tvhargadata;
        public TextView tvnamadata;
        public Button btnDetail;

        public MenuViewHolder(@NonNull View itemView) {

            super(itemView);

            imdata= itemView.findViewById(R.id.img_menu);
            tvhargadata=itemView.findViewById(R.id.tv_harga);
            tvnamadata=itemView.findViewById(R.id.tv_nama);
            btnDetail=itemView.findViewById(R.id.btn_detail);


        }
    }

}
