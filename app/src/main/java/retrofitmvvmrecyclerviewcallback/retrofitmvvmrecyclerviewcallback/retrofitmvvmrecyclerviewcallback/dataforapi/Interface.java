package retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.dataforapi;

import android.icu.text.MessagePattern;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit.GiveData;

public interface Interface {
    @GET("posts")
    public Call<List<GiveData>> getposts();
}
