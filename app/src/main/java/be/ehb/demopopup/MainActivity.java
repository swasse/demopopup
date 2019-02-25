package be.ehb.demopopup;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import be.ehb.demopopup.dialogs.SimpleDialog;
import be.ehb.demopopup.dialogs.ToppingsDialog;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabSnackBar;
    private Button btnToast, btnSimpleDialog, btnToppings;

    private View.OnClickListener fabsnackbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar sb = Snackbar.make(findViewById(R.id.main_container), "Hello pizza", Snackbar.LENGTH_INDEFINITE );
            sb.setActionTextColor(Color.GREEN);
            sb.setAction("banaan", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TEST", "Clicked in the snackbar");
                }
            });
            sb.show();
        }
    };

    //anonymous inner class
    private View.OnClickListener toastOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Cheers", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener simpleDialogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SimpleDialog simpleDialog = new SimpleDialog();
            simpleDialog.show(getSupportFragmentManager(), "id");
        }
    };

    private View.OnClickListener toppingsDialogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ToppingsDialog toppingsDialog = new ToppingsDialog();
            toppingsDialog.setDialogConfirmListener(dialogConfirmListener);
            toppingsDialog.show(getSupportFragmentManager(), "id");
        }
    };

    private ToppingsDialog.DialogConfirmListener dialogConfirmListener = new ToppingsDialog.DialogConfirmListener() {
        @Override
        public void confirm(ArrayList<String> toppings) {
            Toast.makeText(getApplicationContext(), toppings.toString(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabSnackBar = findViewById(R.id.fab_snackbar);
        fabSnackBar.setOnClickListener(fabsnackbarOnClickListener);

        btnToast = findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(toastOnClickListener);

        btnSimpleDialog = findViewById(R.id.btn_simple);
        btnSimpleDialog.setOnClickListener(simpleDialogOnClickListener);

        btnToppings = findViewById(R.id.btn_toppings);
        btnToppings.setOnClickListener(toppingsDialogOnClickListener);
    }
}