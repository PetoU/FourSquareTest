package com.kris.whitbread.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kris.whitbread.R;
import com.kris.whitbread.api.model.Category;
import com.kris.whitbread.api.model.Venue;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VenueAdapter extends ListAdapter<Venue> {

    private final Context mContext;
    private String IMAGE_SIZE = "88";

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


            if (! TextUtils.isEmpty(item.getName())) {
                viewHolder.mName.setText(item.getName());
            }

            if (! TextUtils.isEmpty(item.getLocation().getAddress())) {
                viewHolder.mAddress.setText(item.getLocation().getAddress());
            }

            if (item.getCategories() != null &&
                    item.getCategories().size() > 0) {
                final Category category = item.getCategories().get(0);
                final String iconUrl = category.getIcon().getPrefix() + IMAGE_SIZE + category.getIcon().getSuffix();

                Picasso.with(mContext)
                        .load(iconUrl)
                        .into(viewHolder.mPhoto);
            }
        }
    }

    static class ViewHolder {

        @Bind(R.id.photo)
        RoundedImageView mPhoto;
        @Bind(R.id.name)
        TextView mName;
        @Bind(R.id.address)
        TextView mAddress;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
