package ted;

import ted.headless.Daemon;

public class TedMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// set menu to use on mac
		if (TedSystemInfo.osIsMac())
		{
			try
			{
				System.setProperty( "com.apple.mrj.application.apple.menu.about.name", "ted" );
			    System.setProperty( "apple.laf.useScreenMenuBar", "true" ); // for older versions of Java
			    System.setProperty( "com.apple.mrj.application.growbox.intrudes ", "true");
			    System.setProperty( "com.apple.mrj.application.live-resize", "true");
			    
			} 
			catch ( SecurityException e ) 
			{
			    /* probably not running on mac, do nothing */
			} 
		}
		boolean userWantsTray = true;
		boolean saveLocal = false;
		boolean headless = false;
		
		for(int i=0; i<args.length; i++)
		{
			if(args[i].equals("noTray"))
			{
				userWantsTray=false;
			}
			else if(args[i].equals("localSave"))
			{
				saveLocal=true;
			}
			else if (args[i].equals("headless"))
			{
				headless = true;
			}
		}
		
		if (!headless)
		{
			new TedMainDialog(userWantsTray, saveLocal);
		}
		else
		{
			Daemon.main(new String[0]);
		}

	}

}
