package com.example.evilslides.game.control;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilslides.R;
import com.example.evilslides.game.model.SlideImpl;

import java.util.List;

import static android.content.ContentValues.TAG;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<SlideImpl> slides;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public MyViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }
    public MyAdapter(List<SlideImpl> slides) {
        this.slides = slides;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        SlideImpl slide = slides.get(position);
        holder.textView.setText(slide.getText());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }
}
