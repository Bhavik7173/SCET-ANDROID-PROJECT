package com.example.firebaserealtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText employeeName, employeePhone, employeeAddress;
    Button submit;
    String name,address,phone;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EmployeeInfo employeeInfo;
    int PERMISSION_ALL = 1;
    TextView retrieveTV;
    String[] PERMISSIONS = {android.Manifest.permission.ACCESS_NETWORK_STATE, android.Manifest.permission.INTERNET, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeAddress = findViewById(R.id.idEdtEmployeeAddress);
        employeeName = findViewById(R.id.idEdtEmployeeName);
        employeePhone = findViewById(R.id.idEdtEmployeePhone);
        retrieveTV = findViewById(R.id.idTVRetrieveData);
        submit = findViewById(R.id.submitBtn);

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        //connect to firebase databases
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("EmployeeInfo");
        employeeInfo = new EmployeeInfo();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = employeeName.getText().toString();
                address = employeeAddress.getText().toString();
                phone = employeePhone.getText().toString();

//                addDataToFirebase(name,address,phone);
                readDataFromFirebase();
            }
        });
    }

    private void readDataFromFirebase() {
        databaseReference = firebaseDatabase.getReference("EmployeeInfo");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                EmployeeInfo data = snapshot.getValue(EmployeeInfo.class);
                retrieveTV.setText(data+"");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed to Connect"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean hasPermissions(Context context, String[] permissions)
    {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null)
        {
            for (String permission : permissions)
            {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                {
                    return false;
                }
            }
        }
        return true;
    }
    private void addDataToFirebase(String name, String address, String phone) {
        employeeInfo.setEmployeeAddress(address);
        employeeInfo.setEmployeePhone(phone);
        employeeInfo.setEmployeeName(name);

//        EmployeeInfo employeeInfo1 = new EmployeeInfo(name,phone,address);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(employeeInfo);
                Toast.makeText(MainActivity.this, "Added it", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to Connet" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}