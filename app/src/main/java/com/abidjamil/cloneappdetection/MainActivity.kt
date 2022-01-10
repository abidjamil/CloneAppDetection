package com.abidjamil.cloneappdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cloneDetection = CloneDetection(this, packageName);
        val isClone = cloneDetection.checkAppCloning();
        if(isClone) {
            Toast.makeText(this, cloneDetection.getCloneDetails(), Toast.LENGTH_LONG).show();
        }
    }
}