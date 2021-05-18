package com.rupp.fe.ruppassignment.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.rupp.fe.ruppassignment.R

class Custom(private val context: Context) {
    fun showSnackBar(view: View, title: String) {
        Snackbar.make(view, title, Snackbar.LENGTH_LONG).show()
    }

    fun showSuccessDialog(title: String?, content: String?): MaterialAlertDialogBuilder {
        return MaterialAlertDialogBuilder(context).setTitle(title).setMessage(content)
    }

    fun showProgressBar(): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        progressDialog.setCancelable(false)
        progressDialog.setContentView(R.layout.custom_app_progressbar)
        return progressDialog
    }
}