package com.wsr.model.di

import android.app.Application
import com.wsr.model.domain.ModelDomain
import com.wsr.model.domain.ModelDomainInterface
import com.wsr.model.domain.TestModelDomain
import org.koin.dsl.koinApplication
import org.koin.dsl.module

internal fun koinModule(application: Application) {

    val testModules = module {
        factory<ModelDomainInterface> { TestModelDomain() }
    }

    val modules = module {
        factory<ModelDomainInterface> { ModelDomain(application) }
    }

    KoinContext.koinApplication = koinApplication{
        modules(modules)
    }
}
