package au.com.eatclub

import android.util.Log
import au.com.eatclub.di.component.DaggerApplicationComponent
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class BaseApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Changing to dagger appplication
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        //Here we also initialize google places sdk or facebook sdk or others sometimes
    }
}