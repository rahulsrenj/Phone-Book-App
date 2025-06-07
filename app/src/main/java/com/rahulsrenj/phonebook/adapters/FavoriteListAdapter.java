package com.rahulsrenj.phonebook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rahulsrenj.phonebook.R;
import com.rahulsrenj.phonebook.database.Contacts;
import com.rahulsrenj.phonebook.databinding.FavoriteItemLayoutBinding;

import java.util.ArrayList;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.ViewHolder> {
    private FavoriteItemLayoutBinding binding;
    private Context context;
    private ArrayList<Contacts> favoriteArrayList;

    public FavoriteListAdapter(Context context, ArrayList<Contacts> favoriteArrayList) {
        this.context = context;
        this.favoriteArrayList = favoriteArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.favorite_item_layout,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacts favContact=favoriteArrayList.get(position);
        holder.binding.setContacts(favContact);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(favoriteArrayList!=null){
            return favoriteArrayList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private FavoriteItemLayoutBinding binding;
        public ViewHolder(FavoriteItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
