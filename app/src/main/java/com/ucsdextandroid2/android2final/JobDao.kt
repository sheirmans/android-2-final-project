package com.ucsdextandroid2.android2final

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by rjaylward on 2019-07-05
 */

@Dao
interface JobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJob(job: JobItem)

    @Delete
    fun deleteJob(job: JobItem)

    @Query("SELECT * FROM job")
    fun getAllJob(): List<JobItem>

    @Query("SELECT * FROM job ORDER BY DESCR DESC")
    fun getAllJobsLiveData(): LiveData<List<JobItem>>

}
