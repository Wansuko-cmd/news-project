package com.wsr.model.di

import org.koin.core.Koin
import org.koin.core.component.KoinComponent

interface ModelKoinComponent : KoinComponent{
    override fun getKoin(): Koin {
        return KoinContext.koinApplication.koin
    }
}
