package be.ehb.demopopup.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ontlener on 20/01/2038. ;)
 */
public class ToppingsDialog extends DialogFragment {

    private static boolean[] isChecked;

    //interface, deze wordt in de activity geimplementeerd,
    //zo sturen we een callback van het fragment naar de activity
    //we maken onze eigen View.OnClickListener
    public interface DialogConfirmListener{
        void confirm(ArrayList<String> toppings);
    }
    private DialogConfirmListener dialogConfirmListener;

    public void setDialogConfirmListener(DialogConfirmListener dialogConfirmListener) {
        this.dialogConfirmListener = dialogConfirmListener;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] toppings = {"gehackt", "tomaten", "ajuin", "ananas"};
        if(isChecked == null) {
            isChecked = new boolean[toppings.length];
            Arrays.fill(isChecked, false);
        }
        final ArrayList<String> gekozenToppings = new ArrayList<>();

        AlertDialog.Builder bob = new AlertDialog.Builder(getActivity());

        bob.setTitle("Kies toppings");
        bob.setMultiChoiceItems(toppings, isChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    gekozenToppings.add(toppings[which]);
                }else{
                    gekozenToppings.remove(toppings[which]);
                }
            }
        });
        bob.setNegativeButton("cancel", null);
        bob.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //op confirm geklikt, stuur dit door naar de activity
                dialogConfirmListener.confirm(gekozenToppings);
            }
        });

        return bob.create();
    }
}
