package core.di

import core.domain.main.MainDomainInterface
import core.domain.main.TestMainDomain
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun koinModule() {

    val modules = module {
        factory<MainDomainInterface> { TestMainDomain() }
    }

    startKoin {
        modules(modules)
    }
}
