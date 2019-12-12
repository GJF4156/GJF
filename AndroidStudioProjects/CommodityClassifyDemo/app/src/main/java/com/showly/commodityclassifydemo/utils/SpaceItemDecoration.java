package com.showly.commodityclassifydemo.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Item之间相差的间隔
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int type;
    private Context context;
    private int leftRight;
    private int topBottom;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    public SpaceItemDecoration(Context context, int space, int type) {
        this.context = context;
        this.space = CommonUtils.dip2px(context, space);
        ;
        //this.space = space;
        this.type = type;
    }

    public SpaceItemDecoration(Context context, int leftRight, int topBottom, int type) {
        this.context = context;
        this.topBottom = CommonUtils.dip2px(context, topBottom);
        this.leftRight = CommonUtils.dip2px(context, leftRight);
        this.type = type;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        switch (type) {
            case 0://gridview 间距
                outRect.left = space;
                outRect.right = 0;
                outRect.top = space;
                outRect.bottom = 0;

                if (parent.getChildAdapterPosition(view) % 3 == 0) {
                    outRect.left = 0;
                }
                break;
            case 1://横向布局间距
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.left = space;
                }
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = space;
                }
                break;
            case 2://相册图片边距
                outRect.left = space;
                outRect.bottom = space;
                if (parent.getChildAdapterPosition(view) % 3 == 0) {
                    outRect.left = 0;
                }

                break;
            case 3://系统消息
                outRect.top = space;
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = 0;
                }
                break;
            case 4:
                if (parent.getChildPosition(view) != 0)
                    outRect.top = space;
                break;
            case 5://上下间距
                if (parent.getChildPosition(view) != 0) {
                }
                outRect.left = space;
                outRect.top = space;
                outRect.right = 0;
                outRect.bottom = 0;

                if (parent.getChildAdapterPosition(view) % 2 == 0) {
                    outRect.left = 0;
                }
                break;
            case 6://上下间距
                if (parent.getChildPosition(view) != 0)
                    outRect.left = space;
                outRect.top = space;
                outRect.right = 0;
                outRect.bottom = 0;

                if (parent.getChildAdapterPosition(view) % 3 == 0) {
                    outRect.left = 0;
                }
                break;
        }
    }

    private void setGridViewItemDecoration(Rect outRect, View view, RecyclerView parent) {
        GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
        //判断总的数量是否可以整除
        int totalCount = layoutManager.getItemCount();
        int surplusCount = totalCount % layoutManager.getSpanCount();
        int childPosition = parent.getChildAdapterPosition(view);
        if (layoutManager.getOrientation() == GridLayoutManager.VERTICAL) {//竖直方向的
            if (surplusCount == 0 && childPosition > totalCount - layoutManager.getSpanCount() - 1) {
                //后面几项需要bottom
                outRect.bottom = topBottom;
            } else if (surplusCount != 0 && childPosition > totalCount - surplusCount - 1) {
                outRect.bottom = topBottom;
            }
            if ((childPosition + 1) % layoutManager.getSpanCount() == 0) {//被整除的需要右边
                outRect.right = leftRight;
            }
            outRect.top = topBottom;
            outRect.left = leftRight;
        } else {
            if (surplusCount == 0 && childPosition > totalCount - layoutManager.getSpanCount() - 1) {
                //后面几项需要右边
                outRect.right = leftRight;
            } else if (surplusCount != 0 && childPosition > totalCount - surplusCount - 1) {
                outRect.right = leftRight;
            }
            if ((childPosition + 1) % layoutManager.getSpanCount() == 0) {//被整除的需要下边
                outRect.bottom = topBottom;
            }
            outRect.top = topBottom;
            outRect.left = leftRight;
        }

    }
}
