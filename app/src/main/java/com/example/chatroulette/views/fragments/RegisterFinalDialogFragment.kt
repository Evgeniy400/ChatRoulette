package com.example.chatroulette.views.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.chatroulette.R
import com.example.chatroulette.views.FeedActivity
import java.lang.IllegalStateException

class RegisterFinalDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_text)
                .setPositiveButton(R.string.dialog_positive_button) { _, _ ->
                    startActivity(Intent(requireActivity(), FeedActivity::class.java))
                }
                .create()
        } ?: throw IllegalStateException("Activity не может быть null")
    }
}