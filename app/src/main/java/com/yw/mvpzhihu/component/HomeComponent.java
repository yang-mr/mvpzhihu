package com.yw.mvpzhihu.component;

import com.yw.mvpzhihu.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by yangwei on 2017/5/23--15:17.
 * <p>
 * E-Mail:yangwei199402@gmail.com
 */
@Component(dependencies = AppComponent.class)
public interface HomeComponent {
    HomeFragment inject(HomeFragment homeFragment);
}
