package be.ehb.demopopup.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

/**
 * Created by ontlener on 20/01/2038. ;)
 */
public class SimpleDialog extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Alert");
        builder.setMessage("Past oep eh manneke");
        builder.setNegativeButton("kansel", null);

        return builder.create();
    }
}
