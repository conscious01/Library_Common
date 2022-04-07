package com.example.lib_base.ui.views;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        if (parent.getChildLayoutPosition(view) == 0) {
//            outRect.left = 0;
//            outRect.right = 0;
//            outRect.bottom = 0;
//            outRect.top = 0;
//
//        } else
            if ((parent.getChildLayoutPosition(view) % 2) == 0) {
            outRect.left = space / 2;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = 0;
        } else {
            outRect.left = space;
            outRect.right = space / 2;
            outRect.top = space;
            outRect.bottom = 0;
        }

    }
}
