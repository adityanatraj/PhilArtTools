package com.anatraj.philarttools.fragments;

import android.content.Context;
import android.util.Log;


public class TabbedFragment extends android.support.v4.app.Fragment {

    public interface PagingHost {
        void goToPage(int page);
    }

    private PagingHost mPageHost;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPageHost = (PagingHost) getActivity();
    }

    @Override
    public void onDetach() {
        mPageHost = null;
        super.onDetach();
    }

    public void goToPage(int page) {
        if( mPageHost == null ) { Log.d("tf/gtp", "no page host attached"); return; }

        mPageHost.goToPage(page);
    }
}
