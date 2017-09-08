package como.example.android.justjava;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 0;
    private String priceMessage = "--";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        display(++quantity);
    }

    public void decrement(View view) {
        quantity--;
        if(quantity<0) {
            Toast.makeText(this, "No Coffee ? :(", Toast.LENGTH_SHORT).show();
            quantity=0;
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message = "Order placed Successfully :D";
        if(quantity==0)
            message = "A fully empty cup of coffee is coming";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        displayPrice(quantity * 5);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "See ya", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceMessage = "Total : " + NumberFormat.getCurrencyInstance().format(number) + "\nThank You!";
        priceTextView.setText(priceMessage);
    }
}