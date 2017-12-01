package bullet.shoppinglist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
	private String tag = "myapp";
	private ArrayList<String> listItems = new ArrayList<>();
	private ArrayList<Double> valueItems = new ArrayList<>();
	private ArrayAdapter<String> adapter;
	private ArrayAdapter<Double> valueAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(tag, "on create before numberoftext");
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
		valueAdapter = new ArrayAdapter<Double>(this,android.R.layout.simple_list_item_1,valueItems);
		//setFocusOnEditText();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void AddElement(View v) {
		Double noPrice = 0.0;
		ListView listView = (ListView) findViewById(R.id.listView);
		EditText editText = (EditText) findViewById(R.id.editText);
		String value = editText.getText().toString();
		adapter.add(value);
		listView.setAdapter(adapter);
		Log.d(tag,"1st list set");
		valueAdapter.add(noPrice);
		ListView valueList = (ListView) findViewById(R.id.listView2);
		valueList.setAdapter(valueAdapter);
		Log.d(tag,"2nd list set");
		editText.setText("");
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.listView2);
		int x = linearLayout.getChildAt(0).getTop();
		Log.d(tag,"value of x: " + Integer.toString(x));
	}
}