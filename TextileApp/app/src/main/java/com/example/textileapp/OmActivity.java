package com.example.textileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class OmActivity extends AppCompatActivity {

    EditText CD, ON, CN, IN, AN, ID, EWN, BAL1, BAL2, BAL3, BSN, BSC, BGST;
    EditText DAL1, DAL2, DAL3, DSN, DSC, DGST;
    EditText SRN, ITN, HSN, PIECES, QNTY, RATE, GA, SGSTAMT, CGSTAMT, IGSTAMT, TAMT, NETRATE, DD;
    EditText BN, BIFSC, BAC, BB, AMTW, TN, TM, VN, POS;
    Button submit, reset;
    String order_no, challan_no, invoice_no, agent_name, challan_date, invoice_date, eway_no, billing_add1, billing_add2, billing_add3, billing_sn, billing_sc, billing_gst, delivery_add1, delivery_add2, delivery_add3, delivery_sn, delivery_sc, delivery_gst;
    String srno, item_name, hsn, pies, quantity, rate, sgst, cgst, igst, due_date, bank_name, ifsc_code, acno, branch, word, t_name, t_mode, vehicle_no, posuppy;
    Double amt,gross_amt,total_amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_om);
        setid();
        setDate(CD);
        setDate(ID);
        setDate(DD);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CD.setText("");
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                order_no = ON.getText().toString();
                challan_no = CN.getText().toString();
                challan_date = CD.getText().toString();
                invoice_date = ID.getText().toString();
                invoice_no = IN.getText().toString();
                agent_name = AN.getText().toString();
                Toast.makeText(OmActivity.this,order_no+"\n"+challan_date+"\n"+challan_no+"\n"+invoice_date+"\n"+invoice_no+"\n"+agent_name,Toast.LENGTH_SHORT).show();
                Log.d("demo",order_no+"\n"+challan_date+"\n"+challan_no+"\n"+invoice_date+"\n"+invoice_no+"\n"+agent_name);

                eway_no = EWN.getText().toString();
                billing_add1 = BAL1.getText().toString();
                billing_add2 = BAL2.getText().toString();
                billing_add3 = BAL3.getText().toString();
                billing_sn = BSN.getText().toString();
                billing_sc = BSC.getText().toString();
                billing_gst = BGST.getText().toString();

                delivery_add1 = DAL1.getText().toString();
                delivery_add2 = DAL2.getText().toString();
                delivery_add3 = DAL3.getText().toString();
                delivery_sn = DSN.getText().toString();
                delivery_sc = DSC.getText().toString();
                delivery_gst = DGST.getText().toString();

                srno = SRN.getText().toString();
                item_name = ITN.getText().toString();
                hsn = HSN.getText().toString();
                pies = PIECES.getText().toString();
                quantity = QNTY.getText().toString();
                rate = RATE.getText().toString();
                sgst = SGSTAMT.getText().toString();
                cgst = CGSTAMT.getText().toString();
                igst = IGSTAMT.getText().toString();
                due_date = DD.getText().toString();
                gross_amt = amt = Double.parseDouble(quantity) * Double.parseDouble(rate);
                Log.d("demo",amt+"\n"+gross_amt);
                GA.setText(String.valueOf(gross_amt));

                total_amt = (Double.parseDouble(sgst)*amt*0.01) + (Double.parseDouble(igst)*amt*0.01) + (Double.parseDouble(cgst)*amt*0.01) + amt;
                Log.d("demo_amt",total_amt+"");
                Log.d("demo_gamt",gross_amt+"");
//                String numberz =numbers.getText().toString();
                try {
//                    final long number = Long.parseLong(String.valueOf(total_amt));
                    String returnz = Words.convert(total_amt);
                    Log.d("demo",returnz);

                } catch ( NumberFormatException e) {
                    //Toast.makeToast("illegal number or empty number" , toast.long)
                }

                bank_name = BN.getText().toString();
                ifsc_code =BIFSC.getText().toString();
                acno = BAC.getText().toString();
                branch = BB.getText().toString();
                t_name = TN.getText().toString();
                t_mode = TM.getText().toString();
                vehicle_no = VN.getText().toString();
                posuppy = POS.getText().toString();


            }
        });
    }

    private void setDate(EditText edit) {
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        OmActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                edit.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private void setid() {
        CD = findViewById(R.id.challanDateEdt);
        DD = findViewById(R.id.duedateEdt);
        ID = findViewById(R.id.invoiceDateEdt);
        ON = findViewById(R.id.order_noEdt);
        CN = findViewById(R.id.challan_noEdt);
        IN = findViewById(R.id.invoice_noEdt);
        AN = findViewById(R.id.agentNameEdt);
        EWN = findViewById(R.id.ewayBillEdt);

        BAL1 = findViewById(R.id.billingAddEdt1);
        BAL2 = findViewById(R.id.billingAddEdt2);
        BAL3 = findViewById(R.id.billingAddEdt3);
        BSC = findViewById(R.id.billingSCEdt);
        BSN = findViewById(R.id.billingSNEdt);
        BGST = findViewById(R.id.billingGSTEdt);

        DAL1 = findViewById(R.id.deliveryAddEdt1);
        DAL2 = findViewById(R.id.deliveryAddEdt2);
        DAL3 = findViewById(R.id.deliveryAddEdt3);
        DSC = findViewById(R.id.deliverySCEdt);
        DSN = findViewById(R.id.deliverySNEdt);
        DGST = findViewById(R.id.deliveryGSTEdt);

        SRN = findViewById(R.id.srnoEdt);
        ITN = findViewById(R.id.itemNameEdt);
        HSN = findViewById(R.id.hsnEdt);
        PIECES = findViewById(R.id.pieceEdt);
        QNTY = findViewById(R.id.qtyEdt);
        RATE = findViewById(R.id.rateEdt);
        GA = findViewById(R.id.grossAmtEdt);
        SGSTAMT = findViewById(R.id.SGSTEdt);
        CGSTAMT = findViewById(R.id.CGSTEdt);
        IGSTAMT = findViewById(R.id.IGSTEdt);
        TAMT = findViewById(R.id.totalAmtEdt);
        NETRATE = findViewById(R.id.netrateEdt);

        BN = findViewById(R.id.bankNameEdt);
        BIFSC = findViewById(R.id.ifscEdt);
        BAC = findViewById(R.id.acNoEdt);
        BB = findViewById(R.id.branchEdt);
        AMTW = findViewById(R.id.wordEdt);

        TM = findViewById(R.id.TModeEdt);
        TN = findViewById(R.id.TNameEdt);
        POS = findViewById(R.id.POSEdt);
        VN = findViewById(R.id.vehicleNoEdt);

        submit = findViewById(R.id.submitBtn);
        reset = findViewById(R.id.resetbtn);
    }
}