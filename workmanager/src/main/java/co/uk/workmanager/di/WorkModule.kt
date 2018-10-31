package co.uk.workmanager.di

import org.koin.dsl.module.Module

class WorkModule : Module() {
    override fun context() = declareContext {
        provide { }
    }
}