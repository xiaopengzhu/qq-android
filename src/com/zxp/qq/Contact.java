package com.zxp.qq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.string;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Contact extends ListFragment{
    private ListView lv;
    private SimpleAdapter adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment_contact, null);
        lv = (ListView)view.findViewById(android.R.id.list);
        
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        adapter = new SimpleAdapter(getActivity(), getData(), R.layout.contact_listview_item, new String[]{"title", "num"}, new int[]{R.id.title, R.id.num});
        setListAdapter(adapter);
    }
    
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "我的好友");
        map.put("num", "23/60");
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "社会关系");
        map.put("num", "11/160");
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", "亲戚网友");
        map.put("num", "3/10");
        list.add(map);
        
        return list;
    }

}
