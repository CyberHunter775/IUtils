package com.xin.iutils.network;


import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xin.iutils.R;


/**
 * 
 * @author xin
 * @date 2016-1-5
 *
 */
@SuppressLint("NewApi")
public class LoadingFragment extends DialogFragment {
	private TextView vLoading_text;
	private String mMsg = "正在加载···";

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		Builder builder = new Builder(getActivity(), R.style.MyLoadDialog);
		View view = getActivity().getLayoutInflater().inflate(R.layout.frag_loading, null);
		
		vLoading_text = (TextView) view.findViewById(R.id.loading_text);
		vLoading_text.setText(mMsg);
		builder.setView(view);
		builder.setCancelable(false);
		return builder.create();
	}
	
	public void setMsg(String msg) {
		if (msg != null) {
			this.mMsg = msg;
		}
	}
	
	
	
}
