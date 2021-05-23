package au.com.eatclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import au.com.eatclub.models.entitymodels.Opportunity
import com.amplifyframework.core.Amplify
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}