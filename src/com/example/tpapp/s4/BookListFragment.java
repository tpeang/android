package com.example.tpapp.s4;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListFragment extends ListFragment{
	private Callbacks mCallbacks;
	public interface Callbacks{
		public void onItemSelected(Integer id);
	}
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if(!(activity instanceof Callbacks)){
			throw new IllegalStateException("BookListFragement 所在的Activity必须实现CallBacks接口！");
		}
		mCallbacks = (Callbacks)activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, BookContent.ITEMS));
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		mCallbacks = null;
	}
	public void setActivateOnItemClick(boolean activateOnItemClick){
		getListView().setChoiceMode(activateOnItemClick?ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
	}
	

}
