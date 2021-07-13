package core.di

import core.domain.main.MainDomain
import core.domain.main.MainDomainInterface
import core.domain.main.TestMainDomain
import org.koin.dsl.koinApplication
import org.koin.dsl.module

internal fun koinModule() {

    val testModules = module {
        factory<MainDomainInterface> { TestMainDomain() }
    }

    val modules = module {
        factory<MainDomainInterface> { MainDomain() }
    }

    KoinContext.koinApplication = koinApplication{
        modules(modules)
    }
}
