package com.bornintelligence.nedbankgreenbucks

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.google.firebase.firestore.FirebaseFirestore
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestoreSettings


class information : AppCompatActivity() {
    var submit = true;
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        hideSystemUI()


        val rg = findViewById<RadioGroup>(R.id.currentClient);
        val rb_yes = findViewById<RadioButton>(R.id.client_yes);
        val rb_no =findViewById<RadioButton>(R.id.client_no);
        val bold = ResourcesCompat.getFont(this,R.font.nedbanksansblack)
        val normal = ResourcesCompat.getFont(this,R.font.nedbanksansregular)
        rg.setOnCheckedChangeListener { group, checkedId ->
            if(rb_yes.isChecked){
                rb_yes.setTypeface(bold)
                rb_no.setTypeface(normal)
            }
            if(rb_no.isChecked){
                rb_yes.setTypeface(normal)
                rb_no.setTypeface(bold)

            }
        }

        findViewById<TextView>(R.id.submit).setOnTouchListener { v, event ->

            submit = true;
            val in_name = findViewById<EditText>(R.id.et_name)
            val txt_name = in_name.text.toString();
            if(txt_name.length < 3){
                Toast.makeText(this, "Name is to Short", Toast.LENGTH_SHORT).show()
                false
            }
            else {
                val in_number = findViewById<EditText>(R.id.et_number)
                val txt_number = in_number.text.toString();
                val in_id = findViewById<EditText>(R.id.et_id)
                val txt_id = in_id.text.toString();
                var greenback = false
                if (rb_yes.isChecked) {
                    greenback = true
                }
// Create a new user with a first and last name
                val user = HashMap<String, Any>()
                user.put("name", txt_name)
                user.put("number", txt_number)
                user.put("id", txt_id)
                user.put("hasGreenback", greenback)

// Add a new document with a generated ID
                if (submit){
                    submit = false;
                    var db = FirebaseFirestore.getInstance()
                    val settings = FirebaseFirestoreSettings.Builder()
                        .setPersistenceEnabled(true)
                        .build()
                    db.firestoreSettings = settings
                    db.collection("entries")
                    .add(user)
                        .addOnCompleteListener {
                            Log.v("f","damit")
                        }
                    .addOnSuccessListener { documentReference ->
                        submit = true
                    }
                    .addOnFailureListener { e ->
                        Log.v("f","damit")
                    }
                }
                val intent = Intent(this, principles::class.java)
                startActivity(intent)
            true
            }
        }

    }
    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}
