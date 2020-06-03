package com.example.evilslides.library.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evilslides.R;
import com.example.evilslides.library.model.CardImpl;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<CardImpl> slides;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            this.view = v;
            textView = view.findViewById(R.id.textView);
        }
    }

    public MyAdapter(List<CardImpl> slides) {
        this.slides = slides;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new MyViewHolder(v);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardImpl slide = slides.get(position);
        holder.textView.setText(slide.getText());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }
}
