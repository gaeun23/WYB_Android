package com.wyb.wyb_android.ui.open

import android.app.Application
import androidx.lifecycle.*
import com.wyb.wyb_android.R
import java.util.*

class ChallengeOpenViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application

    private val _randomHint = MutableLiveData<String>()
    val randomHint: LiveData<String> = _randomHint

    val comfort = MutableLiveData("")
    val isInputEmpty = MediatorLiveData<Boolean>().apply {
        addSource(comfort) { this.value = it.isNullOrBlank() }
    }

    val discomfortPos = MutableLiveData(0)
    val discomfortScrollPos = MutableLiveData(0)

    fun getRandomHintString() {
        val hintList = context.resources.getStringArray(R.array.challenge_open_comfort_hint_list)
        val randomIndex = Random().nextInt(hintList.size - 1)
        _randomHint.value = hintList[randomIndex]
    }
}