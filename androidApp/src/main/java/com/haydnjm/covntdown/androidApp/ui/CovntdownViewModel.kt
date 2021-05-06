package com.haydnjm.covntdown.androidApp.ui

import androidx.lifecycle.ViewModel
import com.haydnjm.covntdown.shared.remote.Infections
import com.haydnjm.covntdown.shared.repository.CovntdownRepository

class CovntdownViewModel(
    private val repo: CovntdownRepository
): ViewModel() {

    fun getData(): Infections {
        return repo.data
    }

}