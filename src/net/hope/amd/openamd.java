package net.hope.amd;

//import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class openamd extends TabActivity {
    /** Called when the activity is first created. */
    @Override

/*    public void onCreate(Bundle savedInstanceState) {
    	  super.onCreate(savedInstanceState);
          setContentView(R.layout.main);
    }*/
    public void onCreate(Bundle savedInstanceState) {
     
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    //SET UP TABS
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, schedule.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("schedule").setIndicator("Schedule").setContent(intent);
        
        //use this if you want an icon for the tabs, set them in the ic_tab_artists.xml file
        //spec = tabHost.newTabSpec("schedule").setIndicator("Schedule", res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
        
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, stats.class);
        spec = tabHost.newTabSpec("stats").setIndicator("Stats").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, games.class);
        spec = tabHost.newTabSpec("games").setIndicator("Games").setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    // END OF SETUP TABS
    }  
    //SETUP Variables
        private static final int MENU_ABOUT = 10000;
        private static final int MENU_QUIT = 10001;
        private static final int DIALOG_ABOUT = 20000;
        
        public boolean onCreateOptionsMenu(Menu menu){
        	menu.add(0, MENU_ABOUT, 0 , "About");
        	menu.add(0, MENU_QUIT, 0, "Quit");	
        	return true;
        }
        
        public boolean onOptionsItemSelected(MenuItem item){
        	switch(item.getItemId()){
        	case MENU_ABOUT:
        		onCreateDialog(DIALOG_ABOUT);
        		return true;
        	case MENU_QUIT:
        		System.exit(0);
        		return true;
        	}
        	return false;
        }
    //END SETUP MENU BUTTONS
        
    //SETUP ABOUT WINDOW
        protected Dialog onCreateDialog(int id){
        	Dialog dialog = null;
        	
        	switch(id){
        	case DIALOG_ABOUT:
            AlertDialog ad = new AlertDialog.Builder(this).create();
            ad.setMessage(getString(R.string.dialog_about));
            ad.setButton("Close",  new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	//here you can add functions
                 } });
            ad.show();
        	break;
        	
        	default:
        		dialog = null;;
        	}
        	return dialog;
        }
        
    }