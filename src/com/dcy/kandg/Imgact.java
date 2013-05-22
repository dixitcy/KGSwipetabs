package com.dcy.kandg;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;



public class Imgact extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.imgexpnd);
		 Intent i = getIntent();
		 
	        
	        int position = i.getExtras().getInt("id");
	        MYadapter imageAdapter = new MYadapter(this);
	 
	        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
	        imageView.setImageResource(imageAdapter.mThumbIds[position]);
		

	}

	


}
