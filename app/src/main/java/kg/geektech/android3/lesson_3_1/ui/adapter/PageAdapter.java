package kg.geektech.android3.lesson_3_1.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import kg.geektech.android3.lesson_3_1.ui.PageFragment;

public class PageAdapter extends FragmentStateAdapter {

    private final List<String> items;

    public PageAdapter(@NonNull FragmentActivity fragmentActivity, List<String> items) {
        super(fragmentActivity);
        this.items = items;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
