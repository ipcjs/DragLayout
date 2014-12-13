package com.bluemor.reddotface.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bluemor.reddotface.R;

/**
 * Created by JiangSong on 2014/12/6.
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "content_layout");
        menu.add(0, 1, 0, "content_draw");
        menu.add(0, 2, 0, "view_layout");
        menu.add(0, 3, 0, "view_draw");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                findViewById(android.R.id.content).requestLayout();
                break;
            case 1:
                findViewById(android.R.id.content).invalidate();
                break;
            case 2:
                findViewById(R.id.view).requestLayout();
                break;
            case 3:
                findViewById(R.id.view).invalidate();
                break;
        }
        return false;
    }
}
