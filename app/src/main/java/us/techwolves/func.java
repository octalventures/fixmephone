package us.techwolves;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.TWP.Project.Fixes.FS.IS.R;

public class func
{
	public static void failed(final Activity app)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(app);
		builder.setMessage("Fix failed. This could be due to any of the following:\n - No root access available.\n\thttp://xda-developers.com is a good place to start looking for a rooting method.\n - Root access denied\n - The fix just doesn't work on your device.");
		builder.setTitle("Failed");
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
		{
			@Override public void onClick(DialogInterface dialog, int id)
			{
				app.finish();
			}

		});
		builder.create().show();
	}
}
