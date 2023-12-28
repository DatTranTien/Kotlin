package net.braniumacademy.kotlin.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import net.braniumacademy.kotlin.ui.Action
import net.braniumacademy.kotlin.R
import net.braniumacademy.kotlin.ui.viewmodel.UserViewModel

class ConfirmationDialogFragment(
    private val action: Action,
    private val index: Int
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setMessage(getString(R.string.text_confirmation))
        dialog.setPositiveButton(getString(R.string.text_confirm)) { _, _ ->
            val viewModel: UserViewModel = UserViewModel.getInstance()
            if (action == Action.UPPDATE) {
                viewModel.updateUser(index, "Name Updated", "Email Updated")
            } else if (action == Action.DELETE) {
                viewModel.removeUser(index)
            }
        }
        dialog.setNegativeButton(getString(R.string.text_cancel)) { _, _ ->
            dismiss()
        }
        return dialog.create()
    }
}