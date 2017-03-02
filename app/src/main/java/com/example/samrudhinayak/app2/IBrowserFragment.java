package com.example.samrudhinayak.app2;

/**
 * Created by Samrudhi Nayak on 3/10/2016.
 */
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


public class IBrowserFragment extends Fragment {

    private WebView myView ;
    private int mCurrIdx = -1;
    private int myArrLen;
    //get the index of selected item
    int getIndex() {
        return mCurrIdx;
    }
    //open the webview of the item selected
    void showView(int newIndex) {
        if (newIndex < 0 || newIndex >= myArrLen)
            return;
        mCurrIdx = newIndex;
        //load the appropriate url of the selected item
        myView.loadUrl(IndianapolisMainActivity.myIURLArray[mCurrIdx]);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //save the state even on orientation change
        setRetainInstance(true);
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout defined in browserfragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.browserfragment,
                container, false);
    }

    // Set up some information about the WebView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myView = (WebView) getActivity().findViewById(R.id.urlView);
        //the 2 lines given below are used to fit the web page precisely within the webview
        //loads the webview completely zoomed out
        myView.getSettings().setLoadWithOverviewMode(true);
        //loads the webpage with attributes set in the meta tag of webpage which makes the webpage have a normal viewport such as desktop browsers
        myView.getSettings().setUseWideViewPort(true);
        myArrLen = IndianapolisMainActivity.myIURLArray.length;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
