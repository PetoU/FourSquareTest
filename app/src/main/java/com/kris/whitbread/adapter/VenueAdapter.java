package com.kris.whitbread.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kris.whitbread.R;
import com.kris.whitbread.api.model.Venue;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;

public class VenueAdapter extends ListAdapter<Venue> {

    private final Context mContext;

    public VenueAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        final View view = inflater.inflate(R.layout.item_list_venue, container, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(Venue item, int position, View view) {

        final ViewHolder viewHolder = (ViewHolder) view.getTag();

        if (viewHolder != null &&
                item != null) {

        }
    }

    static class ViewHolder {

        @Bind(R.id.photo)
        RoundedImageView mPhoto;
        @Bind(R.id.name)
        TextView mName;
        @Bind(R.id.description)
        TextView mDescription;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
