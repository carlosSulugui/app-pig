package com.plusdesarrollo.mpxtoolkit.applist.actions.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.plusdesarrollo.mpxtoolkit.applist.R

class ActionDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {

    var event: (() -> Unit)? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_botton_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val send = view.findViewById<Button>(R.id.button_save)

        send.setOnClickListener(this)


    }
    override fun onClick(click: View?) {
        event?.invoke()
        dismiss()
    }
}