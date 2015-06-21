package com.example.midterm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText inputEditText ;
	private TextView rotTextView;
	private SeekBar rotSeekBar;
	private EditText outputEditText;
	private int changeValue;
	private Button outputButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inputEditText = (EditText)findViewById(R.id.inputEditText);
		rotTextView = (TextView)findViewById(R.id.rotTextView);
		rotSeekBar = (SeekBar)findViewById(R.id.rotSeekBar);
		outputEditText=(EditText)findViewById(R.id.outputEditText);
		outputButton=(Button)findViewById(R.id.outputButton);
		rotSeekBar.setOnSeekBarChangeListener(ganesh);
		outputButton.setOnClickListener(yes);
		
		
				
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
	
	private OnSeekBarChangeListener ganesh= new OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			changeValue= progress;
		    update();
			
		}
	};
	public void update() {
		
		rotTextView.setText(Integer.toString(changeValue));
		
	}
	
	private OnClickListener yes= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			rotate();
		}
	};
	
	public void rotate() {
		
		char[] arr=inputEditText.getText().toString().toCharArray();
		int cip=rotSeekBar.getProgress();
		String output="";
		for(char c: arr){
			
			if(Character.isLetter(c)) {
				
				c = (char)(c + cip);
				 if(!(Character.isLetter(c))){
					 c -= 26;
				 }
				 output += c;
			}
		}
		outputEditText.setText(output);
		
	}
}
