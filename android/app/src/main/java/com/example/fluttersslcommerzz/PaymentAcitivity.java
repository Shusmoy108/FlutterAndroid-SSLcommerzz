package com.example.fluttersslcommerzz;
import android.os.Bundle;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCall;
import java.nio.channels.Channel;
import io.flutter.embedding.android.FlutterActivity;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCCustomerInfoInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCProductInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCShipmentInfoInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;

class PaymentActivity extends AppCompatActivity implements SSLCTransactionResponseListener {
    
    protected void pay() {
      
        final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization
                ("das5f45f2b6ccdaf","das5f45f2b6ccdaf@ssl", 10,
                        SSLCCurrencyType.BDT,"123456789098765", "yourProductType", SSLCSdkType.TESTBOX);

        final SSLCCustomerInfoInitializer customerInfoInitializer = new
                SSLCCustomerInfoInitializer("customer name","customer email",
                "address","dhaka", "1214", "Bangladesh","phoneNumber");

        final SSLCProductInitializer productInitializer = new SSLCProductInitializer ("food", "food",
        new SSLCProductInitializer.ProductProfile.TravelVertical("Travel", "10",
        "A", "12", "Dhk-Syl"));
        final SSLCShipmentInfoInitializer shipmentInfoInitializer = new SSLCShipmentInfoInitializer
          ("Courier", 2, new SSLCShipmentInfoInitializer.ShipmentDetails("AA","Address 1","Dhaka","1000","BD"));

        IntegrateSSLCommerz
                .getInstance(PaymentActivity.this)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .addCustomerInfoInitializer(customerInfoInitializer)
                .addProductInitializer(productInitializer)
                .buildApiCall(this);



    }// end on Create


    @Override
    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {

        //tv.setText("connection: "+sslcTransactionInfoModel.getAPIConnect()+"Status :"+sslcTransactionInfoModel.getStatus() );
    }

    @Override
    public void transactionFail(String s) {
        //tv.setText(s);
    }

    @Override
    public void merchantValidationError(String s) {

        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
}