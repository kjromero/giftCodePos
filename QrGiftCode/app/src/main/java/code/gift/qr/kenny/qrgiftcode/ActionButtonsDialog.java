package code.gift.qr.kenny.qrgiftcode;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * Created by kenny.romero on 04/08/2015.
 */
public class ActionButtonsDialog extends DialogFragment {

    private DialogListener listener;
    private String monto;
    private EditText editText;

    public interface DialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String monto);

        public void onDialogNegativeClick(DialogFragment dialog);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the
            // host
            listener = (DialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement DialogListener");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View textEntryView = inflater.inflate(R.layout.dialog_monto_qr, null);

        builder.setView(textEntryView)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        editText = (EditText)textEntryView.findViewById(R.id.dt_monto);
                        monto = editText.getText().toString();
                        listener.onDialogPositiveClick(ActionButtonsDialog.this, monto);

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogNegativeClick(ActionButtonsDialog.this);
                    }
                });

        return builder.create();

    }


}
