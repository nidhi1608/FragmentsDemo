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

public class SecondFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		//return inflater.inflate(R.layout.fragment_hello, container, false);
		
		
		// Defines the xml file for the fragment
		View view = inflater.inflate(R.layout.fragment_second, container, false);
		
		
		return view;
	}	
	
	

	public void setSomeProperty(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
