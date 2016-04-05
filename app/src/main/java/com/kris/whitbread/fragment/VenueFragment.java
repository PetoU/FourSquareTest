package com.kris.whitbread.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.kris.whitbread.App;
import com.kris.whitbread.DataManager;
import com.kris.whitbread.R;
import com.kris.whitbread.adapter.VenueAdapter;
import com.kris.whitbread.api.model.Venue;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class VenueFragment extends Fragment {

    private DataManager mDataManager;
    private VenueAdapter mVenueAdapter;

    @Bind(R.id.list)
    ListView mListView;

    public static VenueFragment newInstance() {
        final VenueFragment venueFragment = new VenueFragment();
        final Bundle bundle = new Bundle();
        venueFragment.setArguments(bundle);
        return venueFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mDataManager = App.getDataManager();

        if (getActivity() != null) {
            mVenueAdapter = new VenueAdapter(getActivity());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main_list, container, false);
        ButterKnife.bind(this, view);
        mListView.setAdapter(mVenueAdapter);

        return view;
    }

    @OnTextChanged(R.id.search)
    void onSearchTextChanged(CharSequence s, int start, int before, int count) {
        final String searchString = s.toString();

        mDataManager.getVenues(searchString)
                .subscribe(venueResponse -> {
                    final List<Venue> venues = venueResponse.getResponse().getVenues();
                    mVenueAdapter.swapItems(venues);
                }, Throwable::printStackTrace);

    }


}
