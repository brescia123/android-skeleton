package com.gbresciani.androidSkeleton.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gbresciani.androidSkeleton.App;
import com.gbresciani.androidSkeleton.R;
import com.gbresciani.androidSkeleton.injection.modules.PresentersModule;

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
        setupPresentersComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        // Attach to the presenter: thanks to setRetainInstance(true) the Fragment instance should
        // survive configuration changes, so the presenter is still alive.
        presenter.bindView(this);
        initUI();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbindView();
    }


    /*
    * View methods
    */

    @Override
    public void setupPresentersComponent() {
        // Inject presenters annotated with @Inject
        App.getAppComponent().plus(new PresentersModule()).inject(this);
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

    /*
    * Private methods
    */

    /**
     * Initialize the UI...
     */
    private void initUI() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadGist();
            }
        });
    }

}
