package com.example.fragmentsdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HelloFragment extends Fragment {
	Button btnSubmit;
	private FragmentListener listener;
	EditText etText;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if (activity instanceof FragmentListener) {
	        listener = (FragmentListener) activity;
	      } else {
	        throw new ClassCastException(activity.toString()
	            + " must implement MyListFragment.OnItemSelectedListener");
	      }
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayList<String> things = new ArrayList<String>();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		//return inflater.inflate(R.layout.fragment_hello, container, false);
		
		
		// Defines the xml file for the fragment
		View view = inflater.inflate(R.layout.fragment_hello, container, false);
		// Setup handles to view objects here
		btnSubmit = (Button) view.findViewById(R.id.btnSubmit);		
		etText = (EditText) view.findViewById(R.id.editText1);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				listener.onSubmitted(etText.getText().toString());				
			}
		});
		
		return view;
	}	
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		// assume the activity is fully created with views and all
		//getActivity().getActionBar();
	}
	
	// Define the events that the fragment will use to communicate
	  public interface FragmentListener {
	    public void onSubmitted(String text);
	  }

	public void setSomeProperty(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
