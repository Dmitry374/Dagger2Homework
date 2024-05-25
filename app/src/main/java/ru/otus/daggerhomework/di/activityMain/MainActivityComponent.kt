package ru.otus.daggerhomework.di.activityMain

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorEventSource
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.di.annotation.Activity
import ru.otus.daggerhomework.di.annotation.Application
import ru.otus.daggerhomework.di.annotation.scope.ActivityScope
import ru.otus.daggerhomework.di.application.ApplicationComponent

@ActivityScope
@Component(
    modules = [MainActivityModel::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Application
    fun provideApplicationContext(): Context

    @Activity
    fun provideActivityContext(): Context

    fun provideColorGenerator(): ColorGenerator

    fun provideColorEventSource(): ColorEventSource

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface MainActivityComponentFactory {
        fun create(
            appComponent: ApplicationComponent,
            @BindsInstance activityContext: Context
        ): MainActivityComponent
    }
}