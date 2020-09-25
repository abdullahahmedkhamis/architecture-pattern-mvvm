package retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitmvvmrecyclerviewcallback.R;

import java.util.List;

import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit.GiveData;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        postViewModel = ViewModelProviders.of( this ).get( PostViewModel.class );
        postViewModel.getposts();

        RecyclerView recyclerView =findViewById( R.id.welcomerecyclerView );
        final PostsAdapter postsadapter = new PostsAdapter();
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.setAdapter( postsadapter );

        postViewModel.givedata.observe(this, new Observer<List<GiveData>>() {
            @Override
            public void onChanged(List<GiveData> postModels) {
                postsadapter.setList(postModels);
            }
        });
    }
}