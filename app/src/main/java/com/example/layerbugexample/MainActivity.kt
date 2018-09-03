package com.example.layerbugexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Scene
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scene2.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scene1 = Scene.getSceneForLayout(sceneContainer, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(sceneContainer, R.layout.scene2, this)
        scene1.setEnterAction {
            scene1.sceneRoot.findViewById<Button>(R.id.btnLogin).setOnClickListener {
                TransitionManager.go(scene2)
            }
        }
        scene2.setEnterAction {
            scene2.sceneRoot.tvBack.setOnClickListener { TransitionManager.go(scene1) }
        }
        scene1.enter()
    }
}
