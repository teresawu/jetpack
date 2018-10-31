package co.uk.jetpack.di

import co.uk.github.di.ActivityModule
import co.uk.github.di.AppModule
import co.uk.github.di.FragmentModule
import co.uk.jetpack.JetpackApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ActivityModule::class), (AppModule::class), (FragmentModule::class)])

interface AppComponent : AndroidInjector<JetpackApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<JetpackApp>()

}