package us.techwolves.fixes.storage;

import android.app.Activity;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Locale;

import us.techwolves.func;

public class fix1
{
	public fix1(Activity app)
	{
		try
		{
			Process process = Runtime.getRuntime().exec("su");
			DataOutputStream os = new DataOutputStream(process.getOutputStream());
			DataInputStream es = new DataInputStream(process.getErrorStream());
			DataInputStream is = new DataInputStream(process.getInputStream());
			os.writeBytes("chown system:system /data/app-lib\n");
			String error = "";
			String other = "";
			while(es.available() > 0)
			{
				error = error + es.readChar() + "\n";
			}
			while(is.available() > 0)
			{
				other = other + is.readChar() + "\n";
			}
			os.writeBytes("chown system:system /data/app-lib/*\n");
			while(es.available() > 0)
			{
				error = error + es.readChar() + "\n";
			}
			while(is.available() > 0)
			{
				other = other + is.readChar() + "\n";
			}
			os.writeBytes("chown system:system /data/app-lib/*/*\n");
			while(es.available() > 0)
			{
				error = error + es.readChar() + "\n";
			}
			while(is.available() > 0)
			{
				other = other + is.readChar() + "\n";
			}
			os.writeBytes("exit\n");
			os.flush();
			process.waitFor();
			if(process.exitValue() == 0)
			{
				CharSequence tText = "Fix successfully executed/applied!";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(app, tText, duration);
				toast.show();
			}
			if(process.exitValue() >= 1)
			{
				func.failed(app);
			}
		}
		catch(Exception e)
		{
			if(e.getMessage().toLowerCase(Locale.ENGLISH).contains("working directory: null") && e.getMessage().toLowerCase(Locale.ENGLISH).contains("environment: null"))
			{
				func.failed(app);
			}
			// TODO: Add error reporting
		}
	}
}
