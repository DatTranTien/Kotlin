package net.braniumacademy.kotlin.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import net.braniumacademy.kotlin.R
import net.braniumacademy.kotlin.data.User
import net.braniumacademy.kotlin.ui.viewmodel.UserViewModel

class DeleteDialogFragment(
    private val user: User
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setMessage(getString(R.string.text_confirm_delete))
        dialog.setPositiveButton(getString(R.string.text_confirm)) { _, _ ->
            val viewMode = UserViewModel.getInstance()
            viewMode.removeUser(user)
        }
        dialog.setNegativeButton(getString(R.string.text_cancel)) { _, _ ->
            dismiss()
        }
        return dialog.create()
    }
}