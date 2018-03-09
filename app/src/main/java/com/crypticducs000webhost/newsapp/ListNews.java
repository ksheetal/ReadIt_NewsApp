package com.crypticducs000webhost.newsapp;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNews extends AppCompatActivity {

    KenBurnsView kbv;
    DiagonalLayout diagonalLayout;
    AlertDialog dialog;
  //  SpotsDialog dialog;
    NewsService mService;
    TextView top_author, top_title;
    SwipeRefreshLayout swipeRefreshLayout;

    String source ="" ,sortBy="" ,webHotUrl="";

    ListNewsAdapter adapter;
    RecyclerView lstNews;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        //Service
         mService = Common.getNewsService();
         dialog = new SpotsDialog(this);

         // Views
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadNews(source,true);
            }
        });

        diagonalLayout =(DiagonalLayout)findViewById(R.id.diagonalLayout);
        diagonalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click to read latest news
                Intent  detail = new Intent(getBaseContext(),DetailArticle.class);
                detail.putExtra("webURL",webHotUrl);
                startActivity(detail);

            }
        });
        kbv = (KenBurnsView)findViewById(R.id.top_image);
        top_author=(TextView)findViewById(R.id.top_Author);
        top_title=(TextView)findViewById(R.id.top_title);

        lstNews = (RecyclerView)findViewById(R.id.lstNews);
        lstNews.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstNews.setLayoutManager(layoutManager);


        // Intents
        if(getIntent() != null)
        {
            source = getIntent().getStringExtra("source");
            sortBy = getIntent().getStringExtra("sortBy");

            if(!source.isEmpty() && !sortBy.isEmpty())
            {
                loadNews(source,false);
                
            }

        }

    }

    private void loadNews(String source, boolean isRefreshed ) {
        if(!isRefreshed)
        {
            dialog.show();
            mService.getNewestArticles(Common.getApiUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            // get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotUrl = response.body().getArticles().get(0).getUrl();

                            // loading remaining article

                            List<Article> removeFirstItem =  response.body().getArticles();
                            removeFirstItem.remove(0);
                            adapter = new ListNewsAdapter(removeFirstItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
        }
        else
        {

            dialog.show();
            mService.getNewestArticles(Common.getApiUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            // get first article
                            Picasso.with(getBaseContext())
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotUrl = response.body().getArticles().get(0).getUrl();

                            // loading remaining article

                            List<Article> removeFirstItem =  response.body().getArticles();
                            removeFirstItem.remove(0);
                            adapter = new ListNewsAdapter(removeFirstItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
