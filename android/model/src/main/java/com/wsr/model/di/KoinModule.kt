package com.wsr.model.di

import com.wsr.model.domain.ModelDomainInterface
import com.wsr.model.domain.TestModelDomain
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import kotlin.coroutines.EmptyCoroutineContext.hashCode

internal fun koinModule() {

    val modules = module {
        factory<ModelDomainInterface> { TestModelDomain() }
    }

    loadKoinModules(modules)

//    koinApplication {
//        modules(modules)
//    }
}
