package org.knulikelion.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button thumbUp, thumbDown, writing, showAll;
    TextView countUp, countDown;
    boolean likeState; //좋아요 버튼이 선택 상태 알리기 위해서
    boolean dislikeState; //싫어요 버튼이 선택 상태 알리기 위해서
    int likeCount = 10;
    int dislikeCount = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thumbUp = (Button) findViewById(R.id.thumbUp);
        thumbDown = (Button) findViewById(R.id.thumbDown);
        writing = (Button) findViewById(R.id.writing);
        showAll = (Button)findViewById(R.id.showAll);
        countUp = (TextView) findViewById(R.id.countUp);
        countDown = (TextView) findViewById(R.id.countDown);
        ListView listView = (ListView)findViewById(R.id.listview);

        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**", "10분전",
                "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.",R.drawable.user1));
        adapter.addItem(new CommentItem("kym72**", "20분전",
                "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.",R.drawable.user1));
        adapter.addItem(new CommentItem("kym73**", "30분전",
                "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요.",R.drawable.user1));
        listView.setAdapter(adapter);

        thumbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState == false) {
                    incrLikeCount();
                }
                else {
                    decrLikeCount();
                }
                likeState = !likeState;
            }
        });

        thumbDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState == false) {
                    incrDisLikeCount();
                }
                else{
                    decrDisLikeCount();
                }
                dislikeState = !dislikeState;
            }
        });

        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"작성하기 버튼", Toast.LENGTH_LONG).show();
            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"모두보기 버튼", Toast.LENGTH_LONG).show();
            }
        });
    }

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CommentItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentView view = new CommentView(getApplicationContext());
            CommentItem item = items.get(position);
            view.setName(item.getName());
            view.setTime(item.getTime());
            return view;
        }
    }

    public void incrLikeCount() {
        likeCount += 1;
        countUp.setText(String.valueOf(likeCount));
        thumbUp.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount() {
        likeCount -= 1;
        countUp.setText(String.valueOf(likeCount));
        thumbUp.setBackgroundResource(R.drawable.thumbs_selector);
    }

    public void incrDisLikeCount() {
        dislikeCount += 1;
        countDown.setText(String.valueOf(dislikeCount));
        thumbDown.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrDisLikeCount() {
        dislikeCount -= 1;
        countDown.setText(String.valueOf(dislikeCount));
        thumbDown.setBackgroundResource(R.drawable.thumbs_selector2);
    }
}
