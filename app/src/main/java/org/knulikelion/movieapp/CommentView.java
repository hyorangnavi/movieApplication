package org.knulikelion.movieapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentView extends LinearLayout {
    TextView textview1, textview2, textview3;
    ImageView imageID;

    public CommentView(Context context) {
        super(context);
        init(context);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_view,this,true);
        textview1 = (TextView)findViewById(R.id.name);
        textview2 = (TextView)findViewById(R.id.time);
        textview3 = (TextView)findViewById(R.id.summary);
        imageID = (ImageView)findViewById(R.id.imageID);
    }

    public void setName(String name) {
        textview1.setText(name);
    }

    public void setTime(String time) {
        textview2.setText(time);
    }

    public void setSummary(String summary) {
        textview3.setText(summary);
    }

    public void setResID(int resID) {
        imageID.setImageResource(resID);
    }
}
