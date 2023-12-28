package net.braniumacademy.kotlin.ui.factory

import android.content.Context
import android.content.Intent
import net.braniumacademy.kotlin.data.User
import net.braniumacademy.kotlin.ui.detail.UserDetailActivity
import net.braniumacademy.kotlin.ui.newuser.NewUserActivity
import net.braniumacademy.kotlin.ui.updateuser.UpdateUserActivity

class IntentFactoryImpl<T>(private val context: Context) : IntentFactory<T> {
    override fun createIntent(actionType: IntentActionType, obj: T?): Intent {
        return when(actionType) {
            IntentActionType.CREATE -> createIntentToAddNew()
            IntentActionType.EDIT -> createIntentToUpdate(obj)
            IntentActionType.VIEW_DETAIL -> createIntentToViewDetail(obj)
        }
    }

    private fun createIntentToAddNew(): Intent {
        return Intent(context, NewUserActivity::class.java)
    }

    private fun createIntentToUpdate(obj: T?): Intent {
        return Intent(context, UpdateUserActivity::class.java).apply {
            val user = obj as? User
            putExtra(UpdateUserActivity.EXTRA_ID, user?.id)
        }
    }

    private fun createIntentToViewDetail(obj: T?): Intent {
        return Intent(context, UserDetailActivity::class.java).apply {
            val user = obj as? User
            putExtra(UserDetailActivity.EXTRA_ID, user?.id)
        }
    }

}