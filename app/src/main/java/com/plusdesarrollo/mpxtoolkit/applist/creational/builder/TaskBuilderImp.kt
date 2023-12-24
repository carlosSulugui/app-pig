package com.plusdesarrollo.mpxtoolkit.applist.creational.builder

import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote

class TaskBuilderImp : TaskBuilder {

    private var name: String? = null
    private var address: String? = null
    private var status: String? = null
    override fun setName(name: String): TaskBuilder {
        this.name = name
        return this
    }

    override fun setAddress(address: String): TaskBuilder {
        this.address = address
        return this
    }

    override fun setStatus(status: String): TaskBuilder {
        this.status = status
        return this
    }

    override fun build(): TaskRemote {
        return TaskRemote(
            name!!,
            address!!,
            status!!,
            id = "",
            created_at = ""
        )
    }
}