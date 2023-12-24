package com.plusdesarrollo.mpxtoolkit.applist.creational.builder

import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote

interface TaskBuilder {
    fun setName (name: String): TaskBuilder
    fun setAddress(address: String): TaskBuilder
    fun setStatus(status: String): TaskBuilder
    fun build(): TaskRemote
}