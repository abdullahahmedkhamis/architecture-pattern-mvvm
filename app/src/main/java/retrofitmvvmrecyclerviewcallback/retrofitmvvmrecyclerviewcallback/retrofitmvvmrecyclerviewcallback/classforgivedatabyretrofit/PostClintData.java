package retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.dataforapi.Interface;

public class PostClintData {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Interface iinterface;
    private static PostClintData INSTANS;

    public PostClintData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        iinterface = retrofit.create( Interface.class );

    }


    public static PostClintData getINSTANS() {
        if (null == INSTANS){}
        INSTANS = new PostClintData();
        return INSTANS;
    }

    public Call<List<GiveData>> getPosts(){
        return iinterface.getposts();
    }
}
