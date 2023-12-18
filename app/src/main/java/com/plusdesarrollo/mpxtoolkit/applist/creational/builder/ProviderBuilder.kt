package com.plusdesarrollo.mpxtoolkit.applist.creational.builder

import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote

class ProviderBuilder : BuilderInterface {
    private var name: String? = null
    private var phone: String? = null
    private var task_id: String? = null
    private var price: Double? = null
    private var weight: Int? = null
    private var status: String? = null
    private var photo: String? = null
    private var address: String? = null
    override fun setName(name: String): BuilderInterface {
        this.name = name
        return this
    }

    override fun setPhone(phone: String?): BuilderInterface {
        this.phone = phone
        return this
    }

    override fun setId(task_id: String?): BuilderInterface {
        this.task_id = task_id
        return this
    }

    override fun setPrice(price: Double?): BuilderInterface {
        this.price = price
        return this
    }

    override fun setWeight(weight: Int?): BuilderInterface {
        this.weight = weight
        return this
    }

    override fun setStatus(status: String?): BuilderInterface {
        this.status = status
        return this
    }

    override fun setPhoto(photo: String?): BuilderInterface {
        this.photo = photo
        return this
    }

    override fun setAddress(address: String?): BuilderInterface {
        this.address = address
        return this
    }

    override fun build(): ProvidersRemote {
        return ProvidersRemote(
            name,
            phone,
            task_id,
            price,
            weight,
            status,
            photo,
            address
        )
    }
}