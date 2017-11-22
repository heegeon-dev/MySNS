package com.example.gmlrj.mysns;



import android.content.Intent;



import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;

import android.app.Fragment;

import android.app.FragmentManager;

import android.app.FragmentTransaction;

import android.support.annotation.NonNull;



public class NaviActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navi);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);





        Fragment fragment = new SearchFragment();

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_search, fragment);

        fragmentTransaction.commit();

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener

            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        public boolean onNavigationItemSelected(@NonNull MenuItem item) {



            Fragment fragment;



            switch (item.getItemId()) {

                default:

                case R.id.ic_search:{

                    fragment = new SearchFragment();

                    break;

                }

                case R.id.profil: {

                    fragment = new ProfileFragment();

                    break;

                }

                case R.id.map: {

                    fragment = new MapFragment();

                    break;

                }

                case R.id.ic_setting: {

                    fragment = new SettingFragment();

                    break;

                }

                case R.id.ic_people: {

                    fragment = new SocialFragment();

                    break;

                }



            }

            FragmentManager fragmentManager = getFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment_search, fragment);

            fragmentTransaction.commit();

            return false;

        }

    };

}