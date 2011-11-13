package acrabb.glist;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<List> lists;
	

	public MainListAdapter(Context context, ArrayList<List> lists){
		this.context = context;
		this.lists = lists;
	}
	
	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return lists.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflate = LayoutInflater.from(context);
		convertView = inflate.inflate(android.R.layout.simple_list_item_1, null);
		TextView mainText = (TextView)convertView.findViewById(android.R.id.text1);
		mainText.setText(lists.get(position).getName());
		return convertView;
	}

}
