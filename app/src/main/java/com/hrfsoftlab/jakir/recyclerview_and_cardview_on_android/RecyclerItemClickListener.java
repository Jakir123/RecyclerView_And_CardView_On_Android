package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Jakir Hossain
 * @version 1.3.0
 * @desc description of the class
 * @link n/a
 * @created on 21-Oct-15
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    protected OnItemClickListener listener;

    private GestureDetector gestureDetector;

    private View childView;

    private int childViewPosition;

    public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        this.listener = listener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent event) {
        childView = view.findChildViewUnder(event.getX(), event.getY());
        childViewPosition = view.getChildPosition(childView);

        return childView != null && gestureDetector.onTouchEvent(event);
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    /**
     * A click listener for items.
     */
    public interface OnItemClickListener {

        public void onItemClick(View childView, int position);

        public void onItemLongPress(View childView, int position);

        public void onItemDoubleTap(View childView, int position);

        public void onItemDownTap(View childView, int position);

    }

    protected class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            if (childView != null) {
                listener.onItemClick(childView, childViewPosition);
            }

            return true;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            if (childView != null) {
                listener.onItemLongPress(childView, childViewPosition);
            }
        }

        @Override
        public boolean onDown(MotionEvent event) {
            if (childView != null) {
                listener.onItemDownTap(childView, childViewPosition);
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            if (childView != null) {
                listener.onItemDoubleTap(childView, childViewPosition);
            }
            return true;
        }
    }
}
