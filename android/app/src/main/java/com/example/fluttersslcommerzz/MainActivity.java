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


public class MainActivity extends FlutterActivity    {
    private static final String CHANNEL = "com.flutter.connect/connection";
    PaymentActivity mClass= new PaymentActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                        final Map<String, Object> parameters = methodCall.arguments();
                        if (methodCall.method.equals("Printy")) {
                            String name = (String) parameters.get("name");
                            result.success("Hi from Java" + name);
                        }
                        if (methodCall.method.equals("Pay")) {
                            String name = (String) parameters.get("name");
                            result.success("Hi from Java" + name);
                            //mClass.pay();
                           //PayMent pay= new PayMent();
                           //pay.pay();
                //             final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization ("demo60e3deefed3eb","demo60e3deefed3eb@ssl", 10, SSLCCurrencyType.BDT,"123456789098765", "yourProductType", SSLCSdkType.TESTBOX);
                //             final SSLCCustomerInfoInitializer customerInfoInitializer = new SSLCCustomerInfoInitializer("customer name","customer email","address","dhaka", "1214", "Bangladesh","phoneNumber");
                //             final SSLCProductInitializer productInitializer = new SSLCProductInitializer ("food", "food",new SSLCProductInitializer.ProductProfile.TravelVertical("Travel", "10","A", "12", "Dhk-Syl"));
                //             final SSLCShipmentInfoInitializer shipmentInfoInitializer = new SSLCShipmentInfoInitializer ("Courier", 2, new SSLCShipmentInfoInitializer.ShipmentDetails("AA","Address 1","Dhaka","1000","BD"));
            
                //             IntegrateSSLCommerz
                //             .getInstance(mClass)
                //             .addSSLCommerzInitialization(sslCommerzInitialization)
                //             .addCustomerInfoInitializer(customerInfoInitializer)
                //             .addProductInitializer(productInitializer)
                //             .buildApiCall(new SSLCTransactionResponseListener() {
                //                 @Override
                //                 public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
                            
                //                    //result.success("connection: "+sslcTransactionInfoModel.getAPIConnect()+"Status :"+sslcTransactionInfoModel.getStatus() );
                //                     //tv.setText("connection: "+sslcTransactionInfoModel.getAPIConnect()+"Status :"+sslcTransactionInfoModel.getStatus() );
                //                 }
                   
                //                 @Override
                //                 public void transactionFail(String s) {
                //                     //result.success(s);
                //                     //Log.e(TAG, s);
                //                 }
                //                 @Override
                //                 public void merchantValidationError(String s) {
                //                    // result.success(s);
                //                 }
                    
                              
                //                 public void error(int errorCode) {
                //                    // result.success(errorCode);
                   
                //                 }

                //             } );
                   
                            
                        }
                     }
                });
             
               
    }
}


class PayMent extends AppCompatActivity{
    void pay(){
        final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization ("demo60e3deefed3eb","demo60e3deefed3eb@ssl", 10, SSLCCurrencyType.BDT,"123456789098765", "yourProductType", SSLCSdkType.TESTBOX);
        final SSLCCustomerInfoInitializer customerInfoInitializer = new SSLCCustomerInfoInitializer("customer name","customer email","address","dhaka", "1214", "Bangladesh","phoneNumber");
        final SSLCProductInitializer productInitializer = new SSLCProductInitializer ("food", "food",new SSLCProductInitializer.ProductProfile.TravelVertical("Travel", "10","A", "12", "Dhk-Syl"));
        final SSLCShipmentInfoInitializer shipmentInfoInitializer = new SSLCShipmentInfoInitializer ("Courier", 2, new SSLCShipmentInfoInitializer.ShipmentDetails("AA","Address 1","Dhaka","1000","BD"));

        IntegrateSSLCommerz
        .getInstance(PayMent.this)
        .addSSLCommerzInitialization(sslCommerzInitialization)
        .addCustomerInfoInitializer(customerInfoInitializer)
        .addProductInitializer(productInitializer)
        .buildApiCall(new SSLCTransactionResponseListener() {
            @Override
            public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
        
               //result.success("connection: "+sslcTransactionInfoModel.getAPIConnect()+"Status :"+sslcTransactionInfoModel.getStatus() );
                //tv.setText("connection: "+sslcTransactionInfoModel.getAPIConnect()+"Status :"+sslcTransactionInfoModel.getStatus() );
            }

            @Override
            public void transactionFail(String s) {
                //result.success(s);
                //Log.e(TAG, s);
            }
            @Override
            public void merchantValidationError(String s) {
                //result.success(s);
            }

          
            public void error(int errorCode) {
                //result.success(errorCode);

            }

        } );
    }
}