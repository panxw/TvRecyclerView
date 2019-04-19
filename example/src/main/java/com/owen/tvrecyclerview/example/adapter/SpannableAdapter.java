/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.owen.tvrecyclerview.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.owen.adapter.CommonRecyclerViewAdapter;
import com.owen.adapter.CommonRecyclerViewHolder;
import com.owen.tvrecyclerview.example.App;
import com.owen.tvrecyclerview.example.R;
import com.owen.tvrecyclerview.example.data.ItemBean;
import com.owen.tvrecyclerview.widget.SpannableGridLayoutManager;

public class SpannableAdapter extends CommonRecyclerViewAdapter<ItemBean> {
    private RecyclerView mRecyclerView;
    
    public SpannableAdapter(Context context, RecyclerView recyclerView) {
        super(context);
        mRecyclerView = recyclerView;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item;
    }
    
    public void showImage(CommonRecyclerViewHolder helper, int viewId, String url) {
        ImageView imageView = helper.getHolder().getView(viewId);
        Glide.with(App.get()).load(url).into(imageView);
    }

    @Override
    public void onBindItemHolder(CommonRecyclerViewHolder helper, ItemBean item, int position) {
        helper.getHolder()
                .setText(R.id.title, String.valueOf(position));
        showImage(helper, R.id.image, item.imgUrl);

        final View itemView = helper.itemView;
        final boolean isVertical = mRecyclerView.getLayoutManager().canScrollVertically();

        final SpannableGridLayoutManager.LayoutParams lp =
                (SpannableGridLayoutManager.LayoutParams) itemView.getLayoutParams();

        //final int span1 = (position == 0 || position == 6 || position == 13 || position == 5 ? 2 : 1);
        //final int span2 = (position == 0 || position == 6 || position == 13 ? 2 : position == 5 ? 4 : 1);

        SpanParam sp = getSpanParamApp(position);

        if (lp.rowSpan != sp.rowSpan || lp.colSpan != sp.colSpan) {
            lp.rowSpan = sp.rowSpan;
            lp.colSpan = sp.colSpan;

            itemView.setLayoutParams(lp);
        }
    }


    private SpanParam getSpanParamMy(int position){
        int colSpan = 1;
        int rowSpan = 1;
        if(position==0 || position==1) {
            colSpan=2;
            rowSpan=2;
        }else {
            colSpan=1;
            rowSpan=2;
        }
        return new SpanParam(rowSpan, colSpan);
    }

    private SpanParam getSpanParamJinxuan(int position){
        int colSpan = 1;
        int rowSpan = 1;
        if(position==4) {
            colSpan=2;
            rowSpan=4;
        }else if(position==5|| position==6){
            colSpan=2;
            rowSpan=2;
        }else if(position==7|| position==8) {
            colSpan=1;
            rowSpan=2;
        }else if(position==9) {
            colSpan=3;
            rowSpan=3;
        }else if(position==11) {
            colSpan=2;
            rowSpan=3;
        }else if(position==10) {
            colSpan=3;
            rowSpan=1;
        } if(position==12) {
            colSpan=2;
            rowSpan=1;
        }else if(position>12){
            colSpan=1;
            rowSpan=2;
        }
        return new SpanParam(rowSpan, colSpan);
    }

    private SpanParam getSpanParamDianying(int position){
        int colSpan = 1;
        int rowSpan = 1;
        if(position==4) {
            colSpan=4;
            rowSpan=2;
        }else if(position==5 || position==6||position==12 || position==13){
            colSpan=2;
            rowSpan=2;
        }else if(position==11) {
            colSpan=2;
            rowSpan=4;
        }else if(position>6 && position<11) {
            colSpan=1;
            rowSpan=2;
        }
        return new SpanParam(rowSpan, colSpan);
    }

    private SpanParam getSpanParamApp(int position){
        int colSpan = 1;
        int rowSpan = 1;
        if(position==0) {
            colSpan=2;
            rowSpan=3;
        }
        if(position==3) {
            colSpan=2;
            rowSpan=2;
        }
        if(position==4) {
            colSpan=2;
            rowSpan=1;
        }
        if(position==7) {
            colSpan=1;
            rowSpan=2;
        }
        if(position==8) {
            colSpan=2;
            rowSpan=1;
        }
        if(position==10) {
            colSpan=1;
            rowSpan=2;
        }
        return new SpanParam(rowSpan, colSpan);
    }

   private static class  SpanParam {
        public SpanParam(int row, int col){
            this.rowSpan=row;
            this.colSpan=col;
        }
        int colSpan=1;
        int rowSpan=1;
    }
}
