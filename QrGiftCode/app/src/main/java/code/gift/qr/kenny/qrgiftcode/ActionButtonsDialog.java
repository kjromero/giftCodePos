package code.gift.qr.kenny.qrgiftcode;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


/**
 * Created by kenny.romero on 04/08/2015.
 */
public class ActionButtonsDialog extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Set the message to display.
        builder.setMessage("Are you sure?");

        // Set a listener to be invoked when the positive button of the dialog
        // is pressed.
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent inten = new Intent(getActivity(), Login_Activity.class);
                startActivity(inten);
            }
        });

        // Set a listener to be invoked when the negative button of the dialog
        // is pressed.
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "No", Toast.LENGTH_SHORT).show();
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
