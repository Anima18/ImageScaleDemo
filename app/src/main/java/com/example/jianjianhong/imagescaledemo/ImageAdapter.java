package com.example.jianjianhong.imagescaledemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jianjianhong on 2016/9/8.
 */
public class ImageAdapter extends BaseAdapter {

    private List<Integer> imageIds;
    private LayoutInflater layoutInflater;
    private Context context;
    private int imageViewWidth, imageViewHeight;

    public ImageAdapter(Context context, List<Integer> imageIds) {
        this.context = context;
        this.imageIds = imageIds;
        this.layoutInflater = LayoutInflater.from(context);
        this.imageViewWidth = DisplayUtil.dip2px(context, 500);
        this.imageViewHeight = DisplayUtil.dip2px(context, 500);
    }

    @Override
    public int getCount() {
        return imageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return imageIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_tem,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv1);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        InputStream is = context.getResources().openRawResource(imageIds.get(position));
        BitmapFactory.Options opts =  new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;

        BitmapFactory.decodeStream(is, null, opts);
        //BitmapFactory.decodeResource(context.getResources(), imageIds.get(position), opts);

        int imgWidth = opts.outWidth;
        int imgHeight = opts.outHeight;
        Log.i("ImageAdapter", "imgWidth:"+imgWidth+", imgHeight:"+imgHeight);

        Log.i("ImageAdapter", "imgWidthddd:"+imageViewWidth+", imgHeightddd:"+imageViewHeight);
        int scaleX = imgWidth/imageViewWidth;  //水平方向的缩放比

        int scaleY = imgHeight/imageViewHeight; //垂直方向的缩放比
        Log.i("ImageAdapter", "scaleX:"+scaleX+", scaleY:"+scaleY);

        int scale = 1; //缩放比

        if(scaleX >= scaleY && scaleY >= 1){

            scale = scaleX;

        }else if(scaleY >= scaleX && scaleX >= 1){

            scale = scaleY;

        }

        //接下来解析图片
        Log.i("ImageAdapter", "scale:"+scale);
        opts.inJustDecodeBounds = false;
        //采样率

        opts.inSampleSize = scale;

        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageIds.get(position), opts);
        Bitmap bitmap = BitmapFactory.decodeStream(is, null, opts);
        holder.imageView.setImageBitmap(bitmap);

        return convertView;
    }

    final class ViewHolder{
        public ImageView imageView;

    }
}
