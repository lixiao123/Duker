package org.foree.contentprovidersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 切换浏览模式
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    Button bt_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        bt_item = (Button) findViewById(R.id.bn_item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter = new ImageAdapter());

        bt_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // insert data
            }
        });
    }

    class ImageAdapter extends RecyclerView.Adapter<ImageHolder> {

        @Override
        public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ImageHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.image_holder_linearlayout, parent, false));
        }

        @Override
        public void onBindViewHolder(ImageHolder holder, int position) {
            // setText
        }

        @Override
        public int getItemCount() {
            return 0;
        }

    }

    class ImageHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ImageHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}