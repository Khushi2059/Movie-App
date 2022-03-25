package com.example.movieapp.ui.main.view;

import static org.junit.Assert.*;

import android.view.View;
import android.widget.TableLayout;

import androidx.test.rule.ActivityTestRule;

import com.example.movieapp.R;
import com.google.android.material.tabs.TabLayout;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class HomeActivityTest {
@Rule
public ActivityTestRule<HomeActivity> homeActivityActivityTestRule=new ActivityTestRule<HomeActivity>(HomeActivity.class);
private  HomeActivity homeActivity=null;

    @Before
    public void setUp() throws Exception {
    homeActivity=homeActivityActivityTestRule.getActivity();
    }
@Test
public void testLaunch()
{
    TabLayout tabLayout =homeActivity.findViewById(R.id.tabLayout);
    assertNotNull(tabLayout);
}
    @After
    public void tearDown() throws Exception {
    homeActivity=null;
    }
}