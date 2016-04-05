package com.kris.whitbread.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by eglu on 06/10/14.
 */
public abstract class ListAdapter<T> extends ArrayAdapter<T> {

    private final Context context;
    private final LayoutInflater inflater;
    protected List<T> mItems = Collections.emptyList();
    private final Object mLock;

    public ListAdapter(Context context) {
        super(context, 0);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        mLock = new Object();
    }

    public Context getContext() {
        return context;
    }

    public void swapItems(List<T> list) {
        mItems = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return mItems;
    }

    @Override
    public T getItem(int position) {
        return getItems().get(position);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public final View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = newView(inflater, position, container);
            if (view == null) {
                throw new IllegalStateException("newView result must not be null.");
            }
        }
        bindView(getItem(position), position, view);
        return view;
    }

    /**
     * Create a new instance of a view for the specified position.
     */
    public abstract View newView(LayoutInflater inflater, int position, ViewGroup container);

    /**
     * Bind the data for the specified {@code position} to the view.
     */
    public abstract void bindView(T item, int position, View view);

    @Override
    public final View getDropDownView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = newDropDownView(inflater, position, container);
            if (view == null) {
                throw new IllegalStateException("newDropDownView result must not be null.");
            }
        }
        bindDropDownView(getItem(position), position, view);
        return view;
    }

    /**
     * Create a new instance of a drop-down view for the specified position.
     */
    public View newDropDownView(LayoutInflater inflater, int position, ViewGroup container) {
        return newView(inflater, position, container);
    }

    /**
     * Bind the data for the specified {@code position} to the drop-down view.
     */
    public void bindDropDownView(T item, int position, View view) {
        bindView(item, position, view);
    }

}
