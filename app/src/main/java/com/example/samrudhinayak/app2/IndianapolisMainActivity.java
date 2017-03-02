package com.example.samrudhinayak.app2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.app.ActionBar;
import android.widget.Toast;

/**
 * Created by Samrudhi Nayak on 3/10/2016.
 */
//for the fragments to communicate with each other, the interface must be defined. ListSelection is that interface and is defined in ListFragment
public class IndianapolisMainActivity extends AppCompatActivity implements
        IListsFragment.ListSelectionListener {
    // strings to hold the values to be displayed or accessed
    public static String[] myIArray;
    public static String[] myIURLArray;

    private final IBrowserFragment myBrowserFragment = new IBrowserFragment();
    private FragmentManager mFragmentManager;
    private FrameLayout myIBrowserLayout, myIListLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //get the strings from the strings.xml file
        myIArray = getResources().getStringArray(R.array.IList);
        myIURLArray = getResources().getStringArray(R.array.IURLs);

        setContentView(R.layout.activity_main);
        //layouts of the 2 fragments
        myIBrowserLayout = (FrameLayout) findViewById(R.id.browserfragment_container);
        myIListLayout = (FrameLayout) findViewById(R.id.listfragment_container);

        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Add the ListFragment to the layout
        fragmentTransaction.replace(R.id.listfragment_container,
                new IListsFragment());

        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }
    //set the layout according to the orientation
    private void setLayout() {
        //checks for the orientation and displays the webview in the full layout if it is in portrait mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (!myBrowserFragment.isAdded()) {
                myIListLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                myIBrowserLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {
                myIListLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        0, MATCH_PARENT));
                myIBrowserLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT));
            }
        }
        //checks for the orientation and displays the webview in the 2/3rd of the layout if it is in landscape mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (!myBrowserFragment.isAdded()) {
                myIListLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                myIBrowserLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {
                myIListLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        0, MATCH_PARENT,1f));
                myIBrowserLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT,2f));
            }
        }
    }
    //when item is selected in the list, inflate the webview for that item
    @Override
    public void onListSelection(int index) {
        if (!myBrowserFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            //replace the current fragment so as to avoid overlapping over previous layout
            fragmentTransaction.replace(R.id.browserfragment_container,
                    myBrowserFragment);

            //addToBackStack so that the back key takes us to the list on the first fragment
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }
        //inflate the webview for the given item on the list
        if (myBrowserFragment.getIndex() != index) {
            myBrowserFragment.showView(index);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openchicago();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //opens the Chicago city from the overflow area menu list selection
    public void openchicago()
    {
        Intent myintent =new Intent(this,ChicagoMainActivity.class);
        startActivity(myintent);
    }
    //returns the correct fragment when the orientation is changed
    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            //pop the previous entry from backstack
            getFragmentManager().popBackStack();
        }
    }
    //to handle change in orientation from portrait to landscape or vice versa
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //set layout according to the orientation
        setLayout();
    }
}

