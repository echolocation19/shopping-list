package com.example.shoppinglist.presentation.adapters

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.example.shoppinglist.presentation.ShopItemFragment
import com.example.shoppinglist.presentation.viewmodels.ShopItemViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("textInputLayout")
fun bindTextInputLayout(til: TextInputLayout, isEdited: Boolean) {
    val msg = if (isEdited)
        ShopItemFragment.ERROR_MESSAGE
    else
        null
    til.error = msg
}

@BindingAdapter("textInputName")
fun bindEditTextName(editText: TextInputEditText, viewModel: ShopItemViewModel) {

    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputName()
        }

        override fun afterTextChanged(p0: Editable?) {}
    })
}

@BindingAdapter("textInputCount")
fun bindEditTextCount(editText: TextInputEditText, viewModel: ShopItemViewModel) {

    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            viewModel.resetErrorInputCount()
        }

        override fun afterTextChanged(p0: Editable?) {}
    })
}
