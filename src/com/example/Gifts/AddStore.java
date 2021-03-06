package com.example.Gifts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.Gifts.Classes.Gift_Class;
import com.example.Gifts.Classes.Group_Class;
import com.example.Gifts.Classes.Person_Class;
import com.example.Gifts.Classes.Store_Class;

import java.util.ArrayList;

/**
 * Created by Anosh on 11/26/2014.
 */
public class AddStore extends Activity {

    ArrayList<Person_Class> person;
    ArrayList<Gift_Class> gift;
    ArrayList<Group_Class> group;
    ArrayList<Store_Class> store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_store);
        ImageView img = (ImageView) findViewById(R.id.storeImagea_s);
        img.setImageResource(R.drawable.store);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {    // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.menu_accept:
                TextView storeName = (TextView) findViewById(R.id.storeNamea_s);
                if (storeName.getText().toString().equals("")) {
                    new AlertDialog.Builder(this)
                            .setTitle("Error")
                            .setMessage("You did not enter a name.")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                } else {
                    MyActivity.setStore(storeName.getText().toString());
                    Intent main = new Intent(this, MyActivity.class);
                    startActivity(main);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}