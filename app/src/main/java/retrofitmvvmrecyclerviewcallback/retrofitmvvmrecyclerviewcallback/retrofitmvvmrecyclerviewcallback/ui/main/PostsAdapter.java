package retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvmrecyclerviewcallback.R;

import java.util.ArrayList;
import java.util.List;

import retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.retrofitmvvmrecyclerviewcallback.classforgivedatabyretrofit.GiveData;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<GiveData> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder( LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.showdata.setText(moviesList.get(position).getTitle());
        holder.userData.setText(moviesList.get(position).getUserId()+"");
        holder.bodyData.setText(moviesList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<GiveData> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView showdata, userData, bodyData;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            showdata = itemView.findViewById( R.id.showdata);
            userData = itemView.findViewById(R.id.userData);
            bodyData = itemView.findViewById(R.id.bodyData);
        }
    }
}
