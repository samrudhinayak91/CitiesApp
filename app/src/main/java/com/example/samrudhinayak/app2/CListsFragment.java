package com.example.samrudhinayak.app2;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Samrudhi Nayak on 3/10/2016.
 */
public class CListsFragment extends ListFragment {
    private ListSelectionListener myListener=null;
    //interface for the listener used in the main activity for each city
    public interface ListSelectionListener{
        public void onListSelection(int index);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //highlight the selected item
        getListView().setItemChecked(position,true);
        myListener.onListSelection(position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

            // Set the ListSelectionListener for communicating with the Browser CBrowserFragment
            myListener = (ListSelectionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //save the state even when orientation has changed
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //use predefined ArrayAdapter to plug in the values of the list into the textview
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.listfragment, ChicagoMainActivity.myArray));
        //allow only one item to be selected
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
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
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

