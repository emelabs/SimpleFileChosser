package com.emelabs.filechooser;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.emelabs.filechooser.FileChooserDialog.Result;

/* ========================================================================
 * Copyright (C) 2011-2012 George Yunaev
 * Based on a dialog chooser from George Yunaev
 * 
 * Copyright 2013 emelabs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */

public class MainActivity extends Activity {

	private ImageButton btExplore;
	private TextView tvSelectedFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btExplore = (ImageButton) findViewById(R.id.btExplore);
		btExplore.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new FileChooserDialog(MainActivity.this, new MyResult(), null);
			}
		});
		
		tvSelectedFile = (TextView) findViewById(R.id.tvSelectedFile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	class MyResult implements Result{
		@Override
		public void onChooseDirectory(File file) {
			tvSelectedFile.setText(getResources().getString(R.string.selected_file_message) + file.getAbsolutePath());
		}
	}
}
