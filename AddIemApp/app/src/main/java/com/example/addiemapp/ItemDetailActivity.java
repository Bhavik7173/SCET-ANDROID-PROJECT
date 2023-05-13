package com.example.addiemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class ItemDetailActivity extends AppCompatActivity {

    private Button buttonView;
    private LinearLayout parentLayout;
    private int hint = 0;
    EditText srno, item, hsn, piece, quantity, rate;
    TextInputEditText srno1, item1, hsn1, piece1, quantity1, rate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        buttonView = (Button) findViewById(R.id.buttonView);
        parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                createEditTextView();
            }
        });
    }

    protected void createEditTextView() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.setMargins(10, 10, 10, 10);

        CardView.LayoutParams cardparam = new FrameLayout.LayoutParams(
                CardView.LayoutParams.MATCH_PARENT,
                CardView.LayoutParams.WRAP_CONTENT);
        srno1 = new TextInputEditText(this);
        srno = new EditText(this);
        item = new EditText(this);
        hsn = new EditText(this);
        piece = new EditText(this);
        quantity = new EditText(this);
        rate = new EditText(this);
        int maxLength = 5;
        hint++;

        srno1.setHint("Sr No " + hint);
        srno1.setLayoutParams(params);
//        srno.setBackgroundColor(Color.WHITE);
        srno1.setInputType(InputType.TYPE_CLASS_TEXT);
        srno1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        srno1.setId(hint);


        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);

        srno1.setFilters(fArray);
        parentLayout.addView(srno1);

        item.setHint("Item Name " + hint);
        item.setLayoutParams(params);
        // edtTxt.setBackgroundColor(Color.WHITE);
        item.setInputType(InputType.TYPE_CLASS_TEXT);
        item.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        srno.setId(hint);


        InputFilter[] fArray1 = new InputFilter[1];
        fArray1[0] = new InputFilter.LengthFilter(maxLength);

        item.setFilters(fArray1);
        parentLayout.addView(item);
    }
}