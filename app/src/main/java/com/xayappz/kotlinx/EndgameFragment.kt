package com.xayappz.kotlinx

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class EndgameFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(com.xayappz.kotlinx.R.layout.fragment_endgame, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        val button = view.findViewById<Button>(com.xayappz.kotlinx.R.id.restartGameButton)
        button.setOnClickListener { //                navController.navigate(R.id.action_endgameFragment_to_startFragment);
//            val navOptions = NavOptions.Builder().setPopUpTo(com.xayappz.kotlinx.R.id.startFragment, true).build()
//            navController.navigate(com.xayappz.kotlinx.R.id.action_endgameFragment_to_startFragment, null, navOptions)
//
            val intent = Intent(activity, Dashboard::class.java)
            startActivity(intent)
        }
    }
}