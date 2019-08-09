package com.ucsdextandroid2.android2final;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Collections;
import java.util.List;


public class DataSource {

    //private static final String TAG = DataSource.class.getSimpleName();

    private static DataSource instance;
    private DataApi dataApi;

    public DataSource() {
        Gson gson = new GsonBuilder().create();

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.level(HttpLoggingInterceptor.Level.BODY);

        this.dataApi = new Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(logger).build())
                .build()
                .create(DataApi.class);
    }

    public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
        return instance;
    }

    public interface Callback<T> {
        void onDataFetched(T results);
    }

    public void search(String searchJob, int pageNumber, Callback<List<? extends JobItem>> callback) {
        dataApi.search(searchJob, pageNumber).enqueue(new retrofit2.Callback<List<JobItem>>() {
            @Override
            public void onResponse(Call<List<JobItem>> call, Response<List<JobItem>> response) {
                if (response.isSuccessful()) {
                    callback.onDataFetched(response.body());
                }
                else
                    callback.onDataFetched(Collections.emptyList());
            }

            @Override
            public void onFailure(Call<List<JobItem>> call, Throwable t) {
                callback.onDataFetched(Collections.emptyList());
            }
        });
    }

    public interface DataApi {
        @GET("positions.json")
        Call<List<JobItem>> search(@Query("description") String description, @Query("page") int page);
    }
}




