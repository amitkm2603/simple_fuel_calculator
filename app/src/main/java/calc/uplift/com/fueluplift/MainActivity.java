package calc.uplift.com.fueluplift;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;
//define the elements to be accessed from UI

public class MainActivity extends ActionBarActivity
{
//define the buttons and txt fields
    EditText fuel_uplift;
    EditText total_fuel_required;
    EditText specific_gravity;
    EditText total_fuel_required_before_refuelling;
    TextView calc_fuel_uplift;
    TextView calc_fuel_required;
    Button calculate;
    Button reset;
    Context  context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //map the field variables with the actual fields in the UI
         fuel_uplift = (EditText)findViewById(R.id.fuel_uplift_txt);
         total_fuel_required = (EditText)findViewById(R.id.tot_fuel_req_txt);
         specific_gravity = (EditText)findViewById(R.id.spec_grav_txt);
         total_fuel_required_before_refuelling = (EditText)findViewById(R.id.before_ref_txt);
         calc_fuel_uplift = (TextView)findViewById(R.id.result_fuel_uplift_calc);
         calc_fuel_required = (TextView)findViewById(R.id.result_fuel_req);
         calculate = (Button)findViewById(R.id.calculate_btn);
         reset = (Button)findViewById(R.id.reset_btn);
         context = getApplicationContext();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void  calculate_fuel_uplift(View view)
    {
        try{
            float fuel_uplift_float = Float.parseFloat(fuel_uplift.getText().toString());
            float specific_gravity_float = Float.parseFloat(specific_gravity.getText().toString());
            float fuel_uplift_calculated  = fuel_uplift_float * specific_gravity_float;

            float total_fuel_required_float =  Float.parseFloat(total_fuel_required.getText().toString());
            float before_refueling_float =  Float.parseFloat(total_fuel_required_before_refuelling.getText().toString());
            float uplift_fuel_required = total_fuel_required_float - before_refueling_float;

            calc_fuel_required.setText(String.valueOf(uplift_fuel_required));
            calc_fuel_uplift.setText(String.valueOf(fuel_uplift_calculated));
        }
        catch (NumberFormatException nfe){
            Toast.makeText(context,"Invalid input. Please enter a valid number.\n Error message: "+nfe.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(context,"Something went wrong! Unable to calculate.\n Error message: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void reset_all(View view)
    {
        fuel_uplift.setText("");
        total_fuel_required.setText("");
        specific_gravity.setText("");
        total_fuel_required_before_refuelling.setText("");
        calc_fuel_uplift.setText("");
        calc_fuel_required.setText("");
    }

}
