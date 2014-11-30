package com.TWP.Project.Fixes.FS.IS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FixMeStorage_Main extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fms_main);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				try {
					Process process = Runtime.getRuntime().exec("su");
					DataOutputStream os = new DataOutputStream(process.getOutputStream());
					DataInputStream es = new DataInputStream(process.getErrorStream());
					DataInputStream is = new DataInputStream(process.getInputStream());
					os.writeBytes("chown system:system /data/app-lib\n");
					String error = "";
					String other = "";
					while(es.available() > 0)
						error = error + es.readChar() + "\n";
					while(is.available() > 0)
						other = other + is.readChar() + "\n";
					os.writeBytes("chown system:system /data/app-lib/*\n");
					while(es.available() > 0)
						error = error + es.readChar() + "\n";
					while(is.available() > 0)
						other = other + is.readChar() + "\n";
					os.writeBytes("chown system:system /data/app-lib/*/*\n");
					while(es.available() > 0)
						error = error + es.readChar() + "\n";
					while(is.available() > 0)
						other = other + is.readChar() + "\n";
					os.writeBytes("exit\n");
					os.flush();
					process.waitFor();
					if(process.exitValue() == 0)
					{
						CharSequence tText = "Fix successfully executed/applied!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(getApplicationContext(), tText, duration);
						toast.show();
					}
					if(process.exitValue() >= 1)
					{
						failed();
					}
				} catch (Exception e) {
					if(e.getMessage().toLowerCase(Locale.ENGLISH).contains("working directory: null") && e.getMessage().toLowerCase(Locale.ENGLISH).contains("environment: null"))
					{
						failed();
					}
					// TODO: Add error reporting
				}
			}});
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				try {
					Process process = Runtime.getRuntime().exec("su");
					DataOutputStream os = new DataOutputStream(process.getOutputStream());
					DataInputStream es = new DataInputStream(process.getErrorStream());
					DataInputStream is = new DataInputStream(process.getInputStream());
					os.writeBytes("chmod -R 755 /data/app-lib\n");
					os.writeBytes("chmod 771 /data/app-lib\n");
					String error = "";
					String other = "";
					while(es.available() > 0)
						error = error + es.readChar();
					while(is.available() > 0)
						other = other + is.readChar();
					os.writeBytes("exit\n");
					os.flush();
					process.waitFor();
					if(process.exitValue() == 0)
					{
						CharSequence tText = "Fix successfully executed/applied!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(getApplicationContext(), tText, duration);
						toast.show();
					}
					if(process.exitValue() >= 1)
					{
						failed();
					}
				} catch (Exception e) {
					failed();
					// TODO: Add error reporting
				}
			}});
	}
	
	public void failed() 
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Fix failed. This could be due to any of the following:\n - No root access available.\n\thttp://xda-developers.com is a good place to start looking for a rooting method.\n - Root access denied\n - The fix just doesn't work on your device.");
		builder.setTitle("Failed");
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int id)
			{
				finish();
			}
			
		});
		builder.create().show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fix_me_storage__main, menu);
		return true;
	}

/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
}
