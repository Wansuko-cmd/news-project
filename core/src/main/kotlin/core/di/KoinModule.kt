package core.di

import core.domain.main.MainDomainInterface
import core.domain.main.TestMainDomain
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.dsl.module

internal fun koinModule() {

    KoinContext.koinApplication = koinApplication{
        modules(module {
            factory<MainDomainInterface> { TestMainDomain() }
        })
    }
}
