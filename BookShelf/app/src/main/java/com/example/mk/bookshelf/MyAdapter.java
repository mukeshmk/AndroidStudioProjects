package com.example.mk.bookshelf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.mk.bookshelf.R.drawable.e;

/**
 * Created by Admin on 05-01-2017.
 */
public class MyAdapter extends BaseAdapter {

    Books b;
    Integer[] mThumbIds = {
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l,
    };

    Context context;
    private LayoutInflater inflater;
    ArrayList<Books> bookList;

    public MyAdapter(Context context, ArrayList<Books> bookList) {
        this.context = context;
        this.bookList = bookList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return bookList.size();

    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_grid_item, null);

        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView bname = (TextView) convertView.findViewById(R.id.bname);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView price = (TextView) convertView.findViewById(R.id.price);

        b = bookList.get(position);

        img.setImageResource(mThumbIds[position]);
        bname.setText(b.getName());
        author.setText(b.getAuthor());
        price.setText(b.getPrice());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        //Toast.makeText(context, "Goes to 2nd", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, " " + position, Toast.LENGTH_SHORT).show();
        b = bookList.get(position);
        Intent i = new Intent(context, Main2Activity.class);
        i.putExtra("bname", b.getName());
        i.putExtra("author", b.getAuthor());
        i.putExtra("price", b.getPrice());
        i.putExtra("pos", position);
        context.startActivity(i);
        return position;
    }

}
