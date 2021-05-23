package au.com.eatclub.di.component

import android.app.Application
import au.com.eatclub.BaseApp
import au.com.eatclub.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class, //All the activities
        RoomBuilderModule::class, //database
        ApplicationBuilderModule::class,
        FragmentBuilderModule::class, //Fragments
        ViewModelFactoryModule::class,
        ViewModelBuilderModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : ApplicationComponent
    }



}