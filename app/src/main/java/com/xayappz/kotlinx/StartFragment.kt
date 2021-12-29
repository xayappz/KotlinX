package com.xayappz.kotlinx

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(com.xayappz.kotlinx.R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        val button = view.findViewById<Button>(com.xayappz.kotlinx.R.id.startGameButton)
        button.setOnClickListener { navController.navigate(com.xayappz.kotlinx.R.id.action_startFragment_to_gameFragment) }
    }
}