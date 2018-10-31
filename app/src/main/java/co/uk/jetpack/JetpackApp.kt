package co.uk.jetpack

import co.uk.jetpack.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class JetpackApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<JetpackApp> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}