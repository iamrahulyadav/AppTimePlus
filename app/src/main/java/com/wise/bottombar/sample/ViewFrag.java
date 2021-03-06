package com.wise.bottombar.sample;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ViewFrag extends android.support.v4.app.Fragment {

    @SuppressLint("ValidFragment")
    ViewFrag(){}
    ListView listView;
    FreindsAdapter freindsAdapter ;
    ArrayList<Sett> list;
    Toolbar tt;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewxml,container,false);
        progressDialog=new ProgressDialog(getActivity());
        listView=(ListView)view.findViewById(R.id.settingList);
        list=new ArrayList<Sett>();
        tt=(Toolbar)view.findViewById(R.id.toolbar2);
        tt.setTitle("  Settings");
        tt.setLogo(R.mipmap.settings);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tt);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 6:
                        progressDialog.setMessage("Signing out...");
                        progressDialog.show();
                        mAuth = FirebaseAuth.getInstance();
                        mAuth.signOut();
                        progressDialog.dismiss();
                        startActivity(new Intent(getActivity(), MainActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(getActivity(),FrList.class));
                        break;

                    case 1:
                        startActivity(new Intent(getActivity(),ChangeP.class));
                        break;

                    case 3:
                        startActivity(new Intent(getActivity(),About.class));
                        break;

                    case 5:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String sharebody="App Time Plus:- \nhttps://play.google.com/store/apps/details?id=com.wise.bottombar.sample";
                        String sharesub="";
                        intent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                        intent.putExtra(Intent.EXTRA_TEXT,sharebody);
                        startActivity(Intent.createChooser(intent,"Share App using"));
                        break;

                    case 0:
                        startActivity(new Intent(getActivity(),UploadPic.class));
                        break;

                    case 4:
                        startActivity(new Intent(getActivity(),AppsSelection.class));
                        break;


                }
            }
        });
        Sett s=new Sett(R.mipmap.profile,"Profile");
        list.add(s);
        s=new Sett(R.mipmap.editprofile,"Change Password");
        list.add(s);
        s=new Sett(R.mipmap.friends,"Friends");
        list.add(s);
        s=new Sett(R.mipmap.about,"About");
        list.add(s);
        s=new Sett(R.mipmap.appscheck,"Select Apps");
        list.add(s);
        s=new Sett(R.mipmap.share,"Share");
        list.add(s);
        s=new Sett(R.mipmap.logout,"Logout");
        list.add(s);
        freindsAdapter=new FreindsAdapter(getActivity(), R.layout.fri,list);
        listView.setAdapter(freindsAdapter);

        return view;
    }
}