package com.loggertestapp

import android.content.Context
import androidx.lifecycle.Observer
import com.loggertestapp.model.LoggerTableModel
import com.loggertestapp.repository.LogRepository
import com.loggertestapp.viewmodel.LogsViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LogsViewModelTest {

    private lateinit var viewModel: LogsViewModel

    @Mock
    private lateinit var repo: LogRepository

    @Mock
    lateinit var observer: Observer<List<LoggerTableModel>>

    @Mock
    lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = LogsViewModel()
        viewModel.getLogDetails(context)?.observeForever(observer)
    }

    @Test
    fun test_get_all_logs() {
    }
}