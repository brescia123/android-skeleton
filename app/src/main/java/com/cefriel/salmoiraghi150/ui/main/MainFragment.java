package com.cefriel.salmoiraghi150.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cefriel.salmoiraghi150.App;
import com.cefriel.salmoiraghi150.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainFragment extends Fragment implements MainFragmentView {


    @Bind(R.id.button)
    Button button;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.textView)
    TextView textView;

    @Inject
    MainPresenter presenter;


    public MainFragment() {
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((App) getActivity().getApplication()).getPresentersComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadGist();
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
        button.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }
}