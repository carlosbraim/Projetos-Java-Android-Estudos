package com.example.idene.sliderprojeto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){

        this.context = context;
    }

    //Array
    public  int[] slide_images ={
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon

    };

    public String[] slider_headings ={
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_descs ={
            "Eat is good  have a kitchen or small kitchen area for preparing meals or food, and many homes also have",
            "Sleep is good too  have a small kitchen area for premany homes also have",
            "code is good  have a kitchen or small n area for preparing meals or food, and many"
    };

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImagView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImagView.setImageResource(slide_images[position]);
        slideHeading.setText(slider_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);




        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}
