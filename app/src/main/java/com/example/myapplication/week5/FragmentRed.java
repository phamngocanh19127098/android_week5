package com.example.myapplication.week5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class FragmentRed extends Fragment implements FragmentCallbacks {
    private String HoTen[] = {"Nguyen Son", "Pham Anh", "Nguyen Viet","Nguyen Phan Vu","Con Phan Vu"};
    private String Lop[] = {"A1", "A1", "A1","A1","A1"};
    private String DiemTB[] = {"8", "7", "8","7","8"};
    private String MaSo[] = {"A1_1809", "A1_1810", "A1_1811","A1_1812","A1_1813"};
    MainActivity main; TextView txtRed; Button btnRedClock;
    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle(); bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( "Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// inflate res/layout_red.xml which includes a textview and a button
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(R.layout.layout_red, null);
        txtRed = (TextView) view_layout_red.findViewById(R.id.textView1Red);
// show string argument supplied by constructor (if any!)
//        try { Bundle arguments = getArguments(); txtRed.setText(arguments.getString("arg1", "")); }
//        catch (Exception e) { Log.e("RED BUNDLE ERROR – ", "" + e.getMessage()); }
// clicking the button changes the time displayed and sends a copy to MainActivity

        return view_layout_red;
    }
    @Override
    public void onMsgFromMainToFragment(String strValue) {
// receiving a message from MainActivity (it may happen at any point in time)
        int position = Integer.parseInt(strValue);
        txtRed.setText(""+ " \n \t\t\t\t\t\t "+ MaSo[position] + "\n\n\n Ho Ten: "+ HoTen[position] +
                "\n Lop: "+ Lop[position] + "\n Diem Trung Binh: "+ DiemTB[position]);
    }}// FragmentRe
