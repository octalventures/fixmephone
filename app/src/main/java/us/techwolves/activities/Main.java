package us.techwolves.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.TWP.Project.Fixes.FS.IS.R;

import us.techwolves.fixes.storage.fix1;
import us.techwolves.fixes.storage.fix2;

public class Main extends ActionBarActivity
{

	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Activity me = this;
		setContentView(R.layout.Main);
		/*********   Storage   *********/
		/****      Fix 1            ****/
		Button storage_fix1 = (Button) findViewById(R.id.storage_fix1);
		storage_fix1.setOnClickListener(new OnClickListener()
		{

			@Override public void onClick(View arg0)
			{
				new fix1(me);
			}
		});
		/****      Fix 2            ****/
		Button storage_fix2 = (Button) findViewById(R.id.storage_fix2);
		storage_fix2.setOnClickListener(new OnClickListener()
		{

			@Override public void onClick(View arg0)
			{
				new fix2(me);
			}
		});
	}
}
