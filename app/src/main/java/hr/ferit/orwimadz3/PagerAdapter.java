package hr.ferit.orwimadz3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Locale;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4;
    private static final String TAB_NAME = "#%d";
    private String message = "Default message";

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return InputFragment.newInstance();
            case 1:
                return MessageFragment.newInstance(message);
            case 2:
                return ModularFragment.newInstance("text");
            default:
                return ModularFragment.newInstance("");

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.format(Locale.getDefault(), TAB_NAME, position + 1);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
