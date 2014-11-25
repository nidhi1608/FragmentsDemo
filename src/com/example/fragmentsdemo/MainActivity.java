package com.example.fragmentsdemo;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fragmentsdemo.HelloFragment.FragmentListener;


public class MainActivity extends FragmentActivity implements FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        
        if(savedInstanceState == null) {
        	// Begin the transaction
        	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        	// Replace the container with the new fragment
        	ft.replace(R.id.flPlaceHolder, new HelloFragment(), "hello");
        	// Execute the changes specified
        	ft.commit();
        }
        
        setupTabs();
        
        HelloFragment fragmentHello = (HelloFragment) getSupportFragmentManager().findFragmentByTag("hello");
        //fragmentHello.setSomeProperty(true);
    }
    
    private void setupTabs() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);

		Tab tab1 = actionBar
			.newTab()
			.setText("First")
			
			.setTabListener(
				new FragmentTabListener<HelloFragment>(R.id.flPlaceHolder, this, "first",
						HelloFragment.class));

		actionBar.addTab(tab1);
		actionBar.selectTab(tab1);

		Tab tab2 = actionBar
			.newTab()
			.setText("Second")
			
			.setTabListener(
			    new FragmentTabListener<SecondFragment>(R.id.flPlaceHolder, this, "second",
								SecondFragment.class));

		actionBar.addTab(tab2);
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onSubmitted(String text) {
		Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
		
	}
}
