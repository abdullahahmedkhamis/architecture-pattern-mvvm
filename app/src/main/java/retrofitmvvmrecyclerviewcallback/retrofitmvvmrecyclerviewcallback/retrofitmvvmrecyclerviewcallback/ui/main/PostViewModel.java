package retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit.GiveData;
import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit.PostClintData;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<GiveData>> givedata = new MutableLiveData<>(  );

    public void getposts(){
        PostClintData.getINSTANS().getPosts().enqueue( new Callback<List<GiveData>>() {
            @Override
            public void onResponse(Call<List<GiveData>> call, Response<List<GiveData>> response) {
                givedata.setValue( response.body() );
            }

            @Override
            public void onFailure(Call<List<GiveData>> call, Throwable t) {

            }
        } );


    }
}
