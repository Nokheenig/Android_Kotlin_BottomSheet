package com.mydomain.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback

class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var textViewState: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewState = findViewById(R.id.textview_state)
        val view : View = findViewById(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(view)

        val buttonOpen: Button = findViewById(R.id.button_open)
        val buttonCollapse: Button = findViewById(R.id.button_collapse)

        buttonOpen.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            textViewState.text = "EXPANDED"
        }
        buttonCollapse.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            textViewState.text = "COLLAPSED"
        }

        bottomSheetBehavior.addBottomSheetCallback(object:BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        textViewState.text = "EXPANDED"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        textViewState.text = "DRAGGING"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        textViewState.text = "SETTLING"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        textViewState.text = "COLLAPSED"
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }
}