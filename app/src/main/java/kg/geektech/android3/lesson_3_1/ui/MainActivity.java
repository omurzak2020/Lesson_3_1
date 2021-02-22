package kg.geektech.android3.lesson_3_1.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

import kg.geektech.android3.lesson_3_1.R;
import kg.geektech.android3.lesson_3_1.data.models.Post;
import kg.geektech.android3.lesson_3_1.data.remote.RetrofitBuilder;
import kg.geektech.android3.lesson_3_1.ui.adapter.PageAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private final List<String> items = List.of("Item1", "Item2", "Item3");
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getPosts();
//        createPost(post);

//        PreferenceUtils.getPreferences(this).getUserName("id");
//        PreferenceUtils.getPreferences(this).saveUserName("UserName");

        viewPager2 = findViewById(R.id.view_pager);
//        viewPager2.setAdapter(new PageRecyclerAdapter(items));
        viewPager2.setAdapter(new PageAdapter(this, items));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                logMessage("Position: " + position + "PositionOffset: " + positionOffset + "PositionOffsetPixels: " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                pos = position;
                logMessage("Position: " + items.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                logMessage("State: " + state + " Of " + items.get(pos) + " Fragment ");
            }
        });
    }

    private void createPost(Post post) {
        RetrofitBuilder.getInstance().createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    logMessage("Success");
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                logMessage("Failure");
            }
        });
    }

    private void getPosts() {
        RetrofitBuilder.getInstance().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    logMessage(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                logMessage("Failure");
            }
        });
    }

    private void logMessage(String msg) {
        Log.d("tag", msg);
    }
}