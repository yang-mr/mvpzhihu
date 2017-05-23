package com.yw.mvpzhihu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.socks.library.KLog;
import com.yw.mvpzhihu.contact.MainActivityViewContact;
import com.yw.mvpzhihu.ui.bean.BaseRvFragment;
import com.yw.mvpzhihu.ui.presenter.MainPresenter;
import com.yw.mvpzhihu.ui.bean.BaseActivity;
import com.yw.mvpzhihu.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class MainActivity extends BaseActivity implements MainActivityViewContact.View {
    @Bind(R.id.tv_message)
    TextView tvMessage;
    @Bind(R.id.message_net)
    RelativeLayout messageNet;
    @Bind(R.id.vp_content)
    ViewPager vpContent;
    @Bind(R.id.rg_group)
    RadioGroup rgGroup;
    private MainPresenter mMainPresenter;
    private List<BaseRvFragment> mListFragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mMainPresenter = new MainPresenter(this);
        mListFragment = new ArrayList<>();
        mListFragment.add(new HomeFragment());
        mListFragment.add(new HomeFragment());
        mListFragment.add(new HomeFragment());

        KLog.d(vpContent);
        rgGroup.check(R.id.rb_order);
        
        vpContent.setAdapter(new MyAdapter(getSupportFragmentManager(), mListFragment));

        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case R.id.rb_order:
                        vpContent.setCurrentItem(0);
                        break;
                    case R.id.rb_service:
                        vpContent.setCurrentItem(1);
                        break;
                    case R.id.rb_me:
                        vpContent.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_order:
                        vpContent.setCurrentItem(0);
                        break;
                    case R.id.rb_service:
                        vpContent.setCurrentItem(1);
                        break;
                    case R.id.rb_me:
                        vpContent.setCurrentItem(2);
                        break;
                }
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void succeed() {

    }
    
    private class MyAdapter extends FragmentPagerAdapter{
        private List<BaseRvFragment> lists;
        public MyAdapter(FragmentManager fm, List list) {
            super(fm);
            this.lists = list;
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }
    }
}
