package com.rahulsrenj.phonebook.adapters;


import android.net.Uri;
import android.widget.ImageView;

import com.rahulsrenj.phonebook.R;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("favIcon")
    public static void setFavoriteIcon(ImageView view,boolean isFavorite){
        if(isFavorite)
        {
                view.setImageResource(R.drawable.favorites_filled);
        }
        else{
            view.setImageResource(R.drawable.favorites);
        }
    }
    @androidx.databinding.BindingAdapter("profilePic")
    public static void setProfilePic(ImageView view,String imageUri){
        if(imageUri==null)
        {
            view.setImageResource(R.drawable.empty_profile);
        }
        else{
            view.setImageURI(Uri.parse(imageUri));
        }
    }

}
